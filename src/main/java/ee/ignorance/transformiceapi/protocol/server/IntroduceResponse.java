package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class IntroduceResponse extends AbstractResponse {

	private String hashedBytes;
	
	public IntroduceResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		setHashedBytes(rawMessage.get(1));
	}

	public String getHashedBytes() {
		return hashedBytes;
	}

	public void setHashedBytes(String hashedBytes) {
		this.hashedBytes = hashedBytes;
	}
	
}
