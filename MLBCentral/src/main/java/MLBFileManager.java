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

    public static ArrayList<Team> readAllTeams() {
        teams = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String input;

            while ((input = bufferedReader.readLine()) != null) {
                String[] lineParts = input.split("\\|");

                if (!lineParts[0].startsWith("Baseball") || input.isEmpty()) {
                    continue;
                }
                String sport = lineParts[0];
                String name = lineParts[1];
                String location = lineParts[2];
                String league = lineParts[3];
                String division = lineParts[4];
                int wins =  Integer.parseInt(lineParts[5]);
                int losses = Integer.parseInt(lineParts[6]);

                Team newTeam = new Team(sport, name, location, wins, losses, league, division);
                teams.add(newTeam);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return teams;
    }
}
