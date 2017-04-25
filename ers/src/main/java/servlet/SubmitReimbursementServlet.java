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


        HttpSession session = req.getSession();
        User currUser = (User)session.getAttribute("user");

      //getting values from the forms
       double amount = Double.parseDouble(req.getParameter("amount"));

        String description = req.getParameter("description");
        String utype = req.getParameter("type");

        LOGGER.info(currUser.getuID() + " is trying to submit a reimbursement" + " for $" + amount);

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


        else {

            LOGGER.info(currUser.getuID() + " is trying to submit a reimbursement type of " + utype);

            ExpenseType currExpense = new ExpenseType();

            //hardcoded the type ID, will update in the near future
            if ("meals".equals(utype)) {
                currExpense.setRtId(1);
            }
            else if ("travel".equals(utype)){
                currExpense.setRtId(2);
            }
            else if ("mileage".equals(utype)){
                currExpense.setRtId(3);
            }
            else if ("supplies".equals(utype)){
                currExpense.setRtId(4);
            }
            else
                currExpense.setRtId(5);


            ExpenseStatus currStatus = new ExpenseStatus();
            currStatus.setRsId(1);
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

