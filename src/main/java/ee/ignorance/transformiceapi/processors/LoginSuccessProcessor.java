package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;

public class LoginSuccessProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		LoginSuccessResponse response = (LoginSuccessResponse) command;
		System.out.println("here");
		player.setMouseId(response.getMouseId());
		player.setModerator(response.isModerator());
		player.setAdmin(response.isAdmin());
		player.setLoginResult(true);
	}

}
