package project.IAreceita.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${gemini.url.base}")
    private String urlGemini;

    @Bean
    public WebClient webClient(){
        return  WebClient
                .builder()
                .baseUrl(urlGemini)
                .build();
    }
}
