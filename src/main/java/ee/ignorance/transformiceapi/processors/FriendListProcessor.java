package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.GameConnection;
import ee.ignorance.transformiceapi.event.FriendListEvent;
import ee.ignorance.transformiceapi.protocol.server.FriendListResponse;

public class FriendListProcessor extends AbstractProcessor<FriendListResponse> {

        @Override
        public void process(FriendListResponse response, GameConnection connection) {
                connection.getPlayer().notifyListeners(new FriendListEvent(response.getFriends()));
        }
}
