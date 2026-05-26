package project.IAreceita.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.IAreceita.DTO.FooditemDTO;
import project.IAreceita.service.FooditemService;

import java.util.List;


@Controller

public class menuController {

    private final FooditemService fooditemService;

    public menuController(FooditemService fooditemService) {
        this.fooditemService = fooditemService;
    }

    @GetMapping("/menu")
    public String menuPg(Model model){
        List<FooditemDTO> fooditemDTOS = fooditemService.getAllFood();
        model.addAttribute("foods",fooditemDTOS);
        return "menu";
    }

    @PostMapping("/updateFood")
    public String updateFoodId(@ModelAttribute FooditemDTO fooditemDTO){
        fooditemService.updateFood(fooditemDTO.getId(), fooditemDTO);
        return "redirect:/menu";
    }

    @PostMapping("/deleteFood")
    public String processDeleteFood(@RequestParam("id") Long id) {
        fooditemService.deleteFood(id);
        return "redirect:/menu";
    }

    @PostMapping("/saveFood")
    public String saveFood(@ModelAttribute FooditemDTO fooditemDTO){
        fooditemService.saveFood(fooditemDTO);
        return "redirect:/menu";
    }
;}
