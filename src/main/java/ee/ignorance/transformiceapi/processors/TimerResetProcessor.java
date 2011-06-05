package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.TimerResetEvent;
import ee.ignorance.transformiceapi.protocol.server.TimerResetResponse;


public class TimerResetProcessor extends AbstractProcessor<TimerResetResponse> {

	@Override
	public void process(TimerResetResponse response, GameConnection connection) {
		PlayerImpl player = connection.getPlayer();
		player.notifyListeners(new TimerResetEvent());
	}

}
