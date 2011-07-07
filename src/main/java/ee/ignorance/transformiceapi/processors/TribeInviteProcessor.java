package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.TribeInviteEvent;
import ee.ignorance.transformiceapi.protocol.server.TribeInviteResponse;

public class TribeInviteProcessor extends AbstractProcessor<TribeInviteResponse> {

	@Override
	public void process(TribeInviteResponse response, GameConnection connection) {
		connection.getPlayer().notifyListeners(new TribeInviteEvent(response.getTribeId(), response.getTribeName(), response.getPlayerName()));
	}
}
