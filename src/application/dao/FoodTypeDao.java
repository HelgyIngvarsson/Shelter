package application.dao;

/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * DAO for Food_type object
 */

import application.model.FoodType;

import java.util.List;

public interface FoodTypeDao {
    public void saveFoodType(FoodType foodType);
    public void updateFoodType(FoodType foodType);
    public void deleteFoodType(Integer id);
    public FoodType findFoodType(Integer id);
    public List<FoodType> findAllFoodType();

}
