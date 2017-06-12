package application.dao;


import application.model.Pet;
import application.model.Ration;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * Dao for Ration entity
 */
public interface RationDao{

    public void saveRation(Ration ration);
    public void updateRation(Ration ration);
    public void deleteRation(Pet pet);
    public Ration findRation(Integer id);
    public List<Ration> findAllRation();
    public List<Ration> findAllRationByKeeper(Integer id);
    public Integer getPetId(Integer id);
}
