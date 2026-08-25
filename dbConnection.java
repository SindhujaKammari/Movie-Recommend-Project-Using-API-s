import java.sql.*;

public class dbConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/my_database";
            String username = "root";
            String password = "NewPassword123!"; // this is password set by you

            Connection con = DriverManager.getConnection(url, username, password);

            return con;

        } catch (SQLException e) {
            System.out.println("Couldnt connect to database");
            System.out.println("Reason: " + e.getMessage());
            System.out.println("--------------------------------------------------------------------------");
            e.printStackTrace();
            System.out.println("*********************************************************************************");

            return null;
        }
    }
}