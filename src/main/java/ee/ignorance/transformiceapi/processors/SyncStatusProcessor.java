package ee.ignorance.transformiceapi.processors;

import ee.ignorance.transformiceapi.Player;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.SyncStatusResponse;

public class SyncStatusProcessor extends CommandProcessor {

	@Override
	public void process(AbstractResponse command, Player player) {
		SyncStatusResponse response = (SyncStatusResponse) command;
		player.setSyncStatus(response.getCodeSync() == player.getMouseId());
	}

}
