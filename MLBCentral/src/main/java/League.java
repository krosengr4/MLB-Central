import java.lang.reflect.Array;
import java.util.ArrayList;

public class League {

    //League attributes
    String leagueName;
    String sport;
    int gamesPerSeason;
    ArrayList<Team> teams;

    //default constructor
    public League() {
    }

    //Overloaded constructor
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

    //Gets all teams and returns them in a List
    public ArrayList<Team> getAllTeams() {
        teams = MLBFileManager.readAllTeams();
        return teams;
    }

    //Gets all American League teams and returns them in a list
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

    //Gets all National League teams and returns them in a list
    public ArrayList<Team> getNLTeams() {
        teams = getAllTeams();
        ArrayList<Team> nationalLeagueTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("National")) {
                nationalLeagueTeams.add(t);
            }
        }
        return nationalLeagueTeams;
    }

    //Gets all teams in American League East division. Returns them in a list
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

    //Gets all teams in American League Central division. Returns them in a list
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

    //Gets all teams in American League West division. Returns them in a list
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

    //Gets all teams in National League east division. Returns them in a list
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

    //Gets all teams in National League Central division. Returns them in a list
    public ArrayList<Team> getNLCentralTeams() {
        teams = getAllTeams();
        ArrayList<Team> nlCentralTeams = new ArrayList<>();

        for (Team t : teams) {
            if (t.getLeague().equalsIgnoreCase("National") && t.getDivision().equalsIgnoreCase("Central")) {
                nlCentralTeams.add(t);
            }
        }
        return nlCentralTeams;
    }

    //Gets all teams in National League West division. Returns them in a list
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

    //Adds wins to team of users choice and sends to rewrite csv file with update
    public void addAWin(String team, int numberOfTWins) {
        teams = getAllTeams();
        boolean isTeamFound = false;

        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(team)) {
                t.setWins(t.wins + numberOfTWins);
                isTeamFound = true;
                System.out.printf("Success! The %s now have %d wins!", t.getName(), t.getWins());
                break;
            }
        }
        if (!isTeamFound) {
            System.out.println("Could not find a team with that name...");
        } else {
            MLBFileManager.prepareWriteToFile(teams);
        }
        Utils.pauseApp();
    }

    //Adds losses to team of users choice and sends to rewrite csv file with update
    public void addALoss(String team, int numberOfLosses) {
        teams = getAllTeams();
        boolean isTeamFound = false;

        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(team)) {
                t.setLosses(t.losses + numberOfLosses);
                isTeamFound = true;
                System.out.printf("Success. The %s now have %d losses.", t.getName(), t.getLosses());
                break;
            }
        }
        if(!isTeamFound) {
            System.out.println("Could not find a team with that name...");
        } else {
            MLBFileManager.prepareWriteToFile(teams);
        }
        Utils.pauseApp();
    }

    //Updates the win/loss record of a team of users choice, sends to rewrite the csv file with update
    public void updateWinLossRecord(String team) {

        int newWins = Utils.messageAndResponseInt("Enter the updated number of wins: ");
        int newLosses = Utils.messageAndResponseInt("Enter the updated number of losses: ");

        teams = getAllTeams();
        boolean isTeamFound = false;

        for (Team t : teams) {
            if (t.getName().equalsIgnoreCase(team)) {
                t.setWins(newWins);
                t.setLosses(newLosses);
                isTeamFound = true;

                System.out.printf("\nSuccess! The %s record has been updated! New Record: %d - %d\n", t.getName(), t.getWins(), t.getLosses());
                break;
            }
        }
        if(!isTeamFound) {
            System.out.println("Could not find a team with that name...");
        } else {
            MLBFileManager.prepareWriteToFile(teams);
        }

        Utils.pauseApp();
    }

    //Gets all teams who are going to make the playoffs
}
