package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.CountdownEvent;
import ee.ignorance.transformiceapi.protocol.server.CountdownResponse;

public class CountdownProcessor extends AbstractProcessor<CountdownResponse> {

	@Override
	public void process(CountdownResponse response, GameConnection connection) {
		PlayerImpl player = connection.getPlayer();
		player.notifyListeners(new CountdownEvent());
	}

}
