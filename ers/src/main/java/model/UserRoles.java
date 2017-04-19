package model;

public class UserRoles {

    private int urId;
    private String urRole;

    public UserRoles(int urId, String ur_role) {
        this.urId = urId;
        this.urRole = ur_role;
    }

    public UserRoles() {
    }


    public int getUrId() {
        return urId;
    }

    public void setUrId(int urId) {
        this.urId = urId;
    }

    public String getUrRole() {
        return urRole;
    }

    public void setUrRole(String urRole) {
        this.urRole = urRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoles)) return false;

        UserRoles userRoles = (UserRoles) o;

        if (getUrId() != userRoles.getUrId()) return false;
        return getUrRole().equals(userRoles.getUrRole());
    }

    @Override
    public int hashCode() {
        int result = getUrId();
        result = 31 * result + getUrRole().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "urId=" + urId +
                ", urRole='" + urRole + '\'' +
                '}';
    }
}
