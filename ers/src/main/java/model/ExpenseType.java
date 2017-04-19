package model;

public class ExpenseType {

    private int rtId;
    private String rtType;

    public ExpenseType(int rtId, String rtType) {
        this.rtId = rtId;
        this.rtType = rtType;
    }

    public ExpenseType() {
    }

    public int getRtId() {
        return rtId;
    }

    public void setRtId(int rtId) {
        this.rtId = rtId;
    }

    public String getRtType() {
        return rtType;
    }

    public void setRtType(String rtType) {
        this.rtType = rtType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExpenseType)) return false;

        ExpenseType that = (ExpenseType) o;

        if (getRtId() != that.getRtId()) return false;
        return getRtType().equals(that.getRtType());
    }

    @Override
    public int hashCode() {
        int result = getRtId();
        result = 31 * result + getRtType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseType{" +
                "rtId=" + rtId +
                ", rtType='" + rtType + '\'' +
                '}';
    }
}
