package application.service;


import application.model.Post;

import java.util.List;

/**
 * author Ghavrilin Oleg
 * 02.06.2017.
 * Dao for Post object
 */
public interface PostService {

    public void savePost(Post post);
    public void updatePost(Post post);
    public void deletePost(Integer id);
    public Post findPost(Integer id);
    public List<Post> findAllPost();
}
