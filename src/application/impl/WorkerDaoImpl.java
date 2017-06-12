package application.impl;

import application.HibernateUtil;
import application.dao.WorkerDao;
import application.model.Worker;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class WorkerDaoImpl implements WorkerDao{
    @Override
    public void saveWorker(Worker worker) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateWorker(Worker worker) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteWorker(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Worker worker = session.load(Worker.class,(long)id);
        session.delete(worker);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Worker findWorker(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Worker worker = session.load(Worker.class,(long)id);
        session.close();
        return worker;
    }

    @Override
    public List<Worker> findAllWorker() {
        List<Worker> workerList = new ArrayList<Worker>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        workerList = session.createQuery("from Worker ").list();
        session.getTransaction().commit();
        session.close();
        return workerList;
    }

    @Override
    public List<Worker> findAllKeepers() {
        List<Worker> workerList = new ArrayList<Worker>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        workerList = session.createQuery("from Worker where post.post_name = \'keeper\'").list();
        session.getTransaction().commit();
        session.close();
        return workerList;
    }
}
