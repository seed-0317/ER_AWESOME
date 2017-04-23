package servlet;

import dao.ExpenseDaoImpl;
import model.Expense;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (value = "/ManagerView")
public class ManagerViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Expense> expenseList = new ArrayList<>();
        ExpenseDaoImpl dao = new ExpenseDaoImpl();

        expenseList = dao.getAllExpenses();

        req.setAttribute("expenselist", expenseList);

        req.getRequestDispatcher("mgrHome.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Expense> expenseList = new ArrayList<>();

        ExpenseDaoImpl dao = new ExpenseDaoImpl();

        expenseList = dao.getAllExpenses();

        req.setAttribute("expenselist", expenseList);

        req.getRequestDispatcher("mgrHome.html").forward(req,resp);
    }
}
