package model;

public class ExpenseStatus {

    private int rs_id;
    private String rs_status;

    public ExpenseStatus(int rs_id, String rs_status) {
        this.rs_id = rs_id;
        this.rs_status = rs_status;
    }

    public ExpenseStatus() {
    }

    public int getRs_id() {
        return rs_id;
    }

    public void setRs_id(int rs_id) {
        this.rs_id = rs_id;
    }

    public String getRs_status() {
        return rs_status;
    }

    public void setRs_status(String rs_status) {
        this.rs_status = rs_status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseStatus)) return false;

        ExpenseStatus that = (ExpenseStatus) o;

        if (getRs_id() != that.getRs_id()) return false;
        return getRs_status().equals(that.getRs_status());
    }

    @Override
    public int hashCode() {
        int result = getRs_id();
        result = 31 * result + getRs_status().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseStatus{" +
                "rs_id=" + rs_id +
                ", rs_status='" + rs_status + '\'' +
                '}';
    }
}
