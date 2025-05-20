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


}
