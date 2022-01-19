package service.impl;

import dao.UserDao;
import entity.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;


    UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User getById(long id){
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean save(User user)  {
       return userDao.save(user);

    }

    @Override
    public boolean update(User user) {
       return userDao.update(user);

    }

    @Override
    public boolean delete(long id){
        return  userDao.delete(id);

    }
}
