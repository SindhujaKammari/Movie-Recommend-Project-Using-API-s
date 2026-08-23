import java.util.*;
import java.sql.*;

public class MovieDecision {
    public static String GenreSelector(Map<String , List<String>> movName){
        HashMap<String,Integer> countTheGenre = new HashMap<>();

        for(Map.Entry<String, List<String>> genreName : movName.entrySet()){
            for(String movie: genreName.getValue()){
                if(countTheGenre.containsKey(movie)){
                    countTheGenre.put(movie , countTheGenre.get(movie)+1);
                }
                else{
                    countTheGenre.put(movie , 1);
                }
            }
        }
        int max =0;
        String resultGenre = "";
        for(Map.Entry<String , Integer> resultVal : countTheGenre.entrySet()){
            if(max < resultVal.getValue()){
                max = resultVal.getValue();
                resultGenre = resultVal.getKey();
            }
        }
        System.out.println("Pick the movie:\n");
        showMovies(resultGenre);
        return resultGenre;
    } 

    public static void showMovies(String resultGenre){ // this is jdbc  this method shows the lst of movie acc to the input  o
        try{
            Connection con = dbConnection.getConnection(); 
            String query = " Select * from movieData where Genre= ?"; //well get that value from here
            PreparedStatement stmt = con.prepareStatement(query); // so this is sayin prepare our sql ready 
            stmt.setString(1,resultGenre); // this is setting the value like we have 1 unknon value right? yes so we put setString(1,genreName); genreName wiill get from ? our yesyestrdays code dont remove this comments it will help me tomo okk 
            /*
            so if we have like this then we'll say  Select * from movieData where Genre= ? and moviename=?
            setString(1,genreName);
            setString(2,moviename); got it yes now  */
            ResultSet rs = stmt.executeQuery(); // this is bascially saying execute the sql got it 
            if(rs.next()){ //this is saying if we have the genre name in our db then do this
                System.out.println("Genre: "+ resultGenre); // our genre
                int i=1; // it is a counter 
                while(rs.next()  && (i<=20)){ //rs.next() means so it is automatically sayng print everything from the picked out data 
                    System.out.println(i+" "+rs.getString("MovieName")); // rs.getString("colName") it will print one by one until the last one hits yeah 
                    i++;
                }
            }else{ // if we dont have the genre so tell the users this code 
    
                System.out.println("Sorry this genre is very new to our Database\nbut we'll add the movies of the genre you requested as soon as possible");
            }
            

        }catch(SQLException e){
            System.out.println(e.getMessage()); // this means ik what tel me this is exceptionn handling it will print the line oddcurd error and reason right? yeah but see the diff 
           
        }
        
    }

}
