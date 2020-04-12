package bmworks.endpoints;

public class JoinGameResponse {

    public String externalId;
    public String internalId;
    public String playerId;

    public JoinGameResponse(String externalId, String internalId, String playerId) {
        this.externalId = externalId;
        this.internalId = internalId;
        this.playerId = playerId;
    }
}
