package service;

import dao.impl.UserDaoImpl;
import entity.User;
import service.services.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao ;

    @Override
    public User getById(long id) throws SQLException {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDao.getAll();
    }

    @Override
    public void save(User user) throws SQLException {
        userDao.save(user);

    }

    @Override
    public void update(User user) throws SQLException {
        userDao.update(user);

    }

    @Override
    public void delete(long id) throws SQLException {
        userDao.delete(id);

    }
}
