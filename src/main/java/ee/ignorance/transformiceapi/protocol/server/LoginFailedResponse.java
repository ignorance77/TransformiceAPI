package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class LoginFailedResponse extends AbstractResponse {

	public LoginFailedResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
	}

}
