package project.IAreceita.service;

import org.springframework.stereotype.Service;
import project.IAreceita.DTO.FooditemDTO;
import project.IAreceita.mapper.FooditemMapper;
import project.IAreceita.model.FooditemModel;
import project.IAreceita.repository.FooditemRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FooditemService {

    private final FooditemRepository fooditemRepository;
    private final FooditemMapper fooditemMapper;
    public FooditemService(FooditemRepository fooditemRepository, FooditemMapper fooditemMapper) {
        this.fooditemRepository = fooditemRepository;
        this.fooditemMapper = fooditemMapper;
    }

    public List<FooditemDTO> getAllFood(){
        List<FooditemModel> fooditemModelList = fooditemRepository.findAll();
        return fooditemModelList.stream()
                .map(fooditemMapper::map)
                .collect(Collectors.toList());
    }

    public FooditemDTO saveFood(FooditemDTO fooditemDTO){
        FooditemModel fooditemModel = fooditemMapper.map(fooditemDTO);
        FooditemModel savedModel = fooditemRepository.save(fooditemModel);
        return fooditemMapper.map(savedModel);
    }

    public void deleteFood(Long id){
        fooditemRepository.deleteById(id);
    }

    public FooditemDTO findFoodId(Long id){
        Optional<FooditemModel> fooditemModel = fooditemRepository.findById(id);
        return fooditemModel.map(fooditemMapper::map).orElse(null);
    }

    public FooditemDTO updateFood(Long id, FooditemDTO fooditemDTO){
        Optional<FooditemModel> fooditemModelid = fooditemRepository.findById(id);
        if (fooditemModelid.isPresent()){
            FooditemModel foodSave = fooditemMapper.map(fooditemDTO);
            foodSave.setId(id);
            return fooditemMapper.map(fooditemRepository.save(foodSave));
        }
        return null;
    }
}
