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
        request.getRequestDispatcher("Index.html").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao dao = DaoUtilities.getUserDao();
        String name = request.getParameter("name");
        User user = dao.getUser(name);

     /*   String email = (String) user.getU_email();
        String username = (String) user.getU_username();
        String firstname = (String) user.getU_firstname();
        String lastname = (String) user.getU_lastname();*/

        if(user.getU_username() == null) {
            response.sendRedirect("login");

        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);


           /* session.setAttribute("username", username);
            session.setAttribute("email", email);
            session.setAttribute("firstname", firstname);
            session.setAttribute("lastname", lastname);*/



            response.sendRedirect("UpdatePersonalData");
        }

    }
}
