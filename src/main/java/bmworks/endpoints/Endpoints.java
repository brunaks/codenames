package bmworks.endpoints;

import org.springframework.web.bind.annotation.*;

@RestController
public class Endpoints {
    private IdGenerator idGenerator;

    public Endpoints(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public CreateGameResponse createGame(@RequestBody CreateGameRequest createGameRequest) {
        return new CreateGameResponse(createGameRequest.gameExternalId,
                idGenerator.next(),
                idGenerator.next());
    }

    @RequestMapping(value = "/game/{id}/join", method = RequestMethod.POST)
    public String joinGame(@PathVariable("id") String gameId) {
        return null;
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public GameView getGame(@PathVariable("id") String gameId) {
        return null;
    }
}
