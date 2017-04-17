package model;

public class ExpenseType {

    private int rt_id;
    private String rt_type;

    public ExpenseType(int rt_id, String rt_type) {
        this.rt_id = rt_id;
        this.rt_type = rt_type;
    }

    public ExpenseType() {
    }

    public int getRt_id() {
        return rt_id;
    }

    public void setRt_id(int rt_id) {
        this.rt_id = rt_id;
    }

    public String getRt_type() {
        return rt_type;
    }

    public void setRt_type(String rt_type) {
        this.rt_type = rt_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseType)) return false;

        ExpenseType that = (ExpenseType) o;

        if (getRt_id() != that.getRt_id()) return false;
        return getRt_type().equals(that.getRt_type());
    }

    @Override
    public int hashCode() {
        int result = getRt_id();
        result = 31 * result + getRt_type().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "rt_id=" + rt_id +
                ", rt_type='" + rt_type + '\'' +
                '}';
    }
}
