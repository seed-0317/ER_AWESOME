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


@WebServlet (value = "/SubmitReimbursementServlet")
public class SubmitReimbursementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("expenseSubmit.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        Double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");
        String datesubmitted = req.getParameter("submitted");
        String dateresolved = "";
        String type = req.getParameter("type");
        String author = req.getParameter("author");
        String resolved = "";
        String status = "Submitted";

        

    }
}
