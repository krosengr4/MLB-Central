import java.util.ArrayList;

public class Playoff {

    ArrayList<Team> playoffTeams = new ArrayList<>(12);

    public Playoff(ArrayList<Team> playoffTeams) {
        this.playoffTeams = playoffTeams;
    }

    //getter for playoffTeams list
    public ArrayList<Team> getPlayoffTeams() {
        return playoffTeams;
    }
}
