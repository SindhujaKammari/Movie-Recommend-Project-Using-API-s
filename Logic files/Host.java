import java.util.*;
public class Host {

    static Scanner scanner = new Scanner(System.in);
   
   

    public static void printSelectedMovies(Map<String, List<String>> movName) {
        System.out.println("User names and movie names");
        for(Map.Entry<String, List<String>> entry : movName.entrySet()){
            System.out.println("User: " + entry.getKey()); // this is to name
            for(int k=0;k<entry.getValue().size();k++){
                System.out.println(entry.getValue().get(k));
            }
        } 
    }

    public static void main(String[] args) {
        System.out.println("Proj started"); 
        System.out.print("Enter number of users in Room: ");
        int numberOfUsers=scanner.nextInt();
        scanner.nextLine();
        UserInput.MovieInput(numberOfUsers);
    }

    
}
