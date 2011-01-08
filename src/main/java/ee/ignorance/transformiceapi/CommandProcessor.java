package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import ee.ignorance.transformiceapi.protocol.server.RoomResponse;
import ee.ignorance.transformiceapi.protocol.server.StartGameResponse;
import ee.ignorance.transformiceapi.protocol.server.TZATResponse;

public abstract class CommandProcessor {

	public static CommandProcessor create(AbstractResponse command) {
		if (command instanceof RoomResponse) {
			return new RoomResponseProcessor();
		}
		if (command instanceof StartGameResponse) {
			return new StartGameResponseProcessor();
		}
		if (command instanceof TZATResponse) {
			return new TZATResponseProcessor();
		}
		return null;
	}
	
	public abstract void process(AbstractResponse command, Player player);
	
}
