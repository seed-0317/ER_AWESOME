package servlet;

import dao.DaoUtilities;
import dao.ExpenseDao;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("expenseSubmit.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Double amount = parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");
        String utype = req.getParameter("type");
        String uauthor = req.getParameter("author");
        LOGGER.info(uauthor + " is trying to submit a reimbursement");

        //Amanda code to catch submission errors pre dao call
        BusinessLogicReimbursement blreimbursement = new BusinessLogicReimbursement();
        if (!blreimbursement.amountValid(amount)) {
            //amount input incorrect
            LOGGER.info(amount + " amount not valid in reimbursement submission");
            resp.sendRedirect("SubmitReimbursementServlet");
        }

        else if (!blreimbursement.descriptionValid(description)) {
            //description input incorrect
            LOGGER.info(description + " description not valid in reimbursement submission");
            resp.sendRedirect("SubmitReimbursementServlet");
        }

//        else if (!blreimbursement.authorValid(uauthor)) {
//            //author input incorrect
//            resp.sendRedirect("SubmitReimbursementServlet");
//            LOGGER.info(uauthor + " author not valid");
//        }

        else {
            User currUser = new User();
            currUser.setuUserName(uauthor);

            ExpenseType currExpense = new ExpenseType();
            currExpense.setRtType(utype);

            ExpenseStatus currStatus = new ExpenseStatus();
            currStatus.setRsStatus("Submitted");
            //LOGGER.info(parameter + " is submitted");

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
                LOGGER.info("Submit reimbursement request success.");

                req.getSession().setAttribute("message", "Reimbursement Added");
                req.getSession().setAttribute("messageClass", "alert-success");
                resp.sendRedirect("expenseSubmit.html");

            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.error("Submit Reimbursement request failed. " + e.getClass() + ": " + e.getMessage());

                //change the message
                req.getSession().setAttribute("message", "There was a problem creating the submission");
                req.getSession().setAttribute("messageClass", "alert-danger");

                req.getRequestDispatcher("SubmitReimbursementServlet").forward(req, resp);

            }
        }
    }

    }

