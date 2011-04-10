package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.LoginSuccessResponse;

public class LoginSuccessProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                LoginSuccessResponse resp = (LoginSuccessResponse) response;
                PlayerImpl player = connection.getPlayer();
                player.setMouseId(resp.getMouseId());
                player.setModerator(resp.isModerator());
                player.setAdmin(resp.isAdmin());
                player.setLoginResult(true);
                connection.setRegisterResult(true);
        }
}
