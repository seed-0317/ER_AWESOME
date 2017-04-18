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

    static synchronized Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
            }
            catch (ClassNotFoundException e) {
                System.out.println("Could not register driver!");
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        }
        // If connection was closed then retrieve a new connection
        if (connection.isClosed()) {

            connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);

        }
        return connection;

    }

}
