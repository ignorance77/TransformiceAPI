package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.PlayerImpl;
import ee.ignorance.transformiceapi.event.FriendJoinEvent;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.FriendJoinResponse;


public class FriendJoinProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, PlayerImpl player) {
            FriendJoinResponse response = (FriendJoinResponse) command;
            player.notifyListeners(new FriendJoinEvent(response.getName()));
	}
}
