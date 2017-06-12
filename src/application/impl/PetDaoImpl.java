package application.impl;

import application.HibernateUtil;
import application.dao.PetDao;
import application.model.Pet;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetDaoImpl implements PetDao {

    @Override
    public void savePet(Pet pet) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(pet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePet(Pet pet) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(pet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePet(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Pet pet = session.load(Pet.class,(long)id);
        session.delete(pet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Pet findPet(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Pet pet = session.load(Pet.class,(long)id);
        session.close();
        return pet;
    }

    @Override
    public List<Pet> findAllPet() {
        List<Pet> petObservList = new ArrayList<Pet>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        petObservList = session.createQuery("from Pet ").list();
        session.getTransaction().commit();
        session.close();
        return petObservList;
    }

    @Override
    public List<Pet> findAllPetByKeeper(Integer id) {
        List<Pet> petObservList = new ArrayList<Pet>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        petObservList = session.createQuery("from Pet where cell.worker.id ="+id).list();
        session.getTransaction().commit();
        session.close();
        return petObservList;
    }


}
