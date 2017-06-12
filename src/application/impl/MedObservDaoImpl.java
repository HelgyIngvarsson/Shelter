package application.impl;

import application.HibernateUtil;
import application.dao.MedObservDao;
import application.model.MedObserv;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class MedObservDaoImpl implements MedObservDao {
    @Override
    public void saveMedObserv(MedObserv medObserv) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(medObserv);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateMedObserv(MedObserv medObserv) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(medObserv);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteMedObserv(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        MedObserv medObserv = session.load(MedObserv.class,(long)id);
        session.delete(medObserv);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public MedObserv findMedObserv(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        MedObserv medObserv = session.load(MedObserv.class,id);
        session.close();
        return medObserv;
    }

    @Override
    public List<MedObserv> findAllMedObserv() {
        List<MedObserv> medObservList = new ArrayList<MedObserv>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        medObservList = session.createQuery("from MedObserv ").list();
        session.getTransaction().commit();
        session.close();
        return medObservList;
    }
}
