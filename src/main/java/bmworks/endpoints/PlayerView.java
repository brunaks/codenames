package bmworks.endpoints;

import bmworks.game.Player;
import bmworks.game.Team;

public class PlayerView {

    public String name;
    public Team team;
    public boolean host;

    public PlayerView(Player player) {
        name = player.getName();
        team = player.getTeam();
        host = player.isHost();
    }
}
