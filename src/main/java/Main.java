import dao.ProductDao;
import dao.TransactionDao;
import dao.UserDao;
import dao.impl.ProductDaoImpl;
import dao.impl.TransactionDaoImpl;
import dao.impl.UserDaoImpl;
import entity.User;
import enumaration.Role;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException{


        UserDao userDao = new UserDaoImpl();
        User user =new User();
        user.setRole(Role.ADMIN);
        user.setEmail("manuk@emafijfil");
        String pass = "asdqwe";
        user.setPassword(pass);

        user.setLastName("barseghyan");
        user.setFirstName("manuk");
        ProductDao productDao = new ProductDaoImpl();

        TransactionDao transactionDao = new TransactionDaoImpl();
        System.out.println(transactionDao.getAll());
//        System.out.println(userDao.getById(7));
//        System.out.println(userDao.getById(7));
       System.out.println(userDao.getById(7));
        System.out.println(userDao.getById(7));
        System.out.println(userDao.getAll());
        System.out.println(productDao.getAll());
        System.out.println(productDao.getAll());
        System.out.println(productDao.getAll());
        System.out.println(productDao.getAll());

//
//        UserDao userDao = new UserDaoImpl();
//
//        User user = userDao.getById(1);
//
//        System.out.println(user.toString());
//        user.setEmail("manuk@gmail.com");
//        User user1 = user;
//        user1.setRole(Role.ADMIN);
//
//        Product product = new Product();
//
//        product.setBarcode("4447554");
//        product.setPrice(131651);
//        product.setName("apple");
//        product.setCount(10);
//
//
//        ProductDao productDao = new ProductDaoImpl();
//
//        productDao.save(product);
//        productDao.save(product);

//        User user1 = userDao.getById(1);
//        System.out.println(user.toString());
//        user.setEmail("manuk@gmail.com");
//        User user1 = user;
//        user1.setRole(Role.ADMIN);
//
//        System.out.println(user1);
        // userDao.save(user1);

//        user1.setEmail("nsdogibidfgdosd");
//
//        userDao.update(user1);
//
//        System.out.println(Role.getById(1));
//
//        TransactionDao transactionDao = new TransactionDaoImpl();
//        Transaction transaction = new Transaction();
//
//        transaction.setCount(1);
//        transaction.setTypes(TransactionTypes.ADD);
//        transaction.setProductId(1);
//        transaction.setUserId(1);
//        transaction.setCount(1);
//
//
//        System.out.println(transaction.getTypes().toString());
//        transactionDao.save(transaction);
//
    }
}
