package application.service;

import application.model.PetSpec;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public interface PetSpecService {

    public void savePetSpec(PetSpec petSpec);
    public void updatePetSpec(PetSpec petSpec);
    public void deletePetSpec(Integer id);
    public PetSpec findPetSpec(Integer id);
    public List<PetSpec> findAllPetSpec();
}
