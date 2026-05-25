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
        fooditemModel.setCategoria(fooditemDTO.getCategoria());
        fooditemModel.setQuantidade(fooditemDTO.getQuantidade());
        fooditemModel.setValidade(fooditemDTO.getValidade());
        return fooditemModel;
    }

    public FooditemDTO map(FooditemModel fooditemModel){
        FooditemDTO fooditemDTO = new FooditemDTO();
        fooditemDTO.setId(fooditemModel.getId());
        fooditemDTO.setNome(fooditemModel.getNome());
        fooditemDTO.setCategoria(fooditemModel.getCategoria());
        fooditemDTO.setQuantidade(fooditemModel.getQuantidade());
        fooditemDTO.setValidade(fooditemModel.getValidade());
        return fooditemDTO;
    }

}
