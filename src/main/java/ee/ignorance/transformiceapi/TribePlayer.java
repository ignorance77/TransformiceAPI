package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.titles.Title;
import ee.ignorance.transformiceapi.titles.Titles;
import ee.ignorance.transformiceapi.titles.TribeRank;

public class TribePlayer {

    private String playerName;
    private TribeRank rank;
    private String avatarId;
    private int titleNumber;
    private String roomName;

    public TribePlayer(String playerName, TribeRank rank, String avatarId, int titleNumber, String roomName) {
        this.playerName = playerName;
        this.rank = rank;
        this.avatarId = avatarId;
        this.titleNumber = titleNumber;
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
    
    public void setAvatarId(String avatarId) {
    	this.avatarId = avatarId;
    }
    
    public String getAvatarId() {
    	return avatarId;
    }
    
    public int getTitleNumber() {
    	return titleNumber;
    }
    public Title getTitle() {
    	return Titles.getTitle(titleNumber);
    }

	@Override
	public String toString() {
		return "TribePlayer [playerName=" + playerName + ", rank=" + rank
				+ ", avatarId=" + avatarId + ", titleNumber=" + titleNumber + "("+Titles.getTitle(titleNumber)+")"
				+ ", roomName=" + roomName + "]";
	}
}
