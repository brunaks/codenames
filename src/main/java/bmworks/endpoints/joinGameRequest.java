package bmworks.endpoints;

public class JoinGameRequest {

    public String gameExternalId;
    public String playerName;

    public JoinGameRequest(String gameExternalId, String playerName) {

        this.gameExternalId = gameExternalId;
        this.playerName = playerName;
    }
}
