package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

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
