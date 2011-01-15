package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;


public class FriendJoinResponse extends AbstractResponse {

	private String name;

	public FriendJoinResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		setName(rawMessage.get(1));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
