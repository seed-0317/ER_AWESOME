package servlet;

import dao.ExpenseDaoImpl;
import dao.UserDaoImpl;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@WebServlet (value = "/ManagerView")
public class ManagerViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        if (session.getAttribute("ufilter") == null) {
            session.setAttribute("ufilter", "-1");
        }
        if (session.getAttribute("sfilter") == null) {
            session.setAttribute("sfilter", "-1");
        }

        req.getRequestDispatcher("filterExpenses").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        if (session.getAttribute("ufilter") == null) {
            session.setAttribute("ufilter", "-1");
        }
        if (session.getAttribute("sfilter") == null) {
            session.setAttribute("sfilter", "-1");
        }

        req.getRequestDispatcher("filterExpenses").forward(req,resp);
    }


}

