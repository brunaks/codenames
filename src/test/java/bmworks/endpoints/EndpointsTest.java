package bmworks.endpoints;

import org.junit.jupiter.api.BeforeEach;
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
        var gameResponse = endpoints.createGame(new CreateGameRequest("game1", "Player 1"));
        assertEquals("game1", gameResponse.externalId);
        assertEquals("id1", gameResponse.internalId);
        assertEquals("id2", gameResponse.playerId);

    }

}