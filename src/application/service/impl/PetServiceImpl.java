package application.service.impl;

import application.dao.PetDao;
import application.impl.PetDaoImpl;
import application.model.Pet;
import application.service.PetService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetServiceImpl implements PetService {

    private PetDao petDao = new PetDaoImpl();
    @Override
    public void savePet(Pet pet) {
     petDao.savePet(pet);
    }

    @Override
    public void updatePet(Pet pet) {
        petDao.updatePet(pet);
    }

    @Override
    public void deletePet(Integer id) {
        petDao.deletePet(id);
    }

    @Override
    public Pet findPet(Integer id) {
        return petDao.findPet(id);
    }

    @Override
    public List<Pet> findAllPet() {
        return petDao.findAllPet();
    }

    @Override
    public List<Pet> findAllPetByKeeper(Integer id) {
        return petDao.findAllPetByKeeper(id);
    }
}
