package ee.ignorance.transformiceapi.event;

import ee.ignorance.transformiceapi.PlayerProfile;

public class PlayerProfileEvent implements Event {

	private PlayerProfile playerProfile;
	
	public PlayerProfileEvent(PlayerProfile playerProfile) {
		this.playerProfile = playerProfile;
	}

	public PlayerProfile getPlayerProfile() {
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfile playerProfile) {
		this.playerProfile = playerProfile;
	}

}
