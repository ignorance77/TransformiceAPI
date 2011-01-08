package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class TZATResponse extends AbstractResponse {

	public TZATResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
	}

}
