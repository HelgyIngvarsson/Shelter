package application.impl;

import application.HibernateUtil;
import application.dao.PostDao;
import application.model.Post;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PostDaoImpl implements PostDao {
    @Override
    public void savePost(Post post) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updatePost(Post post) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deletePost(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Post post = session.load(Post.class,id);
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Post findPost(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Post post = session.load(Post.class,id);
        session.close();
        return post;
    }

    @Override
    public List<Post> findAllPost() {
        List<Post> postList = new ArrayList<Post>();
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        postList = session.createQuery("from Post ").list();
        session.getTransaction().commit();
        session.close();
        return postList;
    }
}
