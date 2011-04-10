package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.FriendJoinEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;

public class FriendJoinProcessor extends AbstractProcessor {

        @Override
        public void process(AbstractResponse response, GameConnection connection) {
                FriendJoinResponse resp = (FriendJoinResponse) response;
                connection.getPlayer().notifyListeners(new FriendJoinEvent(resp.getName()));
        }
}
