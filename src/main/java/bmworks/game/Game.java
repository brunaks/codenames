package bmworks.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String internalId;
    private String externalId;
    private List<Player> players = new ArrayList<>();

    public Game(String internalId, String externalId) {
        this.internalId = internalId;
        this.externalId = externalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getInternalId() {
        return internalId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(String playerName) {
        this.players.add(new Player(playerName, getNextTeam(), players.isEmpty()));
    }

    private Team getNextTeam() {
        return players.size() % 2 == 0 ? Team.RED : Team.BLUE;
    }

    public boolean canBeStarted() {
        return players.size() >= 4;
    }
}
