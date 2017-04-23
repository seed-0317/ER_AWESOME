package dao;

import model.Expense;
import model.ExpenseStatus;
import model.ExpenseType;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by qzh225 on 4/17/17.
 */
public interface ExpenseDao {

    public ArrayList<Expense> getAllExpenses();

    public void AddReimbursement (Expense reimb);  //insert new reimmb

    public void UpdateReimbursement(Expense reimb);  // change existing reimb

    public ArrayList<ExpenseType> getExpenseTypeList();

    public ArrayList<ExpenseStatus> getExpenseStatusList();

    public void ApproveReimbursement(int rId, int approverID, Timestamp aTime);

    public void DenyReimbursement(int rId, int denyID, Timestamp dTime);

}
