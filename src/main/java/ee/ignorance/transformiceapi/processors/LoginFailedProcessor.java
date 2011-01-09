package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class LoginFailedProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		player.setLoginResult(false);
	}

}
