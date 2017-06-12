package application.dao;


import application.model.PetType;

import java.util.List;

/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * DAO for pet_type object
 */
public interface PetTypeDao{

    public void savePetType(PetType petType);
    public void updatePetType(PetType petType);
    public void deletePetType(Integer id);
    public PetType findPetType(Integer id);
    public List<PetType> findAllPetType();
}
