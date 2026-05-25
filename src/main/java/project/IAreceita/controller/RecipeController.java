package project.IAreceita.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.IAreceita.DTO.FooditemDTO;
import project.IAreceita.model.FooditemModel;
import project.IAreceita.service.FooditemService;
import project.IAreceita.service.GeminiService;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class RecipeController {

    private final GeminiService geminiService;
    private final FooditemService fooditemService;

    public RecipeController(GeminiService geminiService, FooditemService fooditemService) {
        this.geminiService = geminiService;
        this.fooditemService = fooditemService;
    }

    @GetMapping("/generete")
    public Mono<ResponseEntity<String>> generatRecipe(){
        List<FooditemDTO> fooditemModels = fooditemService.getAllFood();
        return geminiService.generateRecipe(fooditemModels)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}
