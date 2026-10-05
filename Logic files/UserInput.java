
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInput {
    static Scanner scanner = new Scanner(System.in);

    public static void MovieInput(int numberOfUsers) {
        Map < String, List<String >> movName = new HashMap <> ();

        for (int i = 0; i < numberOfUsers; i++) {
            System.out.print("Enter the name of the user : ");
            String userName = scanner.nextLine();
        
            System.out.print("How many movies do you have in your mind?: ");
            int count = Integer.parseInt(scanner.nextLine());
            List <String > userMovies = new ArrayList < > ();
           
            for (int j = 0; j < count; j++) { //
                System.out.print("Enter the movie number " + (j+1)+" : ");
                String movie = scanner.nextLine();
                userMovies.add(movie);
            }
            movName.put(userName,userMovies);
        }
        // sending the data to the MakeAdecision fun to get the result 
        //MovieDecision.GenreSelector(movName);
        //
        //GenreDecision.genreReturn(movName);
       
    }
}
