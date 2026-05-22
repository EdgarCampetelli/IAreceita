package project.IAreceita.service;

import org.springframework.stereotype.Service;
import project.IAreceita.model.FooditemModel;
import project.IAreceita.repository.FooditemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FooditemService {

    private final FooditemRepository fooditemRepository;
    public FooditemService(FooditemRepository fooditemRepository) {
        this.fooditemRepository = fooditemRepository;
    }

    public List<FooditemModel> getAllFood(){
        return fooditemRepository.findAll();
    }

    public FooditemModel saveFood(FooditemModel fooditemModel){
        return fooditemRepository.save(fooditemModel);
    }

    public void deleteFood(Long id){
        fooditemRepository.deleteById(id);
    }

    public FooditemModel findFoodId(Long id){
        Optional<FooditemModel> fooditemModel = fooditemRepository.findById(id);
        return fooditemModel.orElse(null);
    }

    public FooditemModel updateFood(FooditemModel fooditemModel){
        return fooditemRepository.save(fooditemModel);
    }
}
