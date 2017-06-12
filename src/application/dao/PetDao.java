package application.dao;

import application.model.Pet;

import java.util.List;

/*
author Ghavrilin Oleg
02.06.2017
DAO interface for Pet object
 */
public interface PetDao{
    public void savePet(Pet pet);
    public void updatePet(Pet pet);
    public void deletePet(Integer id);
    public Pet findPet(Integer id);
    public List<Pet> findAllPet();
    public List<Pet> findAllPetByKeeper(Integer id);

}
