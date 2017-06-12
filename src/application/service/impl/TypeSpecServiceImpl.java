package application.service.impl;

import application.dao.TypeSpecDao;
import application.impl.TypeSpecDaoImpl;
import application.model.TypeSpec;
import application.service.TypeSpecService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class TypeSpecServiceImpl implements TypeSpecService {

    private TypeSpecDao typeSpecDao = new TypeSpecDaoImpl();

    @Override
    public void saveTypeSpec(TypeSpec typeSpec) {
        typeSpecDao.saveTypeSpec(typeSpec);
    }

    @Override
    public void updateTypeSpec(TypeSpec typeSpec) {
        typeSpecDao.updateTypeSpec(typeSpec);
    }

    @Override
    public void deleteTypeSpec(Integer id) {
        typeSpecDao.deleteTypeSpec(id);
    }

    @Override
    public TypeSpec findTypeSpec(Integer id) {
        return typeSpecDao.findTypeSpec(id);
    }

    @Override
    public List<TypeSpec> findAllTypeSpec() {
        return typeSpecDao.findAllTypeSpec();
    }
}
