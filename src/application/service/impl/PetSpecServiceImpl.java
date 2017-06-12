package application.service.impl;

import application.dao.PetSpecDao;
import application.impl.PetSpecDaoImpl;
import application.model.PetSpec;
import application.service.PetSpecService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetSpecServiceImpl implements PetSpecService{

    private PetSpecDao petSpecDao = new PetSpecDaoImpl();

    @Override
    public void savePetSpec(PetSpec petSpec) {
        petSpecDao.savePetSpec(petSpec);
    }

    @Override
    public void updatePetSpec(PetSpec petSpec) {
        petSpecDao.updatePetSpec(petSpec);
    }

    @Override
    public void deletePetSpec(Integer id) {
        petSpecDao.deletePetSpec(id);
    }

    @Override
    public PetSpec findPetSpec(Integer id) {
        return petSpecDao.findPetSpec(id);
    }

    @Override
    public List<PetSpec> findAllPetSpec() {
        return petSpecDao.findAllPetSpec();
    }
}
