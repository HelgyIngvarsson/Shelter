package application.service;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public interface FoodTypeService {

    public void saveFoodType(application.model.FoodType foodType);
    public void updateFoodType(application.model.FoodType foodType);
    public void deleteFoodType(Integer id);
    public application.model.FoodType findFoodType(Integer id);
    public List<application.model.FoodType> findAllFoodType();
}
