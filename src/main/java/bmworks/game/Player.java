package bmworks.game;

public class Player {
    private String name;
    private Team team;
    private boolean host;

    public Player(String name, Team team, boolean host) {
        this.name = name;
        this.team = team;
        this.host = host;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public boolean isHost() {
        return host;
    }
}
