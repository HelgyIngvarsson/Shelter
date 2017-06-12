package application.service;


import application.model.User;

import java.util.List;

/**
 * author Gavrilin Oleg
 * 03.06.2017.
 * Dao for User entity
 */
public interface UserService {

    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(Integer id);
    public User findUser(Integer id);
    public List<User> findAllUser();
    public User validate(String password,String login);
}
