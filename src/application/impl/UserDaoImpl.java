package application.impl;

import application.HibernateUtil;
import application.dao.UserDao;
import application.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        User user = session.load(User.class,(long)id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User findUser(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where worker.id ="+id);
        List results = query.list();
        if(results.size()!=0) {
            User user = (User) query.list().get(0);
            session.getTransaction().commit();
            session.close();
            return user;
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<User>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        userList = session.createQuery("from User ").list();
        session.getTransaction().commit();
        session.close();
        return userList;
    }

    @Override
    public User validate(String password, String login) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where login=\'"+login+"\' and password =\'"+password+"\'");
        List results = query.list();
        if(results.size()!=0) {
            User user = (User) results.get(0);
            return user;
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }
}
