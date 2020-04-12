package bmworks.endpoints;

import java.util.List;

public class GameView {

    public String internalId;
    public String externalId;
    public List<PlayerView> players;
    public boolean canBeStarted;
}
