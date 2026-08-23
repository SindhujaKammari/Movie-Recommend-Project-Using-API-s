import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieDecision {
    static void GenreSelector(Map<String , List<String>> movName){
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
