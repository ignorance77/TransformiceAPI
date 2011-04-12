package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.FriendJoinEvent;
import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;

public class FriendJoinProcessor extends AbstractProcessor<FriendJoinResponse> {

        @Override
        public void process(FriendJoinResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new FriendJoinEvent(response.getName()));
        }
}
