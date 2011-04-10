package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

public class LoginFailedProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                PlayerImpl player = connection.getPlayer();
                player.setLoginResult(false);
                connection.setRegisterResult(false);
        }

}
