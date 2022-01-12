import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import enumaration.Role;
import service.UserServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {


        UserDao userDao = new UserDaoImpl();

        User user = userDao.getById(1);
        System.out.println(user.toString());
        user.setEmail("manuk@gmail.com");
        User user1 = user;
        user1.setRole(Role.ADMIN);

        System.out.println(user1);
       // userDao.save(user1);

        user1.setEmail("nsdogibidfgdosd");

        userDao.update(user1);
    }
}
