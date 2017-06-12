package application.service;

import application.model.Pet;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public interface PetService {
    public void savePet(Pet pet);
    public void updatePet(Pet pet);
    public void deletePet(Integer id);
    public Pet findPet(Integer id);
    public List<Pet> findAllPet();
    public List<Pet> findAllPetByKeeper(Integer id);
}
