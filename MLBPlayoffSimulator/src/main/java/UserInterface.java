import java.util.ArrayList;

public class UserInterface {

    League league;

    public String displayMainMenu() {
        System.out.println(
                """
                                               \s
                                ------------------MAIN MENU------------------
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
                case "2" -> processALTeams();
                case "3" -> processNLTeams();
                case "4" -> processTeamsByDivision();
                case "5" -> processTeamsByStanding();
                case "6" -> processPlayoff();
                case "00" -> ifContinue = false;
            }
        } while (ifContinue);
    }

    private void displayTeams(ArrayList<Team> teams) {
        if (teams.isEmpty()) {
            System.out.println("There are no teams to display...");
        } else {
            for (Team team : teams) {
                System.out.printf("Team Name: %s | Location: %s | Wins: %d | Losses: %d | Win Percent: %f | League: %s | Division: %s",
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
        System.out.println("All Teams");
    }

    private void processALTeams() {
        System.out.println("American League Teams");
    }

    private void processNLTeams() {
        System.out.println("National League Teams");
    }

    private void processTeamsByDivision() {
        System.out.println("Teams by division");
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
