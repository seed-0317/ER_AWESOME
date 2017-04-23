package servlet;

import dao.DaoUtilities;
import dao.ExpenseDao;
import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;

import static java.lang.Integer.parseInt;


/**
 * Created by qzh225 on 4/21/17.
 */
@WebServlet(value = "/approve")
public class ApproveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDao udao = DaoUtilities.getUserDao();
        ExpenseDao edao = DaoUtilities.getExpenseDao();

        int rID =  parseInt(request.getParameter("r_id"));
        User user = (User)session.getAttribute("user");

        Timestamp approveTime = new Timestamp(System.currentTimeMillis());

        edao.ApproveReimbursement(rID, user.getuID(), approveTime );

        request.getRequestDispatcher("ManagerView").forward(request,response);
    }
}
