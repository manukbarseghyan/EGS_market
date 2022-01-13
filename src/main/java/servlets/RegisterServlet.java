package servlets;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import enumaration.Role;
import service.UserServiceImpl;
import service.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {

        User user = new User();
        user.setFirstName(String.valueOf(request.getParameter("first_name")));
        user.setLastName(String.valueOf(request.getParameter("last_name")));
        user.setEmail(String.valueOf(request.getParameter("email")));
        user.setPassword(String.valueOf(request.getParameter("password")));
        user.setRole(Role.ADMIN);
        try {
            PrintWriter pw = response.getWriter();
            pw.println(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        UserDao userDao = new UserDaoImpl();
        try {
            userDao.save(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
