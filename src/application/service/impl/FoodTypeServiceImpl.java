package application.service.impl;

import application.dao.FoodTypeDao;
import application.impl.FoodTypeDaoImpl;
import application.model.FoodType;
import application.service.FoodTypeService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class FoodTypeServiceImpl implements FoodTypeService {
   private FoodTypeDao foodTypeDao = new FoodTypeDaoImpl();

    @Override
    public void saveFoodType(FoodType foodType) {
        foodTypeDao.saveFoodType(foodType);
    }

    @Override
    public void updateFoodType(FoodType foodType) {
        foodTypeDao.updateFoodType(foodType);
    }

    @Override
    public void deleteFoodType(Integer id) {
        foodTypeDao.deleteFoodType(id);
    }

    @Override
    public FoodType findFoodType(Integer id) {
        return foodTypeDao.findFoodType(id);
    }

    @Override
    public List<FoodType> findAllFoodType() {
        return foodTypeDao.findAllFoodType();
    }
}
