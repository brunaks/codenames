package bmworks.game;

import bmworks.endpoints.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class GameManager {

    private IdGenerator idGenerator;
    private Map<String, String> internalByExternalId = new HashMap<>();
    private Map<String, Game> gameByInternalId = new HashMap<>();

    public GameManager(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public Game getOrCreateGame(String externalId) {
        var gameInternalId = internalByExternalId.computeIfAbsent(externalId, (ignored) -> idGenerator.next());
        return gameByInternalId.computeIfAbsent(gameInternalId, internalId -> new Game(internalId, externalId));
    }

    public Game getByInternalId(String internalGameId) {
        return gameByInternalId.get(internalGameId);
    }
}
