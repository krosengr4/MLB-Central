import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MLBFileManager {

    public static String filePath = "MLBPlayoffSimulator/src/main/resources/Teams.csv";
    public static ArrayList<Team> teams;

    public League getLeague() {
        League mlb = new League();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String input;

            while((input = bufferedReader.readLine()) != null) {
                String[] lineParts = input.split("\\|");

                if (!lineParts[0].startsWith("MLB") || input.isEmpty()) {
                    continue;
                }

                String leagueName = lineParts[0];
                String sport = lineParts[1];
                int gamesPerSeason = Integer.parseInt(lineParts[2]);

                mlb.setLeagueName(leagueName);
                mlb.setSport(sport);
                mlb.setGamesPerSeason(gamesPerSeason);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mlb;
    }
}
