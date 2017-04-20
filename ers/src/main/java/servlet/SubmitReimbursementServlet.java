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
        String utype = req.getParameter("type");
        String uauthor = req.getParameter("author");

        //Amanda code to catch submission errors pre dao call
        BusinessLogicReimbursement blreimbursement = new BusinessLogicReimbursement();
        if (!blreimbursement.amountValid(amount)){
            //amount input incorrect
            resp.sendRedirect("SubmitReimbursementServlet");
        }

        BusinessLogicReimbursement blreimbursement1 = new BusinessLogicReimbursement();
        if (!blreimbursement1.descriptionValid(description)){
            //description input incorrect
            resp.sendRedirect("SubmitReimbursementServlet");
        }

        BusinessLogicReimbursement blreimbursement2 = new BusinessLogicReimbursement();
        if (!blreimbursement2.authorValid(uauthor)){
            //author input incorrect
            resp.sendRedirect("SubmitReimbursementServlet");
        }
        //
        //ask team about author (auto-populated or open text field?)
        User currUser = new User();
        currUser.setuUserName(uauthor);

        ExpenseType currExpense = new ExpenseType();
        currExpense.setRtType(utype);

        ExpenseStatus currStatus = new ExpenseStatus();
        currStatus.setRsStatus("Submitted");

        Timestamp datesubmitted = new Timestamp(System.currentTimeMillis());

        Expense newExpense = new Expense(amount,description,datesubmitted,currExpense,currUser,currStatus);


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
            req.getSession().setAttribute("message", "Reimbursement Added");
            req.getSession().setAttribute("messageClass", "alert-success");
            resp.sendRedirect("expenseSubmit.html");
        }

            catch (Exception e){
                e.printStackTrace();

                //change the message
                req.getSession().setAttribute("message", "There was a problem creating the submission");
                req.getSession().setAttribute("messageClass", "alert-danger");

                req.getRequestDispatcher("expenseSubmit.html").forward(req, resp);

            }
        }

    }

