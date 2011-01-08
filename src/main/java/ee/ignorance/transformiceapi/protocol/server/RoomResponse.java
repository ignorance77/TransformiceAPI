package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class RoomResponse extends AbstractResponse {

	private String room;
	
	public RoomResponse(List<String> rawMessage) {
		super(rawMessage);
		System.out.println("Room response");
	}

	@Override
	public void parse(List<String> rawMessage) {
		setRoom(rawMessage.get(1));
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
