package ee.ignorance.transformiceapi.event;


public class TribePlayerJoinEvent implements Event {

    private String playerName;

    public TribePlayerJoinEvent(String playerName) {
        setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
