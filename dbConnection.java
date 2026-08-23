import java.sql.*; 

public class dbConnection {
    public static Connection getConnection(){
        try{
            String url = "OWN_URL"; // this is sql url its simple and you need to remember that part only
            String username = "root"; // this is same for everyone 
            String password = "OWN_PASSWORD"; // this is password set by you

            Connection con = DriverManager.getConnection(url,username,password); //

            return con;
        }catch(SQLException e){
           System.out.println("Couldnt connect to database");
           System.out.println("Reason: "+e.getMessage());// we got simple message when we use e.getMessage got it
           System.out.println("--------------------------------------------------------------------------");
           e.printStackTrace(); /// when we use this  we get this huge disgusting block we cant even understand sometimes whats wrong 
          // so i chose to get the message simply instead of this block okay? yes good nice over explanation what more do you want no everthing good  i want to see ow you study or learn things throu chat gpt can you show?i deleted it it was not logged it
           System.out.println("*********************************************************************************");
           return null;
        }
        
    }
    
    
}
