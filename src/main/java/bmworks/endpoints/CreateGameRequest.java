package bmworks.endpoints;

public class CreateGameRequest {

    public String gameExternalId;
    public String playerName;

    public CreateGameRequest(String gameExternalId, String playerName) {

        this.gameExternalId = gameExternalId;
        this.playerName = playerName;
    }
}
