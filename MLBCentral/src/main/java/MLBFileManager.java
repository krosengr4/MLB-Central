import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MLBFileManager {

    public static String filePath = "MLBCentral/src/main/resources/Teams.csv";
    public static ArrayList<Team> teams;

    public League getLeague() {
        League mlb = new League();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String input;

            while ((input = bufferedReader.readLine()) != null) {
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
                int wins = Integer.parseInt(lineParts[5]);
                int losses = Integer.parseInt(lineParts[6]);

                Team newTeam = new Team(sport, name, location, wins, losses, league, division);
                teams.add(newTeam);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return teams;
    }

    public static void prepareWriteToFile(ArrayList<Team> allTeams) {
        ArrayList<Team> alEastTeams = new ArrayList<>();
        ArrayList<Team> alCentralTeams = new ArrayList<>();
        ArrayList<Team> alWestTeams = new ArrayList<>();
        ArrayList<Team> nlEastTeams = new ArrayList<>();
        ArrayList<Team> nlCentralTeams = new ArrayList<>();
        ArrayList<Team> nlWestTeams = new ArrayList<>();

        for (Team t : allTeams) {
            if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("East")) {
                alEastTeams.add(t);
            } else if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("Central")) {
                alCentralTeams.add(t);
            } else if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("West")) {
                alWestTeams.add(t);
            } else if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("East")) {
                nlEastTeams.add(t);
            } else if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("Central")) {
                nlCentralTeams.add(t);
            } else if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("West")) {
                nlWestTeams.add(t);
            }
        }

        writeToFile(alEastTeams, alCentralTeams, alWestTeams, nlEastTeams, nlCentralTeams, nlWestTeams);
    }

    public static void writeToFile(ArrayList<Team> alEastTeams, ArrayList<Team> alCentralTeams, ArrayList<Team> alWestTeams,
                                   ArrayList<Team> nlEastTeams, ArrayList<Team> nlCentralTeams, ArrayList<Team> nlWestTeams) {

        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("MLB|Baseball|182\nTEAM|LOCATION|LEAGUE|DIVISION|WINS|LOSSES\nAL|EAST\n");

            for (Team t : alEastTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }

            writer.write("AL|CENTRAL\n");
            for (Team t : alCentralTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }

            writer.write("AL|WEST\n");
            for (Team t : alWestTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }

            writer.write("NL|EAST\n");
            for (Team t : nlEastTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }

            writer.write("NL|CENTRAL\n");
            for (Team t : nlCentralTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }

            writer.write("NL|WEST\n");
            for (Team t : nlWestTeams) {
                writer.write("Baseball|" + t.getName() + "|" + t.getLocation() + "|" +
                        t.getLeague() + "|" + t.getDivision() + "|" + t.getWins() + "|" + t.getLosses() + "\n");
            }
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
