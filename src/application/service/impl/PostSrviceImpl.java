package application.service.impl;

import application.dao.PostDao;
import application.impl.PostDaoImpl;
import application.model.Post;
import application.service.PostService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class PostSrviceImpl implements PostService {

    private PostDao postDao = new PostDaoImpl();

    @Override
    public void savePost(Post post) {
        postDao.savePost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public void deletePost(Integer id) {
        postDao.deletePost(id);
    }

    @Override
    public Post findPost(Integer id) {
        return postDao.findPost(id);
    }

    @Override
    public List<Post> findAllPost() {
        return postDao.findAllPost();
    }
}
