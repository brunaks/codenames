package bmworks.endpoints;

public class joinGameRequest {

    public String gameExternalId;
    public String playerName;

    public joinGameRequest(String gameExternalId, String playerName) {

        this.gameExternalId = gameExternalId;
        this.playerName = playerName;
    }
}
