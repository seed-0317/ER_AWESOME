package model;

import java.sql.Timestamp;

public class Expense {

    private int r_id;
    private double r_amount;
    private String r_description;
    private Timestamp r_submitted;
    private Timestamp r_resolved;
    private User u_id_author;
    private User u_id_resolver;
    private ExpenseType rt_type;
    private ExpenseStatus rt_status;

    public Expense() {
    }


    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public double getR_amount() {
        return r_amount;
    }

    public void setR_amount(double r_amount) {
        this.r_amount = r_amount;
    }

    public String getR_description() {
        return r_description;
    }

    public void setR_description(String r_description) {
        this.r_description = r_description;
    }

    public Timestamp getR_submitted() {
        return r_submitted;
    }

    public void setR_submitted(Timestamp r_submitted) {
        this.r_submitted = r_submitted;
    }

    public Timestamp getR_resolved() {
        return r_resolved;
    }

    public void setR_resolved(Timestamp r_resolved) {
        this.r_resolved = r_resolved;
    }

    public User getU_id_author() {
        return u_id_author;
    }

    public void setU_id_author(User u_id_author) {
        this.u_id_author = u_id_author;
    }

    public User getU_id_resolver() {
        return u_id_resolver;
    }

    public void setU_id_resolver(User u_id_resolver) {
        this.u_id_resolver = u_id_resolver;
    }

    public ExpenseType getRt_type() {
        return rt_type;
    }

    public void setRt_type(ExpenseType rt_type) {
        this.rt_type = rt_type;
    }

    public ExpenseStatus getRt_status() {
        return rt_status;
    }

    public void setRt_status(ExpenseStatus rt_status) {
        this.rt_status = rt_status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;

        Expense expense = (Expense) o;

        if (getR_id() != expense.getR_id()) return false;
        if (Double.compare(expense.getR_amount(), getR_amount()) != 0) return false;
        if (!getR_description().equals(expense.getR_description())) return false;
        if (!getR_submitted().equals(expense.getR_submitted())) return false;
        if (!getR_resolved().equals(expense.getR_resolved())) return false;
        if (!getU_id_author().equals(expense.getU_id_author())) return false;
        if (!getU_id_resolver().equals(expense.getU_id_resolver())) return false;
        if (!getRt_type().equals(expense.getRt_type())) return false;
        return getRt_status().equals(expense.getRt_status());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getR_id();
        temp = Double.doubleToLongBits(getR_amount());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getR_description().hashCode();
        result = 31 * result + getR_submitted().hashCode();
        result = 31 * result + getR_resolved().hashCode();
        result = 31 * result + getU_id_author().hashCode();
        result = 31 * result + getU_id_resolver().hashCode();
        result = 31 * result + getRt_type().hashCode();
        result = 31 * result + getRt_status().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "r_id=" + r_id +
                ", r_amount=" + r_amount +
                ", r_description='" + r_description + '\'' +
                ", r_submitted=" + r_submitted +
                ", r_resolved=" + r_resolved +
                ", u_id_author=" + u_id_author +
                ", u_id_resolver=" + u_id_resolver +
                ", rt_type=" + rt_type +
                ", rt_status=" + rt_status +
                '}';
    }
}
