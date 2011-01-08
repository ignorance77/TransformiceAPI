package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public abstract class AbstractResponse {

	public AbstractResponse(List<String> rawMessage) {
		parse(rawMessage);
	}
	
	public abstract void parse(List<String> rawMessage);
	
}
