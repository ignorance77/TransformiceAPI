package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.util.List;


public class MouseLeaveRoomResponse  extends AbstractResponse{

    	private int mouseID;

	public MouseLeaveRoomResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		int mouseID = Integer.parseInt(rawMessage.get(1));
                setMouseID(mouseID);
	}

	public int getMouseID() {
		return mouseID;
	}

	public void setMouseID(int mouseID) {
		this.mouseID = mouseID;
	}
}
