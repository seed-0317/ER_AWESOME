package servlet;

import dao.DaoUtilities;
import dao.UserDao;
import model.User;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (value = "/UpdatePersonalData")
public class UpdatePersonalDataServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
       /* String username = (String) session.getAttribute("username");
        String lastname = (String) session.getAttribute("lastname");
        String firstname = (String) session.getAttribute("firstname");
        String email = (String) session.getAttribute("email");
*/

       User user = (User) session.getAttribute("user");

        req.getRequestDispatcher("empInfo.html").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}