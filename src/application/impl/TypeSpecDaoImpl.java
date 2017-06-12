package application.impl;

import application.HibernateUtil;
import application.dao.TypeSpecDao;
import application.model.TypeSpec;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class TypeSpecDaoImpl implements TypeSpecDao {
    @Override
    public void saveTypeSpec(TypeSpec typeSpec) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(typeSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateTypeSpec(TypeSpec typeSpec) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(typeSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTypeSpec(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        TypeSpec typeSpec = session.load(TypeSpec.class,id);
        session.delete(typeSpec);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public TypeSpec findTypeSpec(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        TypeSpec typeSpec = session.load(TypeSpec.class,id);
        session.close();
        return typeSpec;
    }

    @Override
    public List<TypeSpec> findAllTypeSpec() {
        List<TypeSpec> typeSpecList = new ArrayList<TypeSpec>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        typeSpecList = session.createQuery("from TypeSpec ").list();
        session.getTransaction().commit();
        session.close();
        return typeSpecList;
    }
}
