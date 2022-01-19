package servlets;

import connector.BasicConnectionPool;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AccountServlet extends HttpServlet {


    UserDao userDao = new UserDaoImpl();
    User user = new User();
    BasicConnectionPool databaseConnection;

  //  ProductService productService = new ProductionServiceImpl(new ProductDaoImpl());
    List<User> users = userDao.getAll();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(users);
        PrintWriter printWriter = response.getWriter();
        printWriter.println(request.getParameter("user"));


        String firstName = user.getFirstName();
        request.setAttribute("firstName", firstName);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


    }
}
