package servlet;

import dao.ExpenseDaoImpl;
import dao.UserDaoImpl;
import model.Expense;
import model.ExpenseStatus;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by qzh225 on 4/25/17.
 */
@WebServlet(value = "/filterExpenses")
public class FilterExpensesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Expense> expenseList = new ArrayList<>();
        ExpenseDaoImpl dao = new ExpenseDaoImpl();

        int rStatus =  parseInt(req.getParameter("status"));
        int emp =  parseInt(req.getParameter("emp"));

        System.out.println("rStatus= " + rStatus + "emp = " + emp);

        expenseList = dao.getFilteredExpenses(rStatus, emp);

        req.setAttribute("expenselist", expenseList);

        ArrayList<ExpenseStatus> statusList = new ArrayList<>();
        statusList = dao.getExpenseStatusList();

        req.setAttribute("statusList", statusList);

        List<User> userList = new ArrayList<>();
        UserDaoImpl udao = new UserDaoImpl();
        userList = udao.getUsersWithExpenses();

        req.setAttribute("userList", userList);

        req.getRequestDispatcher("mgrHome.html").forward(req,resp);
    }




}
