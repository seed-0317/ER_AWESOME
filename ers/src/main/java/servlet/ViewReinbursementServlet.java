package servlet;


import dao.DaoUtilities;
import dao.ExpenseDao;
import dao.UserDao;
import model.Expense;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by vso513 on 4/20/17.
 */
@WebServlet (value = "/SubmitReimbursementServlet")
public class ViewReinbursementServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ExpenseDao dao = DaoUtilities.getExpenseDao();
        List<Expense> expense = dao.getAllExpenses();

        req.getSession().setAttribute("expenses", expense);

        req.getRequestDispatcher("expenseSubmit.html").forward(req, resp);
    }

}



//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //super.doPost(req, resp);
//    }
