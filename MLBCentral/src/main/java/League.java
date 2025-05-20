import java.lang.reflect.Array;
import java.util.ArrayList;

public class League {

    String leagueName;
    String sport;
    int gamesPerSeason;
    ArrayList<Team> teams;

    public League() {}

    public League(String leagueName, String sport, int gamesPerSeason) {
        this.leagueName = leagueName;
        this.sport = sport;
        this.gamesPerSeason = gamesPerSeason;
    }

    //region getters and setters
    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getGamesPerSeason() {
        return gamesPerSeason;
    }

    public void setGamesPerSeason(int gamesPerSeason) {
        this.gamesPerSeason = gamesPerSeason;
    }
    //endregion

    public ArrayList<Team> getAllTeams() {
        teams = MLBFileManager.readAllTeams();
        return teams;
    }

    public ArrayList<Team> getALTeams() {
        teams = getAllTeams();
        ArrayList<Team> americanLeagueTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("American")) {
                americanLeagueTeams.add(t);
            }
        }
        return americanLeagueTeams;
    }

    public ArrayList<Team> getNLTeams() {
        teams = getAllTeams();
        ArrayList<Team> nationalLeagueTeams = new ArrayList<>();

        for (Team t : teams) {
            if(t.getLeague().equalsIgnoreCase("National")) {
                nationalLeagueTeams.add(t);
            }
        }
        return nationalLeagueTeams;
    }

    public ArrayList<Team> getALEastTeams() {
        teams = getAllTeams();
        ArrayList<Team> alEastTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("East")) {
                alEastTeams.add(t);
            }
        }
        return alEastTeams;
    }

    public ArrayList<Team> getALCentralTeams() {
        teams = getAllTeams();
        ArrayList<Team> alCentralTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("Central")) {
                alCentralTeams.add(t);
            }
        }
        return alCentralTeams;
    }

    public ArrayList<Team> getALWestTeams() {
        teams = getAllTeams();
        ArrayList<Team> alWestTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("American") && t.getDivision().equalsIgnoreCase("West")) {
                alWestTeams.add(t);
            }
        }
        return alWestTeams;
    }

    public ArrayList<Team> getNLEastTeams() {
        teams = getAllTeams();
        ArrayList<Team> nlEastTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("East")) {
                nlEastTeams.add(t);
            }
        }
        return nlEastTeams;
    }

    public ArrayList<Team> getNLCentralTeams() {
        teams = getAllTeams();
        ArrayList<Team> nlCentralTeams = new ArrayList<>();

        for (Team t : teams) {
            if(t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("Central")) {
                nlCentralTeams.add(t);
            }
        }
        return nlCentralTeams;
    }

    public ArrayList<Team> getNLWestTeams() {
        teams = getAllTeams();
        ArrayList<Team> nlWestTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("West")) {
                nlWestTeams.add(t);
            }
        }
        return nlWestTeams;
    }



}
