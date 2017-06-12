package application.service.impl;

import application.dao.UserDao;
import application.impl.UserDaoImpl;
import application.model.User;
import application.service.UserService;

import java.util.List;

/**
 * Created by ЖЛЗК on 10.06.2017.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void saveUser(User user) {
      userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User findUser(Integer id) {
        return userDao.findUser(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public User validate(String password, String login) {
        return userDao.validate(password, login);
    }
}
