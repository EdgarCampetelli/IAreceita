package project.IAreceita.mapper;

import org.springframework.stereotype.Component;
import project.IAreceita.DTO.FooditemDTO;
import project.IAreceita.model.FooditemModel;

@Component
public class FooditemMapper {

    public FooditemModel map(FooditemDTO fooditemDTO){
        FooditemModel fooditemModel = new FooditemModel();
        fooditemModel.setId(fooditemDTO.getId());
        fooditemModel.setNome(fooditemDTO.getNome());
        fooditemModel.setCategoria(fooditemModel.getCategoria());
        fooditemModel.setQuantidade(fooditemDTO.getQuantidade());
        fooditemModel.setValidade(fooditemDTO.getValidade());
        return fooditemModel;
    }

    public FooditemDTO map(FooditemModel fooditemModel){
        FooditemDTO fooditemDTO = new FooditemDTO();
        fooditemDTO.setId(fooditemDTO.getId());
        fooditemDTO.setNome(fooditemDTO.getNome());
        fooditemDTO.setCategoria(fooditemDTO.getCategoria());
        fooditemDTO.setQuantidade(fooditemDTO.getQuantidade());
        fooditemDTO.setValidade(fooditemDTO.getValidade());
        return fooditemDTO;
    }

}
