package dao;

import model.Expense;

import java.util.ArrayList;

/**
 * Created by qzh225 on 4/17/17.
 */
public interface ExpenseDao {

    public ArrayList<Expense> getAllExpenses();

    public void AddReimbursement (Expense reimb);  //insert newe reimmb

    public void UpdateReimbursement(Expense reimb);  // change existing reimb


}
