package application.impl;

import application.HibernateUtil;
import application.dao.FoodTypeDao;
import application.model.FoodType;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class FoodTypeDaoImpl implements FoodTypeDao {


    @Override
    public void saveFoodType(FoodType foodType) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(foodType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateFoodType(FoodType foodType) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(foodType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteFoodType(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        FoodType foodType = session.load(FoodType.class,id);
        session.delete(foodType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public FoodType findFoodType(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        FoodType foodType = session.load(FoodType.class,id);
        session.close();
        return foodType;
    }

    @Override
    public List<FoodType> findAllFoodType() {
        List<FoodType> foodTypeList = new ArrayList<FoodType>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        foodTypeList = session.createQuery("from FoodType ").list();
        session.getTransaction().commit();
        session.close();
        return foodTypeList;
    }
}
