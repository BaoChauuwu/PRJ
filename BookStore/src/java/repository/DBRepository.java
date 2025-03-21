package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBRepository  {
//    private static final String jdbcURL = "jdbc:mysql://localhost:3306/bookstoredb";
//    private static final String jdbcUsername = "root";
//    private static final String jdbcPassword = "mapngu";
//    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static Connection getConnection() {
//        try {
//            if (connection == null || connection.isClosed()) {
//                connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String dbURL = "jdbc:sqlserver://DESKTOP-38BEA3O\\KTEAM:1433;databaseName=bookstoreDB;encrypt=true;trustServerCertificate=true";
    public static String userDB = "sa";
    public static String passDB = "123456";

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, userDB, passDB);
            return con;
        } catch (Exception ex) {
            Logger.getLogger(DBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            if (con != null) {
                System.out.println("Connect to Sp25_DemoPRJ Success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
