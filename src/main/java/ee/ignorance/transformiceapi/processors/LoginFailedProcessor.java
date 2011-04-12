package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.protocol.server.LoginFailedResponse;

public class LoginFailedProcessor extends AbstractProcessor<LoginFailedResponse>   {

        @Override
        public void process(LoginFailedResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.setLoginResult(false);
                connection.setRegisterResult(false);
        }
}
