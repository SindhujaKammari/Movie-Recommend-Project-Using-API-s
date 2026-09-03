import java.sql.*;

public class dbConnection {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/movie_project";
            String username = "root";
            String password = "Sindhu@2005"; // this is password set by you

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