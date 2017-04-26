package service;

import model.User;

import static java.lang.Character.isLetter;

/**
 * Created by npw383 on 4/18/17.
 */
public class BusinessLogicUserInfo {

    /**
     * (Username <40 characters, >1 character, not null, unique(not in here))
     *
     * @param username
     * @return
     */
    public boolean usernameValid(String username) {
        if ((username != null) && (username.length() < 40) && (username.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean firstNameValid(String firstname) {
        if (firstname == null) {
            return false;
        }

        for (int i = 0; i < firstname.trim().length(); i++) {
            if (!isLetter(firstname.trim().charAt(i))) {
                return false;
            }
        }

        if ((firstname.trim().length() < 30) && (firstname.trim().length() > 0)) {
            return true;
        } else

        {
            return false;
        }

    }


    public boolean lastNameValid(String lastname) {
        if (lastname == null) {
            return false;
        }

        for (int i = 0; i < lastname.trim().length(); i++) {
            if (!isLetter(lastname.trim().charAt(i))) {
                return false;
            }
        }

        if ((lastname.trim().length() < 30) && (lastname.trim().length() > 0)) {
            return true;
        } else

        {
            return false;
        }
    }

    public boolean emailValid(String email) {
        if ((email != null) && (email.length() < 100) && (email.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method takes in parameter username, firstname, lastname and email and @return username, firstname, lastname and email.
     * Method checks that entry is valid:
     *  (Firstname, last name <30 characters, not null)
     *  (Username <40 characters, >0 characters, not null, unique(remove because in database), type string (won't compile if not string, so don't need to test))
     *  (email <30 characters, not null, contains @(ignoring for now regex is tricky and in html5))
     * //Call dao method.
     *
     * //Any parameter that is not valid, throws an illegal argument exception.
     *
     * @param user1 to be updated by id
     * @return updated user object
     */
    /**public User updateEmployeeCall (User user1){
     return null;
     }
     */

}
