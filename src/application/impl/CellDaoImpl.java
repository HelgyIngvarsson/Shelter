package application.impl;

import application.HibernateUtil;
import application.dao.CellDao;
import application.model.Cell;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class CellDaoImpl implements CellDao {


    @Override
    public void saveCell(Cell cell) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(cell);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateCell(Cell cell) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(cell);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteCell(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Cell cell = session.load(Cell.class,(long)id);
        session.delete(cell);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Cell findCell(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Cell cell = session.load(Cell.class,id);
        session.close();
        return cell;
    }

    @Override
    public List<Cell> findAllCell() {
        List<Cell> cellList = new ArrayList<Cell>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        cellList = session.createQuery("from Cell ").list();
        session.getTransaction().commit();
        session.close();
        return cellList;
    }
}
