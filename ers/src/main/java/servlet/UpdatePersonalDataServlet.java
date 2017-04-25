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
import org.apache.log4j.Logger;

@WebServlet (value = "/UpdatePersonalData")
public class UpdatePersonalDataServlet extends HttpServlet{

    private static final Logger LOGGER = Logger.getLogger(UpdatePersonalDataServlet.class);

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
        User user = (User) session.getAttribute("user");


        //Amanda code to catch submission errors pre dao call
        BusinessLogicUserInfo bluserinfo = new BusinessLogicUserInfo();
        if (!bluserinfo.usernameValid(username)){
            //username input incorrect
            LOGGER.info("Username entry:" + username +" by " + user.getuID() +" not valid in an update personal data submission");
//            resp.sendRedirect("UpdatePersonalData");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        else if (!bluserinfo.firstNameValid(firstname)){
            //firstname input incorrect
            LOGGER.info("First name entry:" + firstname +" by " + user.getuID() +" not valid in an update personal data submission");
//            resp.sendRedirect("UpdatePersonalData");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        else if (!bluserinfo.lastNameValid(lastname)){
            //lastname input incorrect
            LOGGER.info("Last name entry:" + lastname + " by " + user.getuID() +" not valid in an update personal data submission");
//            resp.sendRedirect("UpdatePersonalData");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

        else if
            (!bluserinfo.emailValid(email)) {
            //email input incorrect
            LOGGER.info("email entry:" + email + " by " + user.getuID() + " not valid in an update personal data submission");
//            resp.sendRedirect("UpdatePersonalData");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        //
        else {

            if(!email.equals(user.getuEmail())){
                LOGGER.info("The email for: "+user.getuID() +" has been updated from: "+user.getuEmail()+" to: "+ email +".");
                user.setuEmail(email);
            }

            if(!firstname.equals(user.getuFirstName())){
                LOGGER.info("The first name for: "+user.getuID() +" has been updated from: "+user.getuFirstName()+" to: "+ firstname +".");
                user.setuFirstName(firstname);
            }

            if(!lastname.equals(user.getuLastName())){
                LOGGER.info("The last name for: "+user.getuID() +" has been updated from: "+user.getuLastName()+" to: "+ lastname +".");
                user.setuLastName(lastname);
            }

            if(!username.equals(user.getuUserName())){
                LOGGER.info("The user name for: "+user.getuID() +" has been updated from: "+user.getuUserName()+" to: "+ username +".");
                user.setuUserName(username);
            }

            UserDaoImpl dao = new UserDaoImpl();
            dao.updateEmployee(user);

            session.setAttribute("user", user);

//            resp.sendRedirect("UpdatePersonalData");
        }
    }
}
