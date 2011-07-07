package ee.ignorance.transformiceapi.event;

public class TribeInviteEvent implements Event<TribeInviteListener> {

	private int tribeId; // Not sure what is it
	private String tribeName;
	private String playerName;

	public TribeInviteEvent(int tribeId, String tribeName, String playerName) {
		this.tribeId = tribeId;
		this.tribeName = tribeName;
		this.playerName = playerName;
	}

	public int getTribeId() {
		return tribeId;
	}

	public String getTribeName() {
		return tribeName;
	}

	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void notifyListener(TribeInviteListener listener) {
		listener.tribeInviteReceived(tribeId, tribeName, playerName);
	}
}
