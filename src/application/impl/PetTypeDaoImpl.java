package application.impl;

import application.HibernateUtil;
import application.dao.PetTypeDao;
import application.model.PetType;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetTypeDaoImpl implements PetTypeDao {
    @Override
    public void savePetType(PetType petType) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(petType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePetType(PetType petType) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(petType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePetType(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        PetType petType = session.load(PetType.class,(long)id);
        session.delete(petType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public PetType findPetType(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        PetType petType = session.load(PetType.class,id);
        session.close();
        return petType;
    }

    @Override
    public List<PetType> findAllPetType() {
        List<PetType> petTypeList = new ArrayList<PetType>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        petTypeList = session.createQuery("from PetType ").list();
        session.getTransaction().commit();
        session.close();
        return petTypeList;
    }
}
