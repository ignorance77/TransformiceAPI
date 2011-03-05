package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.titles.TribeRank;

public class TribePlayer {

    private String playerName;
    private TribeRank rank;
    private String roomName;

    public TribePlayer(String playerName, TribeRank rank, String roomName) {
        this.playerName = playerName;
        this.rank = rank;
        this.roomName = roomName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public TribeRank getRank() {
        return rank;
    }

    public void setRank(TribeRank rank) {
        this.rank = rank;
    }
}
