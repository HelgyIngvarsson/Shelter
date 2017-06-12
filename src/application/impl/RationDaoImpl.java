package application.impl;

import application.HibernateUtil;
import application.dao.RationDao;
import application.model.Pet;
import application.model.Ration;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class RationDaoImpl implements RationDao {
    @Override
    public void saveRation(Ration ration) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(ration);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateRation(Ration ration) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(ration);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteRation(Pet pet) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
/*        Ration ration = session.load(Ration.class,(long)id);
        session.delete(ration);*/
        session.createQuery("Delete from Ration where pet="+pet).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Ration findRation(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Ration ration = session.load(Ration.class,id);
        session.close();
        return ration;
    }

    @Override
    public List<Ration> findAllRation() {
        List<Ration> rationList = new ArrayList<Ration>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        rationList = session.createQuery("from Ration ").list();
        session.getTransaction().commit();
        session.close();
        return rationList;
    }

    @Override
    public List<Ration> findAllRationByKeeper(Integer id) {
        List<Ration> rationList = new ArrayList<Ration>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
//        rationList = session.createQuery("from Ration where pet.cell.worker.id ="+id).list();
                SQLQuery sqlQuery= session.createSQLQuery("Select r.* from ration r, pet p,cell c,worker w" +
                "  where r.pet_id =p.id and p.cell_id = c.id and c.worker_id = w.id and w.id="+id);
        sqlQuery.addEntity(Ration.class);
        rationList = sqlQuery.list();

        session.getTransaction().commit();
        session.close();
        return rationList;
    }

    @Override
    public Integer getPetId(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
//        rationList = session.createQuery("from Ration where pet.cell.worker.id ="+id).list();
        SQLQuery sqlQuery= session.createSQLQuery("Select pet_id from ration  where id="+id);

        return (Integer) sqlQuery.list().get(0);
    }
}
