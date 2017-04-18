package model;

public class UserRoles {

    private int ur_id;
    private String ur_role;

    public UserRoles(int ur_id, String ur_role) {
        this.ur_id = ur_id;
        this.ur_role = ur_role;
    }

    public UserRoles() {
    }


    public int getUr_id() {
        return ur_id;
    }

    public void setUr_id(int ur_id) {
        this.ur_id = ur_id;
    }

    public String getUr_role() {
        return ur_role;
    }

    public void setUr_role(String ur_role) {
        this.ur_role = ur_role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoles)) return false;

        UserRoles userRoles = (UserRoles) o;

        if (getUr_id() != userRoles.getUr_id()) return false;
        return getUr_role().equals(userRoles.getUr_role());
    }

    @Override
    public int hashCode() {
        int result = getUr_id();
        result = 31 * result + getUr_role().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "ur_id=" + ur_id +
                ", ur_role='" + ur_role + '\'' +
                '}';
    }
}
