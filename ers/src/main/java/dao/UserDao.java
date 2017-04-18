package dao;

import model.ExpenseType;
import model.User;

import java.util.ArrayList;

/**
 * Created by qzh225 on 4/17/17.
 */

public interface UserDao {

    public ArrayList<User> getAllUsers ();

    public void updateEmployee(User emp);

    public User getUser (String username);


}

