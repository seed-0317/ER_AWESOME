package service;

import model.User;

/**
 * Created by npw383 on 4/19/17.
 */
public class BusinessLogicReimbursement {

    /**(Amount <22 characters >=1, not null, >0 amount, only accepts up to 2 numbers after decimal, solely accepts numbers .,(does for us in html5))
     *
     * @param amount
     * @return
     */

    //public static void main(String[] args) {
      //  BusinessLogicReimbursement blr = new BusinessLogicReimbursement();
        //System.out.println(blr.amountValid(100.01));
    //}
    public boolean amountValid(Double amount) {
        //System.out.println("Recvd Amount:  "+amount);
        if (amount == null){
            return false;
        }
        //splitting double into a string to count characters
        String[] splitter = amount.toString().split("\\.");
        //System.out.println(splitter[0].length());   // Before Decimal Count
        //System.out.println(splitter[1].length());   // After  Decimal Count
        if ((amount > 0) && (splitter[0].length() < 22) && (splitter[0].length() >= 1) && (splitter[1].length() <=2)) {
            return true;
        } else {
            return false;
        }
    }

    /**(Description <=100 characters, not null)
     *@param description
     * @return
     */
    public boolean descriptionValid(String description) {
        if ((description != null) && (description.length() <= 100) && (description.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**(Author >0 characters, not null)
     *@param author
     * @return
     */
    public boolean authorValid (String author) {
        if ((author != null) && (author.length() > 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method takes in parameters amount, description, receipt(not now), author, and type
     * and @return amount, description, receipt(not now), author, type(not junit - dropdown), resolver(not in employee entry) and status(not in employee entry).
     * Method checks that entry is valid:
     *      Author - >0 characters, not null
     *      Description - <=100 characters, not null
     *      Amount - <22 characters >=1, not null, >0 amount, only accepts up to 2 numbers after decimal, solely accepts numbers .,(does for us in html5))
     *
     * //Call dao method.
     *
     * //Any parameter that is not valid, throws an illegal argument exception.
     *
     * @param user to be updated by id
     * @return updated user object
     */
   // public User ReimbursementCall (User user1){
     //   return null;
    //}
}
