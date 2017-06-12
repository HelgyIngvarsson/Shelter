package application.dao;

import application.model.MedObserv;

import java.util.List;

/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * DAO for med_observ object
 */
public interface MedObservDao {

    public void saveMedObserv(MedObserv medObserv);
    public void updateMedObserv(MedObserv medObserv);
    public void deleteMedObserv(Integer id);
    public MedObserv findMedObserv(Integer id);
    public List<MedObserv> findAllMedObserv();
}
