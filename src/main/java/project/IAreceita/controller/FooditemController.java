package project.IAreceita.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.IAreceita.model.FooditemModel;
import project.IAreceita.service.FooditemService;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FooditemController {

    private final FooditemService fooditemService;

    public FooditemController(FooditemService fooditemService) {
        this.fooditemService = fooditemService;
    }

    @GetMapping("/readAllFood")
    public ResponseEntity<List<FooditemModel>> getFooditem(){
        return ResponseEntity.ok(fooditemService.getAllFood());
    }

    @GetMapping("/readFood/{id}")
    public ResponseEntity<?> getFooditemId(@PathVariable Long id){
        FooditemModel food = fooditemService.findFoodId(id);
        if (food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar dados !");
    }

    @PostMapping("/post")
    public ResponseEntity<FooditemModel> saveFood(@RequestBody FooditemModel fooditemModel){
        fooditemService.saveFood(fooditemModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fooditemModel);
    }

    @PutMapping("/updateFood/{id}")
    public ResponseEntity<?> updateFoodId(@PathVariable Long id, @RequestBody FooditemModel fooditemModel){
        FooditemModel foodSaveId = fooditemService.findFoodId(id);
        if (foodSaveId != null){
            fooditemModel.setId(id);
            return ResponseEntity.ok(fooditemService.updateFood(fooditemModel));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar dados !");
    }

    @DeleteMapping("/deleteFood/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id){
        FooditemModel foodSaveId = fooditemService.findFoodId(id);
        if (foodSaveId != null){
            fooditemService.deleteFood(id);
            return ResponseEntity.ok().body("Deletado !");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar dados !");
    }
}
