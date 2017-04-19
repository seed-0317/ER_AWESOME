package model;

public class User {

    private int uID;
    private String uUserName;
    private String uFirstName;
    private String uLastName;
    private String uEmail;
    private UserRoles uRole;

    public User() {
    }

    public User(int uID, String uUserName, String uFirstName, String uLastName, String uEmail, UserRoles uRole) {
        this.uID = uID;
        this.uUserName = uUserName;
        this.uFirstName = uFirstName;
        this.uLastName = uLastName;
        this.uEmail = uEmail;
        this.uRole = uRole;
    }


    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getuUserName() { return uUserName; }

    public void setuUserName(String uUserName) { this.uUserName = uUserName;}

    public String getuFirstName() {
        return uFirstName;
    }

    public void setuFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getuLastName() {
        return uLastName;
    }

    public void setuLastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public UserRoles getuRole() {
        return uRole;
    }

    public void setuRole(UserRoles uRole) {
        this.uRole = uRole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getuID() != user.getuID()) return false;
        if (!getuUserName().equals(user.getuUserName())) return false;
        if (!getuFirstName().equals(user.getuFirstName())) return false;
        if (!getuLastName().equals(user.getuLastName())) return false;
        if (!getuEmail().equals(user.getuEmail())) return false;

        return getuRole().equals(user.getuRole());
    }

    @Override
    public int hashCode() {
        int result = getuID();
        result = 31 * result + getuUserName().hashCode();
        result = 31 * result + getuFirstName().hashCode();
        result = 31 * result + getuLastName().hashCode();
        result = 31 * result + getuEmail().hashCode();
        result = 31 * result + getuRole().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID=" + uID +
                ", uUserName='" + uUserName + '\'' +
                ", uFirstName='" + uFirstName + '\'' +
                ", uLastName='" + uLastName + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uRole=" + uRole +
                '}';
    }
}
