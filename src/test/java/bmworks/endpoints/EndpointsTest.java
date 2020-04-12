package bmworks.endpoints;

import bmworks.game.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EndpointsTest {

    private Endpoints endpoints;

    @BeforeEach
    void setUp() {
        endpoints = new Endpoints(new FakeIdGenerator());
    }

    @Test
    public void createAGameWithOnePlayer() {

        var gameResponse = endpoints.joinGame(new joinGameRequest("game1", "Player 1"));
        assertEquals("game1", gameResponse.externalId);
        assertEquals("id1", gameResponse.internalId);
        assertEquals("id2", gameResponse.playerId);
    }

    @Test
    public void reuseGameForNewPlayer() {

        var gameResponse = endpoints.joinGame(new joinGameRequest("game1", "Player 1"));
        assertEquals("game1", gameResponse.externalId);
        assertEquals("id1", gameResponse.internalId);
        assertEquals("id2", gameResponse.playerId);

        gameResponse = endpoints.joinGame(new joinGameRequest("game1", "Player 2"));
        assertEquals("game1", gameResponse.externalId);
        assertEquals("id1", gameResponse.internalId);
        assertEquals("id3", gameResponse.playerId);
    }

    @Test
    public void getGameViewForNewlyCreatedGame() {
        endpoints.joinGame(new joinGameRequest("game1", "Player 1"));

        var gameView = endpoints.getGame("id1");
        assertEquals("game1", gameView.externalId);
        assertEquals("id1", gameView.internalId);
        assertEquals(1, gameView.players.size());
        assertPlayerView(gameView, 0, "Player 1", Team.RED, true);
    }

    @Test
    public void getGameViewAfterSecondPlayerJoins() {
        endpoints.joinGame(new joinGameRequest("game1", "Player 1"));
        endpoints.joinGame(new joinGameRequest("game1", "Player 2"));

        var gameView = endpoints.getGame("id1");
        assertEquals("game1", gameView.externalId);
        assertEquals("id1", gameView.internalId);
        assertEquals(2, gameView.players.size());
        assertPlayerView(gameView, 0, "Player 1", Team.RED, true);
        assertPlayerView(gameView, 1, "Player 2", Team.BLUE, false);
    }

    private void assertPlayerView(GameView gameView, int index, String name, Team team, boolean host) {
        assertEquals(name, gameView.players.get(index).name);
        assertEquals(team, gameView.players.get(index).team);
        assertEquals(host, gameView.players.get(index).host);
    }
}