import java.sql.*; 

public class dbConnection {
    public static Connection connection(){
        try{
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");

            Connection con = DriverManager.getConnection(url,username,password);

            return con;
        }catch(SQLException e){
           System.out.println("Couldnt connect to database");
           System.out.println("Reason: "+e.getMessage());
           return null;
        }
        
    }
    
    
}
