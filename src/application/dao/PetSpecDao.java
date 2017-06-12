package application.dao;
/*
 * author Ghavrilin Oleg
 * 02.06.2017.
 * DAO for Pet_spec object
 */


import application.model.PetSpec;

import java.util.List;

public interface PetSpecDao {

    public void savePetSpec(PetSpec petSpec);
    public void updatePetSpec(PetSpec petSpec);
    public void deletePetSpec(Integer id);
    public PetSpec findPetSpec(Integer id);
    public List<PetSpec> findAllPetSpec();
}
