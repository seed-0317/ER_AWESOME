package servlet;

import dao.DaoUtilities;
import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = DaoUtilities.getUserDao();
        String name = request.getParameter("username");
        User user = dao.getUser(name);

        if(user.getuUserName() == null) {
            response.sendRedirect("login");

        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("UpdatePersonalData");
        }

    }
}
