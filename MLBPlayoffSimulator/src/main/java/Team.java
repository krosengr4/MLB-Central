public class Team {

    String sport;
    String name;
    String location;
    int wins;
    int losses;
    String league;
    String division;

    public Team(String sport, String name, String location, int wins, int losses) {
        this.sport = sport;
        this.name = name;
        this.location = location;
        this.wins = wins;
        this.losses = losses;
    }

    //region getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLosses() {
        return losses;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
    //endregion

    public int calculateTotalGames() {
        return wins + losses;
    }

    public double calculateWinPercent() {
        double winPercent = 100 * ((double) this.getWins() / this.calculateTotalGames());
        return Utils.round(winPercent, 2);
    }
}
