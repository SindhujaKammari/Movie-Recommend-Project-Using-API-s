import java.sql.*;
import java.util.*;

public class GenreDecision {

    public static void genreReturn(Map<String, List<String>> movName) {

        Map<String, Integer> genreCount = new HashMap<>();

        for (List<String> list : movName.values()) {

            for (String value : list) {

                List<String> genres = genreRecv(value);

                for (String genre : genres) {
                    genreCount.put( genre, genreCount.getOrDefault(genre, 0) + 1 );
                }
            }
        }

        System.out.println("Genre Counts:");

        for (Map.Entry<String, Integer> entry : genreCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static List<String> genreRecv(String movieName) {

        try {
            Connection con = dbConnection.getConnection();

            String query = "SELECT Genre FROM moviedata WHERE MovieName = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, movieName);

            ResultSet rs = stmt.executeQuery();

            List<String> eachMovGenre = new ArrayList<>();

            while (rs.next()) {
                String genre = rs.getString("Genre");
                eachMovGenre.add(genre);
            }

            if (eachMovGenre.isEmpty()) {
                System.out.println(
                    "Sorry we do not have this movie in our Database"
                );
            }

            return eachMovGenre;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}