package application.dao;

import application.model.TypeSpec;

import java.util.List;

/**
 * author Ghavrilin Oleg
 * 02.06.2017
 * Dao for type_spec
 */
public interface TypeSpecDao{

    public void saveTypeSpec(TypeSpec typeSpec);
    public void updateTypeSpec(TypeSpec typeSpec);
    public void deleteTypeSpec(Integer id);
    public TypeSpec findTypeSpec(Integer id);
    public List<TypeSpec> findAllTypeSpec();
}
