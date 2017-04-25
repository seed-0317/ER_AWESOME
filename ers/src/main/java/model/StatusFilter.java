package model;

/**
 * Created by qzh225 on 4/25/17.
 */
public class StatusFilter {

    private int rsId;
    private String rsStatus;
    private String selected;

    public StatusFilter(){};

    public StatusFilter(int id, String status, String selected) {
        this.rsId = id;
        this.rsStatus = status;
        this.selected = selected;
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

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "StatusFilter{" +
                "rsId=" + rsId +
                ", rsStatus='" + rsStatus + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusFilter that = (StatusFilter) o;

        if (rsId != that.rsId) return false;
        if (rsStatus != null ? !rsStatus.equals(that.rsStatus) : that.rsStatus != null) return false;
        return selected != null ? selected.equals(that.selected) : that.selected == null;
    }

    @Override
    public int hashCode() {
        int result = rsId;
        result = 31 * result + (rsStatus != null ? rsStatus.hashCode() : 0);
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        return result;
    }
}
