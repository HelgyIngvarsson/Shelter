package application.service;

import application.model.MedObserv;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public interface MedObservService {
    public void saveMedObserv(MedObserv medObserv);
    public void updateMedObserv(MedObserv medObserv);
    public void deleteMedObserv(Integer id);
    public MedObserv findMedObserv(Integer id);
    public List<MedObserv> findAllMedObserv();
}
