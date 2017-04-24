package dao;

import model.Expense;
import model.ExpenseStatus;
import model.ExpenseType;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Created by qzh225 on 4/17/17.
 */
public class ExpenseDaoImpl implements ExpenseDao{

    private static final Logger LOGGER = Logger.getLogger(ExpenseDaoImpl.class);

    @Override
    public ArrayList<Expense> getAllExpenses(){

        ArrayList<Expense> expenses = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stmt = null;
        UserDaoImpl dao = new UserDaoImpl();

        try {
            connection = DaoUtilities.getConnection();
            String sql =  "SELECT a.r_id, a.r_amount, a.r_description, a.r_submitted, a.r_resolved,";
            sql = sql + "  b.u_id as author_id, b.u_username as authorname,";
            sql = sql + "  c.u_id as resolver_id, c.u_username as resolvername, d.rs_id, d.rs_status, e.rt_id, e.rt_type";
            sql = sql + "  from erawesome.ers_reimbursements a";
            sql = sql + "  join erawesome.ers_users b on b.u_id = a.u_id_author";

            sql = sql + "  left join erawesome.ers_users c on c.u_id = a.u_id_resolver";
          
            sql = sql + "  join erawesome.ers_reimbursement_status d on d.rs_id = a.rt_status";
            sql = sql + "  join erawesome.ers_reimbursement_type e on e.rt_id = a.rt_type";

            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("Connected to database and all expenses called successfully");

            while (rs.next()) {

                Expense exp = new Expense();

                exp.setrId(rs.getInt("r_id"));
                exp.setrAmount(rs.getDouble("r_amount"));
                exp.setrDescription(rs.getString("r_description"));
                exp.setrSubmitted(rs.getTimestamp("r_submitted"));
                exp.setrResolved(rs.getTimestamp("r_resolved"));

                //Add Author user object
                User author = dao.getUser(rs.getString("authorname"));
                exp.setuAuthor(author);

                //Add Resolver user object
                User resolver = dao.getUser(rs.getString("resolvername"));
                exp.setuResolver(resolver);

                //Add Expense Type Object
                ExpenseType etype = new ExpenseType();
                etype.setRtId(rs.getInt("rt_id"));
                etype.setRtType(rs.getString("rt_type"));
                exp.setrType(etype);

                //Add Expense Status Object
                ExpenseStatus estat = new ExpenseStatus();
                estat.setRsId(rs.getInt("rs_id"));
                estat.setRsStatus(rs.getString("rs_status"));
                exp.setrStatus(estat);

                expenses.add(exp);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("There is a problem retrieving all expenses data from the database. Check database connection." + e.getClass() + ": " + e.getMessage());

        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                    LOGGER.info("Connection closed on getAllExpenses");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return expenses;
    }

    @Override
    public void AddReimbursement (Expense reimb){
        Connection connection = null;
        PreparedStatement stmt = null;
        int success = 0;

        try{
            connection = DaoUtilities.getConnection();
            String sql =  "INSERT Into erawesome.ers_reimbursements ( r_amount, r_description, r_submitted , ";
            sql = sql + "  r_resolved, u_id_author , u_id_resolver, rt_type, rt_status) ";
            sql = sql + "  VALUES (?,?,?,?,?,?,?,? ) ";

            stmt = connection.prepareStatement(sql);


            stmt.setDouble(1, reimb.getrAmount());
            stmt.setString(2, reimb.getrDescription());
            stmt.setTimestamp(3, reimb.getrSubmitted());
            stmt.setNull(4, Types.TIMESTAMP );
            stmt.setInt(5, reimb.getuAuthor().getuID());
            stmt.setNull(6, java.sql.Types.INTEGER );
            stmt.setInt(7, reimb.getrType().getRtId());
            stmt.setInt(8, reimb.getrStatus().getRsId());

            success = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("There is a problem preventing user from submitting a new reimbursement request to the database from user: " +reimb.getuAuthor().getuID()  + e.getClass() + ": " + e.getMessage());
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                    LOGGER.info("Connection closed on AddReimbursement");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (success != 0) {
            LOGGER.info("Database connected and new reimbursement request inserted to the database successfully for: " + reimb.getuAuthor().getuID());
        }
    }

    @Override
    public void UpdateReimbursement(Expense reimb) {
        Connection connection = null;
        PreparedStatement stmt = null;
        int success = 0;

        try{
            connection = DaoUtilities.getConnection();
            String sql =  "UPDATE erawesome.ers_reimbursements set r_amount = ?, r_description = ?, r_submitted = ?, ";
            sql = sql + "r_resolved = ?, r_id_author = ? , u_id_resolver = ?, rt_type = ?, rt_status = ? WHERE r_id = ?";
            stmt = connection.prepareStatement(sql);


            stmt.setDouble(1, reimb.getrAmount());
            stmt.setString(2, reimb.getrDescription());
            stmt.setTimestamp(3, reimb.getrSubmitted());
            stmt.setTimestamp(4, reimb.getrResolved());
            stmt.setInt(5, reimb.getuAuthor().getuID());
            stmt.setInt(6, reimb.getuResolver().getuID());
            stmt.setInt(7, reimb.getrType().getRtId());
            stmt.setInt(8, reimb.getrStatus().getRsId());
            stmt.setInt(9, reimb.getrId());

            success = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("There is a problem preventing reimbursement update request with rID: " + reimb.getrId() + " from updating to the database. Update request is coming from user: " +reimb.getuAuthor().getuID()  + e.getClass() + ": " + e.getMessage());
        }
        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                    LOGGER.info("Connection closed on UpdateReimbursement");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (success != 0) {
            LOGGER.info("Database connected and reimbursement: " + reimb.getrId() + " updated in the database successfully for: " + reimb.getuAuthor().getuID());
        }
    }

    public ArrayList<ExpenseType> getExpenseTypeList() {

        ArrayList<ExpenseType> exptypes = new ArrayList<>();
        PreparedStatement stmt = null;

        try (Connection connection = DaoUtilities.getConnection()) {

            String sql =  "SELECT rt_id, rt_type from erawesome.ers_reimbursement_type ";

            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            LOGGER.info("Database connected and expense type list returned successfully");

            while (rs.next()) {

                ExpenseType etype = new ExpenseType();

                etype.setRtId(rs.getInt("rt_id"));
                etype.setRtType(rs.getString("rt_type"));

                exptypes.add(etype);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Failed to retrieve Expense Type list " + e.getClass() + ": " + e.getMessage());
        }

        return exptypes;

    }

    public ArrayList<ExpenseStatus> getExpenseStatusList() {

        ArrayList<ExpenseStatus> expstats = new ArrayList<>();
        PreparedStatement stmt = null;

        try (Connection connection = DaoUtilities.getConnection()) {

            String sql =  "SELECT rs_id, rs_status from erawesome.ers_reimbursement_status ";

            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            LOGGER.info("Database connected and expense status list returned successfully");

            while (rs.next()) {

                ExpenseStatus estat = new ExpenseStatus();

                estat.setRsId(rs.getInt("rs_id"));
                estat.setRsStatus(rs.getString("rs_status"));

                expstats.add(estat);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            LOGGER.error("Failed to retrieve Expense Status list " + e.getClass() + ": " + e.getMessage());
        }

        return expstats;

    }

    public void DenyReimbursement(int rId, int denyID, Timestamp dTime){

        PreparedStatement stmt = null;
        int success = 0;
        try (Connection connection = DaoUtilities.getConnection()) {

            String sql =  "UPDATE erawesome.ers_reimbursements set r_resolved = ?, u_id_resolver = ? , rt_status = ? WHERE r_id = ?";
            stmt = connection.prepareStatement(sql);

            stmt.setTimestamp(1, dTime);
            stmt.setInt(2, denyID);
            stmt.setInt(3, 3);
            stmt.setInt(4, rId);

            success = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            //todo log update failure
        }

        if (success != 0) {
            //TODO log update success
        }

    }

    public void ApproveReimbursement(int rId, int approverID, Timestamp aTime){

        PreparedStatement stmt = null;
        int success = 0;
        try (Connection connection = DaoUtilities.getConnection()) {

            String sql =  "UPDATE erawesome.ers_reimbursements set r_resolved = ?, u_id_resolver = ? , rt_status = ? WHERE r_id = ?";
            stmt = connection.prepareStatement(sql);

            stmt.setTimestamp(1, aTime);
            stmt.setInt(2, approverID);
            stmt.setInt(3, 2);
            stmt.setInt(4, rId);

            success = stmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
            //todo log update failure
        }

        if (success != 0) {
            //TODO log update success
        }

    }
}
