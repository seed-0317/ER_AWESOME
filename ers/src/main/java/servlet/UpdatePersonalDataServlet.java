package servlet;

import dao.DaoUtilities;
import dao.UserDao;
import dao.UserDaoImpl;
import model.User;
import service.BusinessLogicUserInfo;

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

        User user = (User) session.getAttribute("user");

        req.getRequestDispatcher("empInfo.html").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");

        //Amanda code to catch submission errors pre dao call
        BusinessLogicUserInfo bluserinfo = new BusinessLogicUserInfo();
        if (!bluserinfo.usernameValid(username)){
            //amount input incorrect
            resp.sendRedirect("UpdatePersonalData");
        }

        BusinessLogicUserInfo bluserinfo1 = new BusinessLogicUserInfo();
        if (!bluserinfo1.firstNameValid(firstname)){
            //description input incorrect
            resp.sendRedirect("UpdatePersonalData");
        }

        BusinessLogicUserInfo bluserinfo2 = new BusinessLogicUserInfo();
        if (!bluserinfo2.lastNameValid(lastname)){
            //author input incorrect
            resp.sendRedirect("UpdatePersonalData");
        }
        BusinessLogicUserInfo bluserinfo3 = new BusinessLogicUserInfo();
        if (!bluserinfo3.emailValid(email)){
            //author input incorrect
            resp.sendRedirect("UpdatePersonalData");
        }
        //

        User user = (User) session.getAttribute("user");
        user.setuEmail(email);
        user.setuFirstName(firstname);
        user.setuLastName(lastname);
        user.setuUserName(username);

        UserDaoImpl dao = new UserDaoImpl();
        dao.updateEmployee(user);

        session.setAttribute("user", user);

       resp.sendRedirect("UpdatePersonalData");

    }
}
