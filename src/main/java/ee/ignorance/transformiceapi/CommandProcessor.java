package ee.ignorance.transformiceapi;

import ee.ignorance.transformiceapi.protocol.server.AbstractCommand;

public abstract class CommandProcessor {

	public static CommandProcessor create(AbstractCommand command) {
		return null;
	}
	
	public abstract void process(AbstractCommand command, Player player);
	
}
