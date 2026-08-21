import java.util.*;
public class Host {

    static Scanner scanner = new Scanner(System.in);
   
   
    public static void host(int numberOfUsers) {
        Map < String, List<String >> movName = new HashMap <> ();

        for (int i = 0; i < numberOfUsers; i++) {
            System.out.print("Enter the name of the user : ");
            String userName = scanner.nextLine();
        
            System.out.print("How many movies do you have in your mind?: ");
            int count = Integer.parseInt(scanner.nextLine());
            List <String > userMovies = new ArrayList < > ();
           
            for (int j = 0; j < count; j++) { //what is count here? the count of movies
                System.out.print("Enter the movie number " + (j+1)+" : ");
                String movie = scanner.nextLine();
                userMovies.add(movie);
            }
            movName.put(userName,userMovies);
        }
        // sending the data to the MakeAdecision fun to get the result 
        MakeADecision(movName);
        //to print results on call
        //printSelectedMovies(movName);
    }
    public static void printSelectedMovies(Map<String, List<String>> movName) {
        System.out.println("User names and movie names");
        for(Map.Entry<String, List<String>> entry : movName.entrySet()){
            System.out.println("User: " + entry.getKey()); // this is to name
            for(int k=0;k<entry.getValue().size();k++){
                System.out.println(" "+(k+1)+". "+ entry.getValue().get(k));
            }
        } 
    }

    public static void main(String[] args) {
        System.out.println("Proj started"); 
        System.out.print("Enter number of users in Room: ");
        int numberOfUsers=scanner.nextInt();
        scanner.nextLine();
        host(numberOfUsers);
    }

    public static void MakeADecision(Map<String , List<String>> movName){
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
        System.out.println(" the final result:" + resultGenre);
        
    }
}
