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

/**
 * Created by qzh225 on 4/25/17.
 */
@WebServlet(value = "/filterExpenses")
public class FilterExpensesServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int rStatus;
        int emp;

        HttpSession session = req.getSession();

        if (req.getParameter("status") == null){
            String sfilt =  (String) session.getAttribute("sfilter");
            rStatus = parseInt(sfilt);
        }
        else {
            rStatus =  parseInt(req.getParameter("status"));
            session.setAttribute("sfilter", req.getParameter("status"));
        }

        if (req.getParameter("emp") == null) {
            String efilt = (String) session.getAttribute("ufilter");
            emp = parseInt(efilt);
        }
        else {
            emp =  parseInt(req.getParameter("emp"));
            session.setAttribute("ufilter", req.getParameter("emp"));
        }

        List<Expense> expenseList = new ArrayList<>();
        ExpenseDaoImpl dao = new ExpenseDaoImpl();

        expenseList = dao.getFilteredExpenses(rStatus, emp);

        req.setAttribute("expenselist", expenseList);

        ArrayList<ExpenseStatus> statusList = new ArrayList<>();
        statusList = dao.getExpenseStatusList();

        ArrayList<StatusFilter> statusFilter = new ArrayList<>();
        for (int i=0; i<statusList.size(); i++) {
            StatusFilter sf = new StatusFilter();
            sf.setRsId(statusList.get(i).getRsId());
            sf.setRsStatus(statusList.get(i).getRsStatus());
            if (rStatus == sf.getRsId() ) {
                sf.setSelected("selected");
            }
            else {
                sf.setSelected("");
            }
            statusFilter.add(sf);
        }

        StatusFilter sf = new StatusFilter();
        sf.setRsId(-1);
        sf.setRsStatus("ALL");
        if (rStatus == sf.getRsId() ) {
            sf.setSelected("selected");
        }
        else {
            sf.setSelected("");
        }
        statusFilter.add(sf);
        req.setAttribute("statusList", statusFilter);


        List<User> userList = new ArrayList<>();
        UserDaoImpl udao = new UserDaoImpl();
        userList = udao.getUsersWithExpenses();

        ArrayList<UserFilter> userFilter = new ArrayList<>();
        for (int i=0; i<userList.size(); i++) {
            UserFilter uf = new UserFilter();
            uf.setuID(userList.get(i).getuID());
            uf.setName(userList.get(i).getuFirstName()+" "+userList.get(i).getuLastName());
            if (emp == uf.getuID()) {
                uf.setSelected("selected");
            }
            else {
                uf.setSelected("");
            }
            userFilter.add(uf);
        }

        UserFilter uf = new UserFilter();
        uf.setuID(-1);
        uf.setName("ALL");
        if (emp == uf.getuID()) {
            uf.setSelected("selected");
        }
        else {
            uf.setSelected("");
        }
        userFilter.add(uf);

        req.setAttribute("userList", userFilter);


        req.getRequestDispatcher("mgrHome.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int rStatus;
        int emp;

        HttpSession session = req.getSession();

        if (req.getParameter("status") == null){
            String sfilt =  (String) session.getAttribute("sfilter");
            rStatus = parseInt(sfilt);
        }
        else {
            rStatus =  parseInt(req.getParameter("status"));
            session.setAttribute("sfilter", req.getParameter("status"));
        }

        if (req.getParameter("emp") == null) {
            String efilt = (String) session.getAttribute("ufilter");
            emp = parseInt(efilt);
        }
        else {
            emp =  parseInt(req.getParameter("emp"));
            session.setAttribute("ufilter", req.getParameter("emp"));
        }

        List<Expense> expenseList = new ArrayList<>();
        ExpenseDaoImpl dao = new ExpenseDaoImpl();

        expenseList = dao.getFilteredExpenses(rStatus, emp);

        req.setAttribute("expenselist", expenseList);

        ArrayList<ExpenseStatus> statusList = new ArrayList<>();
        statusList = dao.getExpenseStatusList();

        ArrayList<StatusFilter> statusFilter = new ArrayList<>();
        for (int i=0; i<statusList.size(); i++) {
            StatusFilter sf = new StatusFilter();
            sf.setRsId(statusList.get(i).getRsId());
            sf.setRsStatus(statusList.get(i).getRsStatus());
            if (rStatus == sf.getRsId() ) {
                sf.setSelected("selected");
            }
            else {
                sf.setSelected("");
            }
            statusFilter.add(sf);
        }

        StatusFilter sf = new StatusFilter();
        sf.setRsId(-1);
        sf.setRsStatus("ALL");
        if (rStatus == sf.getRsId() ) {
            sf.setSelected("selected");
        }
        else {
            sf.setSelected("");
        }
        statusFilter.add(sf);
        req.setAttribute("statusList", statusFilter);


        List<User> userList = new ArrayList<>();
        UserDaoImpl udao = new UserDaoImpl();
        userList = udao.getUsersWithExpenses();

        ArrayList<UserFilter> userFilter = new ArrayList<>();
        for (int i=0; i<userList.size(); i++) {
            UserFilter uf = new UserFilter();
            uf.setuID(userList.get(i).getuID());
            uf.setName(userList.get(i).getuFirstName()+" "+userList.get(i).getuLastName());
            if (emp == uf.getuID()) {
                uf.setSelected("selected");
            }
            else {
                uf.setSelected("");
            }
            userFilter.add(uf);
        }

        UserFilter uf = new UserFilter();
        uf.setuID(-1);
        uf.setName("ALL");
        if (emp == uf.getuID()) {
            uf.setSelected("selected");
        }
        else {
            uf.setSelected("");
        }
        userFilter.add(uf);

        req.setAttribute("userList", userFilter);


        req.getRequestDispatcher("mgrHome.html").forward(req,resp);
    }

}
