package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribeInviteProcessor;

public final class TribeInviteResponse implements Processable {

	private int tribeId; // Not sure what is it
	private String playerName;
	private String tribeName;

	public TribeInviteResponse(List<String> rawMessage) {
		tribeId = Integer.parseInt(rawMessage.get(1));
		playerName = rawMessage.get(2);
		tribeName = rawMessage.get(3);
	}

	public int getTribeId() {
		return tribeId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getTribeName() {
		return tribeName;
	}

	@Override
	public AbstractProcessor getProcessor() {
		return new TribeInviteProcessor();
	}
}
