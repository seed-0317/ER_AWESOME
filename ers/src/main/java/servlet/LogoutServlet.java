package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import model.User;
import org.apache.log4j.Logger;

/**
 * Created by npw383 on 4/19/17.
 */

    @WebServlet(value = "/logout")
    public class LogoutServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        LOGGER.info(user.getuID() + " successfully logged out!");
        req.getSession().invalidate();
        resp.sendRedirect("login");
    }
}
