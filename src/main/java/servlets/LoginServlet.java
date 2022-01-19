package servlets;

import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static enumaration.Role.ADMIN;
import static enumaration.Role.SELLER;

public class LoginServlet extends HttpServlet {

    UserDaoImpl userDao = new UserDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        User user = userDao.login(username, password);
        System.out.println(user.toString());

        if (user.getRole().equals(SELLER)) {

            response.sendRedirect("/account?user=" + user.getId());

        } else if (user.getRole().equals(ADMIN)) {
            response.sendRedirect("/admin");

        } else {
            out.print("Sorry username or password error");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.include(request, response);
        }
    }
}
