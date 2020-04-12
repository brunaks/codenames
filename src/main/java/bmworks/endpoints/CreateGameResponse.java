package bmworks.endpoints;

public class CreateGameResponse {

    public String externalId;
    public String internalId;
    public String playerId;

    public CreateGameResponse(String externalId, String internalId, String playerId) {
        this.externalId = externalId;
        this.internalId = internalId;
        this.playerId = playerId;
    }
}
