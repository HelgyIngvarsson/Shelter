package application.service.impl;

import application.dao.PetTypeDao;
import application.impl.PetTypeDaoImpl;
import application.model.PetType;
import application.service.PetTypeService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PetTypeServiceImpl implements PetTypeService {

    private PetTypeDao petTypeDao = new PetTypeDaoImpl();

    @Override
    public void savePetType(PetType petType) {
        petTypeDao.savePetType(petType);
    }

    @Override
    public void updatePetType(PetType petType) {
        petTypeDao.updatePetType(petType);
    }

    @Override
    public void deletePetType(Integer id) {
        petTypeDao.deletePetType(id);
    }

    @Override
    public PetType findPetType(Integer id) {
        return petTypeDao.findPetType(id);
    }

    @Override
    public List<PetType> findAllPetType() {
        return petTypeDao.findAllPetType();
    }
}
