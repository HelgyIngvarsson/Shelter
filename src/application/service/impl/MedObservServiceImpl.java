package application.service.impl;

import application.dao.MedObservDao;
import application.impl.MedObservDaoImpl;
import application.model.MedObserv;
import application.service.MedObservService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class MedObservServiceImpl implements MedObservService {

    private MedObservDao medObservDao = new MedObservDaoImpl();

    @Override
    public void saveMedObserv(MedObserv medObserv) {
        medObservDao.saveMedObserv(medObserv);
    }

    @Override
    public void updateMedObserv(MedObserv medObserv) {
        medObservDao.updateMedObserv(medObserv);
    }

    @Override
    public void deleteMedObserv(Integer id) {
        medObservDao.deleteMedObserv(id);
    }

    @Override
    public MedObserv findMedObserv(Integer id) {
        return medObservDao.findMedObserv(id);
    }

    @Override
    public List<MedObserv> findAllMedObserv() {
        return medObservDao.findAllMedObserv();
    }
}
