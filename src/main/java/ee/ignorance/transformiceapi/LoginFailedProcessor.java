package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class LoginFailedProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		player.setLoginResult(false);
	}

}
