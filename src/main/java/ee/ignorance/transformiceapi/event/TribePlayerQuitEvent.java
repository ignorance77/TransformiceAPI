package ee.ignorance.transformiceapi.event;


public class TribePlayerQuitEvent implements Event {

    private String playerName;

    public TribePlayerQuitEvent(String playerName) {
        setPlayerName(playerName);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
