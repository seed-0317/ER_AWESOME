package model;

public class ExpenseStatus {

    private int rsId;
    private String rsStatus;

    public ExpenseStatus(int rsId, String rs_status) {
        this.rsId = rsId;
        this.rsStatus = rs_status;
    }

    public ExpenseStatus() {
    }

    public int getRsId() {
        return rsId;
    }

    public void setRsId(int rsId) {
        this.rsId = rsId;
    }

    public String getRsStatus() {
        return rsStatus;
    }

    public void setRsStatus(String rsStatus) {
        this.rsStatus = rsStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseStatus)) return false;

        ExpenseStatus that = (ExpenseStatus) o;

        if (getRsId() != that.getRsId()) return false;
        return getRsStatus().equals(that.getRsStatus());
    }

    @Override
    public int hashCode() {
        int result = getRsId();
        result = 31 * result + getRsStatus().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseStatus{" +
                "rsId=" + rsId +
                ", rsStatus='" + rsStatus + '\'' +
                '}';
    }
}
