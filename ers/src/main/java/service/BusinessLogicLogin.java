package service;

import model.User;

/**
 * Created by npw383 on 4/18/17.
 */
public class BusinessLogicLogin {

    /**
     * (Username <40 characters, >1 character, not null)
     *
     * @param username1
     * @return
     */
    public boolean usernameValid1(String username1) {
        if ((username1 != null) && (username1.length() < 40) && (username1.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Method takes in parameter username @return username.
     * Method checks that entry is valid:
     *  (Username <40 characters, not null)
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
