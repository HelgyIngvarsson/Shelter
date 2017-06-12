package application.impl;

import application.HibernateUtil;
import application.dao.PetSpecDao;
import application.model.PetSpec;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetSpecDaoImpl implements PetSpecDao {
    @Override
    public void savePetSpec(PetSpec petSpec) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(petSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePetSpec(PetSpec petSpec) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(petSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePetSpec(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        PetSpec petSpec = session.load(PetSpec.class,id);
        session.delete(petSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PetSpec findPetSpec(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        PetSpec petSpec = session.load(PetSpec.class,id);
        session.close();
        return petSpec;
    }

    @Override
    public List<PetSpec> findAllPetSpec() {
        List<PetSpec> petSpecList = new ArrayList<PetSpec>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        petSpecList = session.createQuery("from PetSpec ").list();
        session.getTransaction().commit();
        session.close();
        return petSpecList;
    }
}
