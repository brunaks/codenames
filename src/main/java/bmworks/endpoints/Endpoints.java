package bmworks.endpoints;

import bmworks.game.Game;
import bmworks.game.GameManager;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Endpoints {
    private GameManager gameManager;
    private SimpMessagingTemplate messagingTemplate;
    private IdGenerator idGenerator;

    public Endpoints(IdGenerator idGenerator,
                     SimpMessagingTemplate messagingTemplate) {
        this.idGenerator = idGenerator;
        gameManager = new GameManager(idGenerator);
        this.messagingTemplate = messagingTemplate;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public JoinGameResponse joinGame(@RequestBody JoinGameRequest joinGameRequest) {
        var game = gameManager.getOrCreateGame(joinGameRequest.gameExternalId);
        game.addPlayer(joinGameRequest.playerName);

        messagingTemplate.convertAndSend("/game/fakeId", "new player added");

        return new JoinGameResponse(joinGameRequest.gameExternalId, game.getInternalId(), idGenerator.next());
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public GameView getGame(@PathVariable("id") String internalGameId) {
        return toView(gameManager.getByInternalId(internalGameId));
    }

    private GameView toView(Game game) {
        return new GameView(game);
    }
}
