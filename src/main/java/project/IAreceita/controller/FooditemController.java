package project.IAreceita.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.IAreceita.DTO.FooditemDTO;
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
    public ResponseEntity<List<FooditemDTO>> getFooditem(){
        return ResponseEntity.ok(fooditemService.getAllFood());
    }

    @GetMapping("/readFood/{id}")
    public ResponseEntity<?> getFooditemId(@PathVariable Long id){
        FooditemDTO food = fooditemService.findFoodId(id);
        if (food != null){
            return ResponseEntity.ok(food);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar dados !");
    }

    @PostMapping("/post")
    public ResponseEntity<FooditemDTO> saveFood(@RequestBody FooditemDTO fooditemDTO){
        fooditemService.saveFood(fooditemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(fooditemDTO);
    }

    @PutMapping("/updateFood/{id}")
    public ResponseEntity<?> updateFoodId(@PathVariable Long id, @RequestBody FooditemDTO fooditemDTO){
        FooditemDTO foodSaveId = fooditemService.findFoodId(id);
        if (foodSaveId != null){
            return ResponseEntity.ok(fooditemService.updateFood(id, fooditemDTO));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar dados !");
    }

    @DeleteMapping("/deleteFood/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id){
        FooditemDTO foodSaveId = fooditemService.findFoodId(id);
        if (foodSaveId != null){
            fooditemService.deleteFood(id);
            return ResponseEntity.ok().body("Deletado !");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar dados !");
    }
}
