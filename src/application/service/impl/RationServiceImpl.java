package application.service.impl;

import application.dao.RationDao;
import application.impl.RationDaoImpl;
import application.model.Pet;
import application.model.Ration;
import application.service.RationService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class RationServiceImpl implements RationService {

    private RationDao rationDao = new RationDaoImpl();

    @Override
    public void saveRation(Ration ration) {
        rationDao.saveRation(ration);
    }

    @Override
    public void updateRation(Ration ration) {
        rationDao.updateRation(ration);
    }

    @Override
    public void deleteRation(Pet pet) {
        rationDao.deleteRation(pet);
    }

    @Override
    public Ration findRation(Integer id) {
        return rationDao.findRation(id);
    }

    @Override
    public List<Ration> findAllRationByKeeper(Integer id) {
        return rationDao.findAllRationByKeeper(id);
    }

    @Override
    public List<Ration> findAllRation() {
        return rationDao.findAllRation();
    }

    @Override
    public Integer getPetId(Integer id) {
        return rationDao.getPetId(id);
    }
}
