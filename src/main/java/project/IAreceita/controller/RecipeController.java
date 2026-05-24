package project.IAreceita.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.IAreceita.service.GeminiService;
import reactor.core.publisher.Mono;

@RestController
public class RecipeController {

    private final GeminiService geminiService;

    public RecipeController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/generete")
    public Mono<ResponseEntity<String>> generatRecipe(){
        return geminiService.generateRecipe()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
