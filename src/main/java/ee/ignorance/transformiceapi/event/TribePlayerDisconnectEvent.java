package ee.ignorance.transformiceapi.event;


public class TribePlayerDisconnectEvent implements Event {

    private String playerName;

    public TribePlayerDisconnectEvent(String playerName) {
        setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}