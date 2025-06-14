import java.util.ArrayList;
import java.util.Comparator;

public class UserInterface {

    League league;

    //displays the main menu with user options
    public String displayMainMenu() {
        System.out.println(
                """
                                               \s
                                ------------------PLAY BALL!!!------------------
                        ___________________________________________________________________
                         1 - View All Teams                      2 - View American League Teams
                         3 - View National League Teams          4 - View Teams by Division\s
                         5 - Update A Teams Record               6 - Enter a Final Game Score\s
                         7 - View Current Playoff Picture        8 - Create A Simulated Playoff\s
                                                     00 - Exit
                        \s""");

        return Utils.promptGetUserInput("What Would you like to do?: ").trim();
    }

    //process what the user selects from the main menu
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
                case "5" -> displayUpdateTeamRecord();
                case "6" -> processEnterGameScore();
                case "7" -> processViewPlayoffPicture();
                case "8" -> processPlayoff();
                case "00" -> ifContinue = false;
                default -> System.err.println("ERROR! Please enter one of the options you see!");
            }
        } while (ifContinue);
    }

    //takes in a List and displays it to the user
    private void displayTeams(ArrayList<Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("There are no teams to display...");
        } else {
            teams.sort(Comparator.comparing(Team::calculateWinPercent).reversed());
            for (Team team : teams) {
                System.out.printf("%s %s | %d - %d | Win Percent: %.2f | %s League %s\n",
                        team.getLocation(), team.getName(), team.getWins(), team.getLosses(), team.calculateWinPercent(),
                        team.getLeague(), team.getDivision());
            }
        }
        Utils.pauseApp();
    }

    //initializes file manager
    private void initLeague() {
        MLBFileManager mlbfm = new MLBFileManager();
        this.league = mlbfm.getLeague();
    }

    //Gets list of all teams and sends it to displayTeams
    private void processAllTeams() {
        ArrayList<Team> allTeams = league.getAllTeams();
        displayTeams(allTeams);
    }

    //Gets list of all American League team and sends it to displayTeams
    private void processAmericanLeagueTeams() {
        ArrayList<Team> americanLeagueTeams = league.getALTeams();
        System.out.println("\t\t\t\t-----American League-----");
        displayTeams(americanLeagueTeams);
    }

    //Gets list of all National League teams and sends it to displayTeams
    private void processNationalLeagueTeams() {
        ArrayList<Team> nationalLeagueTeams = league.getNLTeams();
        System.out.println("\t\t\t\t-----National League-----");
        displayTeams(nationalLeagueTeams);
    }

    //Displays options for what division a user wants to see
    private void displayTeamsByDivision() {
        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println(
                    """
                                     Which division would you like to see?
                             1 - AL East                     4 - NL East\s
                             2 - AL Central                  5 - NL Central
                             3 - AL West                     6 - NL West
                                             00 - Go back
                            \s""");
            String userChoice = Utils.promptGetUserInput("Enter a number: ").trim();

            if (userChoice.equalsIgnoreCase("00")) {
                ifContinue = false;
            } else {
                processTeamsByDivision(userChoice);
            }
        }
    }

    //Processes user selection for what division to show
    private void processTeamsByDivision(String userChoice) {
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

    //Displays options for how a user wants to update a teams record
    private void displayUpdateTeamRecord() {
        boolean ifContinue = true;

        while (ifContinue) {
            System.out.println(
                    """
                                                  ___OPTIONS___
                            ____________________________________________________________
                            1 - Add A Win To A Team             2 - Add A Loss To A Team
                            3 - Update Full Win/Loss Record     00 - Go back
                            """);

            String userChoice = Utils.promptGetUserInput("Enter a number: ").trim();

            if (userChoice.equalsIgnoreCase("00")) {
                ifContinue = false;
            } else {
                processUpdateTeamRecord(userChoice);
            }
        }
    }

    //Processes the choice for how a user wants to update a teams record
    private void processUpdateTeamRecord(String userChoice) {
        String updateTeam = Utils.promptGetUserInput("Which team would you like to update?: ").trim();

        switch (userChoice) {
            case "1":
                int numberOfWins = Utils.messageAndResponseInt("How many wins do you want to add?: ");
                league.addAWin(updateTeam, numberOfWins);
                break;
            case "2":
                int numberOfLosses = Utils.messageAndResponseInt("How many losses do you want to add?: ");
                league.addALoss(updateTeam, numberOfLosses);
                break;
            case "3":
                league.updateWinLossRecord(updateTeam);
                break;
            default:
                System.out.println("ERROR! Please enter a number 1 - 3 or 00");
        }
    }

    private void processEnterGameScore() {
        String awayTeam = Utils.promptGetUserInput("Please enter the away team name: ").trim();
        String homeTeam = Utils.promptGetUserInput("Please enter the home team name: ").trim();
        int awayScore = Utils.messageAndResponseInt("Enter the away team score: ");
        int homeScore = Utils.messageAndResponseInt("Enter the home team score: ");

        league.updateRecordBasedOnGame(awayTeam, homeTeam, awayScore, homeScore);
    }

    //Method to create new instance Playoff object
    private void processViewPlayoffPicture() {
        System.out.println("These Teams will Make the playoffs: ");
    }

    //
    private void processPlayoff() {
        System.out.println("Playoffs!");
    }

}
