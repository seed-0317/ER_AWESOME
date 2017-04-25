package model;

/**
 * Created by qzh225 on 4/25/17.
 */
public class UserFilter {
    private int uID;
    private String name;
    private String selected;

    public UserFilter(){};

    public UserFilter(int uID, String name, String selected) {
        this.uID = uID;
        this.name = name;
        this.selected = selected;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFilter that = (UserFilter) o;

        if (uID != that.uID) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return selected != null ? selected.equals(that.selected) : that.selected == null;
    }

    @Override
    public int hashCode() {
        int result = uID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (selected != null ? selected.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserFilter{" +
                "uID=" + uID +
                ", name='" + name + '\'' +
                ", selected='" + selected + '\'' +
                '}';
    }
}
