package ee.ignorance.transformiceapi.event;

public interface TribeInviteListener {

	void tribeInviteReceived(int tribeId, String tribeName, String playerName);
}
