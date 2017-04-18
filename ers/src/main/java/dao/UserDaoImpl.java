package dao;

/**
 * Created by qzh225 on 4/17/17.
 */

import model.User;
import model.UserRoles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DaoUtilities.getConnection();
            String sql =  "SELECT a.u_id, a.u_username, a.u_firstname, a.u_lastname, a.u_email ";
            sql = sql + "  ,b.ur_id, b.ur_role from erawesome.ers_users a join erawesome.ers_user_roles b on b.ur_id = a.ur_id";

            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                User u = new User();

                u.setU_id(rs.getInt("u_id"));
                u.setU_username(rs.getString("u_username"));
                u.setU_firstname(rs.getString("u_firstname"));
                u.setU_lastname(rs.getString("u_lastname"));
                u.setU_email(rs.getString("u_email"));
                UserRoles r = new UserRoles();
                r.setUr_id(rs.getInt("ur_id"));
                r.setUr_role(rs.getString("ur_role"));
                u.setU_role(r);

                users.add(u);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return users;
    }

    @Override
    public void updateEmployee(User emp){

        Connection connection = null;
        PreparedStatement stmt = null;
        int success = 0;

        try{
            connection = DaoUtilities.getConnection();
            String sql =  "UPDATE erawesome.ers_users set u_username = ?, u_firstname = ?, u_lastname = ?, ";
            sql = sql + "u_email = ?, ur_id = ? WHERE u_id = ?";
            stmt = connection.prepareStatement(sql);


            stmt.setString(1, emp.getU_username());
            stmt.setString(2, emp.getU_firstname());
            stmt.setString(3, emp.getU_lastname());
            stmt.setString(4, emp.getU_email());
            stmt.setInt(5, emp.getU_role().getUr_id());
            stmt.setInt(6, emp.getU_id());

            success = stmt.executeUpdate();


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public User getUser (String username){

        Connection connection = null;
        PreparedStatement stmt = null;
        User u = new User();

        try {
            connection = DaoUtilities.getConnection();
            String sql =  "SELECT a.u_id, a.u_username, a.u_firstname, a.u_lastname, a.u_email ";
            sql = sql + "  ,b.ur_id, b.ur_role from erawesome.ers_users a join erawesome.ers_user_roles b on b.ur_id = a.ur_id";
            sql = sql +  " where a.U_username = ?";
            stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {


                u.setU_id(rs.getInt("u_id"));
                u.setU_username(rs.getString("u_username"));
                u.setU_firstname(rs.getString("u_firstname"));
                u.setU_lastname(rs.getString("u_lastname"));
                u.setU_email(rs.getString("u_email"));
                UserRoles r = new UserRoles();
                r.setUr_id(rs.getInt("ur_id"));
                r.setUr_role(rs.getString("ur_role"));
                u.setU_role(r);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return u;
    }


}
