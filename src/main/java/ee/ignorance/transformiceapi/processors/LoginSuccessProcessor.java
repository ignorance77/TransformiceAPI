package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;

public class LoginSuccessProcessor extends AbstractProcessor<LoginSuccessResponse> {

        @Override
        public void process(LoginSuccessResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.setMouseId(response.getMouseId());
                player.setModerator(response.isModerator());
                player.setAdmin(response.isAdmin());
                player.setLoginResult(true);
                connection.setRegisterResult(true);
        }
}
