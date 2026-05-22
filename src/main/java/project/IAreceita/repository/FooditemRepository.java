package project.IAreceita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.IAreceita.model.FooditemModel;

@Repository
public interface FooditemRepository extends JpaRepository<FooditemModel, Long> {



}
