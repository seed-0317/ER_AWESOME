package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by qzh225 on 4/18/17.
 */
public class DaoUtilities {

    private static final String CONNECTION_USERNAME =  System.getenv("CONNECTIONUSERNAME");
    private static final String CONNECTION_PASSWORD =  System.getenv("CONNECTIONPASSWORD");
    private static final String URL =  System.getenv("CONNECTIONURL");

    private static Connection connection;
    private static ExpenseDaoImpl expenseDaoImpl;
    private static UserDaoImpl userDaoImpl;

    public static synchronized ExpenseDao getExpenseDao() {

        if (expenseDaoImpl == null) {
            expenseDaoImpl = new ExpenseDaoImpl();
        }
        return expenseDaoImpl;
    }

    public static synchronized UserDao getUserDao() {

        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl();
        }
        return userDaoImpl;
    }

    public static Connection getConnection() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

}
