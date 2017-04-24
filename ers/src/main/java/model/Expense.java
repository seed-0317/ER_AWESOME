package model;

import java.sql.Timestamp;

public class Expense {

    private int rId;
    private double rAmount;
    private String rDescription;
    private Timestamp rSubmitted;
    private Timestamp rResolved;
    private User uAuthor;
    private User uResolver;
    private ExpenseType rType;
    private ExpenseStatus rStatus;

    public Expense(){
    }

    public Expense(double rAmount, String rDescription,Timestamp rSubmitted, ExpenseType rType, User uAuthor, ExpenseStatus rStatus) {
        this.rAmount = rAmount;
        this.rDescription = rDescription;
        this.rSubmitted = rSubmitted;
        this.rResolved = null; //trying this out
        this.uAuthor = uAuthor;
        this.uResolver = null; //trying this out
        this.rType = rType;
        this.rStatus = rStatus;

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
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public double getrAmount() {
        return rAmount;
    }

    public void setrAmount(double rAmount) {
        this.rAmount = rAmount;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public Timestamp getrSubmitted() {
        return rSubmitted;
    }

    public void setrSubmitted(Timestamp rSubmitted) {
        this.rSubmitted = rSubmitted;
    }

    public Timestamp getrResolved() {
        return rResolved;
    }

    public void setrResolved(Timestamp rResolved) {
        this.rResolved = rResolved;
    }

    public User getuAuthor() {
        return uAuthor;
    }

    public void setuAuthor(User uAuthor) {
        this.uAuthor = uAuthor;
    }

    public User getuResolver() {
        return uResolver;
    }

    public void setuResolver(User uResolver) {
        this.uResolver = uResolver;
    }

    public ExpenseType getrType() {
        return rType;
    }

    public void setrType(ExpenseType rType) {
        this.rType = rType;
    }

    public ExpenseStatus getrStatus() {
        return rStatus;
    }

    public void setrStatus(ExpenseStatus rStatus) {
        this.rStatus = rStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expense)) return false;

        Expense expense = (Expense) o;

        if (getrId() != expense.getrId()) return false;
        if (Double.compare(expense.getrAmount(), getrAmount()) != 0) return false;
        if (!getrDescription().equals(expense.getrDescription())) return false;
        if (!getrSubmitted().equals(expense.getrSubmitted())) return false;
        if (!getrResolved().equals(expense.getrResolved())) return false;
        if (!getuAuthor().equals(expense.getuAuthor())) return false;
        if (!getuResolver().equals(expense.getuResolver())) return false;
        if (!getrType().equals(expense.getrType())) return false;
        return getrStatus().equals(expense.getrStatus());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getrId();
        temp = Double.doubleToLongBits(getrAmount());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getrDescription().hashCode();
        result = 31 * result + getrSubmitted().hashCode();
        result = 31 * result + getrResolved().hashCode();
        result = 31 * result + getuAuthor().hashCode();
        result = 31 * result + getuResolver().hashCode();
        result = 31 * result + getrType().hashCode();
        result = 31 * result + getrStatus().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "rId=" + rId +
                ", rAmount=" + rAmount +
                ", rDescription='" + rDescription + '\'' +
                ", rSubmitted=" + rSubmitted +
                ", rResolved=" + rResolved +
                ", uAuthor=" + uAuthor +
                ", uResolver=" + uResolver +
                ", rType=" + rType +
                ", rStatus=" + rStatus +
                '}';
    }
}
