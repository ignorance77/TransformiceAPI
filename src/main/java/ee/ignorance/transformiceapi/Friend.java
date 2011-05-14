package ee.ignorance.transformiceapi;

public class Friend {

    private String playerName;
    private boolean online;

    public Friend(String playerName, boolean online) {
        this.playerName = playerName;
        this.online = online;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean getOnlineStatus() {
        return online;
    }

    public void setOnlineStatus(boolean online) {
        this.online = online;
    }
}
