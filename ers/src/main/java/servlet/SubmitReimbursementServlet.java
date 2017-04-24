package servlet;

import dao.DaoUtilities;
import dao.ExpenseDao;
import dao.ExpenseDaoImpl;
import dao.UserDao;
import model.Expense;
import model.ExpenseStatus;
import model.ExpenseType;
import model.User;
import service.BusinessLogicReimbursement;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import org.apache.log4j.Logger;

import static java.lang.Double.parseDouble;


@WebServlet (value = "/SubmitReimbursementServlet")
public class SubmitReimbursementServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SubmitReimbursementServlet.class);

//    HttpSession session = request.getSession();
//    User currUser = (User)session.getAttribute("user");


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("expenseSubmit.html").forward(req,resp);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
     //   UserDao udao = DaoUtilities.getUserDao();
        HttpSession session = req.getSession();
        User currUser = (User)session.getAttribute("user");

      //
        double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");
        String utype = req.getParameter("type");

        LOGGER.info(currUser.getuID() + " is trying to submit a reimbursement" + "for $" + amount);

        //Amanda code to catch submission errors pre dao call
        BusinessLogicReimbursement blreimbursement = new BusinessLogicReimbursement();
        if (!blreimbursement.amountValid(amount)) {
            //amount input incorrect
            LOGGER.info(currUser.getuID() + " amount entry: " + amount +" not valid in reimbursement submission");
            resp.sendRedirect("viewMyExpenses");
        }

        else if (!blreimbursement.descriptionValid(description)) {
            //description input incorrect
            LOGGER.info(currUser.getuID() + " description entry: "+ description +" not valid in reimbursement submission");
            resp.sendRedirect("viewMyExpenses");
        }

//        stmt.setDouble(1, reimb.getrAmount());
//        stmt.setString(2, reimb.getrDescription());
//        stmt.setTimestamp(3, reimb.getrSubmitted());
//        stmt.setTimestamp(4, reimb.getrResolved());
//        stmt.setInt(5, reimb.getuAuthor().getuID());
//
//        int r = reimb.getuResolver().getuID();
//        if (r !=0){
//            stmt.setInt(6, r);
//        }
//        else {
//            stmt.setNull(6, java.sql.Types.INTEGER );
//        }
//
//        stmt.setInt(7, reimb.getrType().getRtId());
//        stmt.setInt(8, reimb.getrStatus().getRsId());
//        }

        else {

            ExpenseType currExpense = new ExpenseType();
            currExpense.setRtType(utype);

            ExpenseStatus currStatus = new ExpenseStatus();
            currStatus.setRsStatus("1");
            //LOGGER.info("Object is changing to submitted");

            Timestamp datesubmitted = new Timestamp(System.currentTimeMillis());

            Expense newExpense = new Expense(amount, description, datesubmitted, currExpense, currUser, currStatus);


//        public User(int uID, String uUserName, String uFirstName, String uLastName, String uEmail, UserRoles uRole) {
//            this.uID = uID;
//            this.uUserName = uUserName;
//            this.uFirstName = uFirstName;
//            this.uLastName = uLastName;
//            this.uEmail = uEmail;
//            this.uRole = uRole;
//        }

            ExpenseDao dao = DaoUtilities.getExpenseDao();
            try {
                dao.AddReimbursement(newExpense);
                LOGGER.info("Submit reimbursement request success. Submitted by:" + currUser.getuID());

                req.getSession().setAttribute("message", "Reimbursement Added");
                req.getSession().setAttribute("messageClass", "alert-success");
                resp.sendRedirect("viewMyExpenses");

            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("Submit reimbursement request failed. Request from: " + currUser.getuID() + ": " + e.getMessage());

                req.getSession().setAttribute("message", "There was a problem creating the submission");
                req.getSession().setAttribute("messageClass", "alert-danger");

                req.getRequestDispatcher("viewMyExpenses").forward(req, resp);

            }
        }
    }

    }

