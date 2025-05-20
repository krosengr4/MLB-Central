import java.util.ArrayList;

public class UserInterface {

    League league;

    public String displayMainMenu() {
        System.out.println(
                """
                                               \s
                                ------------------PLAY BALL!!!------------------
                        ___________________________________________________________________
                         1 - View All Teams                      2 - View American League Teams
                         3 - View National League Teams          4 - View Teams by Division       \s
                         5 - View Team By Standing               6 - Create A Sim Playoff\s
                         7 - Update A Teams Record               8 - View Current Playoff Picture
                                                        00 - Exit
                        \s""");

        return Utils.promptGetUserInput("What Would you like to do?: ").trim();
    }

    public void processMainMenu() {
        boolean ifContinue = true;

        do {
            String userMenuChoice = displayMainMenu();
            initLeague();

            switch (userMenuChoice) {
                case "1" -> processAllTeams();
                case "2" -> processAmericanLeagueTeams();
                case "3" -> processNationalLeagueTeams();
                case "4" -> displayTeamsByDivision();
                case "5" -> processTeamsByStanding();
                case "6" -> processPlayoff();
                case "7" -> processUpdateTeamRecord();
                case "8" -> processViewPlayoffPicture();
                case "00" -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter one of the options you see!");
            }
        } while (ifContinue);
    }

    private void displayTeams(ArrayList<Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("There are no teams to display...");
        } else {
            for (Team team : teams) {
                System.out.printf("Team Name: %s | Location: %s | Wins: %d | Losses: %d | Win Percent: %.2f | League: %s | Division: %s\n",
                        team.getName(), team.getLocation(), team.getWins(), team.getLosses(), team.calculateWinPercent(),
                        team.getLeague(), team.getDivision());
            }
        }
        Utils.pauseApp();
    }

    private void initLeague() {
        MLBFileManager mlbfm = new MLBFileManager();
        this.league = mlbfm.getLeague();
    }

    private void processAllTeams() {
        ArrayList<Team> allTeams = league.getAllTeams();
        displayTeams(allTeams);
    }

    private void processAmericanLeagueTeams() {
        ArrayList<Team> americanLeagueTeams = league.getALTeams();
        System.out.println("\t\t\t\t-----American League-----");
        displayTeams(americanLeagueTeams);
    }

    private void processNationalLeagueTeams() {
        ArrayList<Team> nationalLeagueTeams = league.getNLTeams();
        System.out.println("\t\t\t\t-----National League-----");
        displayTeams(nationalLeagueTeams);
    }

    private void displayTeamsByDivision() {
        boolean ifContinue = true;

        while(ifContinue) {
            System.out.println(
                    """
                                    Which division would you like to see?
                            1 - AL East                     4 - NL East\s
                            2 - AL Central                  5 - NL Central
                            3 - AL West                     6 - NL West
                                            00 - Go back
                           \s""");
            String userChoice = Utils.promptGetUserInput("Enter a number: ");

            if (userChoice.equalsIgnoreCase("00")) {
                ifContinue = false;
            } else {
                processTeamsByDivision(userChoice);
            }
        }
    }

    private void processTeamsByDivision (String userChoice) {
        switch (userChoice) {
            case "1":
                ArrayList<Team> alEastTeams = league.getALEastTeams();
                System.out.println("\t\t\t\t---American League East---");
                displayTeams(alEastTeams);
                break;
            case "2":
                ArrayList<Team> alCentralTeams = league.getALCentralTeams();
                System.out.println("\t\t\t\t---American League Central---");
                displayTeams(alCentralTeams);
                break;
            case "3":
                ArrayList<Team> alWestTeams = league.getALWestTeams();
                System.out.println("\t\t\t\t---American League West---");
                displayTeams(alWestTeams);
                break;
            case "4":
                ArrayList<Team> nlEastTeams = league.getNLEastTeams();
                System.out.println("\t\t\t\t---National League East---");
                displayTeams(nlEastTeams);
                break;
            case "5":
                ArrayList<Team> nlCentralTeams = league.getNLCentralTeams();
                System.out.println("\t\t\t\t---National League Central---");
                displayTeams(nlCentralTeams);
                break;
            case "6":
                ArrayList<Team> nlWestTeams = league.getNLWestTeams();
                System.out.println("\t\t\t\t---National League West---");
                displayTeams(nlWestTeams);
                break;
        }
    }

    private void processTeamsByStanding() {
        System.out.println("Teams by place");
    }

    private void processPlayoff() {
        System.out.println("Playoffs!");
    }

    private void processUpdateTeamRecord() {
        System.out.println("Update Team Record");
    }

    private void processViewPlayoffPicture() {
        System.out.println("Playoff Picture");
    }

}
