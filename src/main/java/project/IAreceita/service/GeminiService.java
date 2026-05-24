package project.IAreceita.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class GeminiService {

    private final WebClient webClient;
    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Value("${gemini.api.key}")
    public String apiKey;

    @Value("${gemini.url.base}")
    public String url;

    public Mono<String> generateRecipe(){
        String prompt= "Faca uma receita de bolo de cenoura:";
        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );
        return webClient.post()
                .header("x-goog-api-key",apiKey)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map( response -> {
                    var candidates = (List<Map<String, Object>>) response.get("candidates");
                    if (candidates != null && !candidates.isEmpty()) {
                        var content = (Map<String, Object>) candidates.get(0).get("content");
                        if (content != null) {
                            var parts = (List<Map<String, Object>>) content.get("parts");
                            if (parts != null && !parts.isEmpty()) {
                                return parts.get(0).get("text").toString();
                            }
                        }
                    }
                    return "Nenhuma receita foi gerada.";
                });
    }

}
