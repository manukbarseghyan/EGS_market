import dao.ProductDao;
import dao.TransactionDao;
import dao.UserDao;
import dao.impl.ProductDaoImpl;
import dao.impl.TransactionDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Product;
import entity.Transaction;
import entity.User;
import enumaration.Role;
import enumaration.TransactionTypes;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {


//        UserDao userDao = new UserDaoImpl();
//        User user =new User();
//        user.setRole(Role.ADMIN);
//        user.setEmail("kjsdbksdggdsgjbak");
//        user.setPassword("msdaom");
//        user.setLastName("barseghyan");
//        user.setFirstName("manuk");
//
//        userDao.save(user);

        Product product = new Product();

        product.setBarcode("4447554");
        product.setPrice(131651);
        product.setName("apple");
        product.setCount(10);

        ProductDao productDao = new ProductDaoImpl();
        productDao.save(product);

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
