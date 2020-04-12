package bmworks.endpoints;

import bmworks.game.Game;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GameView {
    public String internalId;
    public String externalId;
    public List<PlayerView> players;
    public boolean canBeStarted;

    public GameView(Game game) {
        externalId = game.getExternalId();
        internalId = game.getInternalId();
        players = game.getPlayers().stream().map(PlayerView::new).collect(toList());
        canBeStarted = game.canBeStarted();
    }
}
