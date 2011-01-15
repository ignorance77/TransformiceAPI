package ee.ignorance.transformiceapi.event;


public class TribePlayerConnectEvent implements Event {

    private String playerName;

    public TribePlayerConnectEvent(String playerName) {
        setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
