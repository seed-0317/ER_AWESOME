package servlet;

import dao.DaoUtilities;
import dao.ExpenseDao;
import dao.UserDao;
import model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Created by qzh225 on 4/23/17.
 */
@WebServlet(value = "deny")
public class DenyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException

        HttpSession session = request.getSession();
        UserDao udao = DaoUtilities.getUserDao();
        ExpenseDao edao = DaoUtilities.getExpenseDao();

        int rID =  parseInt(request.getParameter("r_id"));
        User user = (User)session.getAttribute("user");

        Timestamp denyTime = new Timestamp(System.currentTimeMillis());

        edao.DenyReimbursement(rID, user.getuID(), denyTime );

        request.getRequestDispatcher("ManagerView").forward(request,response);
    }
}
