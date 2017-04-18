package model;

public class User {

    private int u_id;
    private String u_username;
    private String u_firstname;
    private String u_lastname;
    private String u_email;
    private UserRoles u_role;

    public User() {
    }

    public User(int u_id, String u_username, String u_firstname, String u_lastname, String u_email, UserRoles u_role) {
        this.u_id = u_id;
        this.u_username = u_username;
        this.u_firstname = u_firstname;
        this.u_lastname = u_lastname;
        this.u_email = u_email;
        this.u_role = u_role;
    }


    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_username() { return u_username; }

    public void setU_username(String u_username) { this.u_username = u_username;}

    public String getU_firstname() {
        return u_firstname;
    }

    public void setU_firstname(String u_firstname) {
        this.u_firstname = u_firstname;
    }

    public String getU_lastname() {
        return u_lastname;
    }

    public void setU_lastname(String u_lastname) {
        this.u_lastname = u_lastname;
    }

    public String getU_email() {
        return u_email;
    }

    public void setU_email(String u_email) {
        this.u_email = u_email;
    }

    public UserRoles getU_role() {
        return u_role;
    }

    public void setU_role(UserRoles u_role) {
        this.u_role= u_role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getU_id() != user.getU_id()) return false;
        if (!getU_username().equals(user.getU_username())) return false;
        if (!getU_firstname().equals(user.getU_firstname())) return false;
        if (!getU_lastname().equals(user.getU_lastname())) return false;
        if (!getU_email().equals(user.getU_email())) return false;

        return getU_role().equals(user.getU_role());
    }

    @Override
    public int hashCode() {
        int result = getU_id();
        result = 31 * result + getU_username().hashCode();
        result = 31 * result + getU_firstname().hashCode();
        result = 31 * result + getU_lastname().hashCode();
        result = 31 * result + getU_email().hashCode();
        result = 31 * result + getU_role().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_username='" + u_username + '\'' +
                ", u_firstname='" + u_firstname + '\'' +
                ", u_lastname='" + u_lastname + '\'' +
                ", u_email='" + u_email + '\'' +
                ", u_role=" + u_role +
                '}';
    }
}
