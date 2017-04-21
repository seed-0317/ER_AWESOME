package servlet;

import dao.DaoUtilities;
import dao.UserDao;
import model.User;
import service.BusinessLogicLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//logger import
import org.apache.log4j.Logger;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    //logger in class
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = DaoUtilities.getUserDao();

        String name = request.getParameter("username");
        LOGGER.info(name + " is trying to login");

        BusinessLogicLogin bllogin = new BusinessLogicLogin();
        if (!bllogin.usernameValid1(name)) {
            //username input incorrect
            LOGGER.info(name + " not valid at login");
            response.sendRedirect("login");

        } else {

            User user = dao.getUser(name);
            if (user.getuUserName() == null) {
                // user does not exist in database
                LOGGER.info(name + " doesn't exist in the database");
                response.sendRedirect("login");

            } else {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                LOGGER.info(name + " successfully logged in!");
                response.sendRedirect("UpdatePersonalData");


                if (user.getuRole().getUrRole().equals("MANAGER")) {
                    response.sendRedirect("mgrHome.html");
                } else {
                    response.sendRedirect("expenseSubmit.html");
                }


            }
        }
    }
}