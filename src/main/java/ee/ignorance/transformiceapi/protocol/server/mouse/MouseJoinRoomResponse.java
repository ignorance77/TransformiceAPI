package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;
import java.util.List;


public class MouseJoinRoomResponse extends AbstractResponse{

    	private Mouse mouse;

	public MouseJoinRoomResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
		String[] mouseData = rawMessage.get(1).split("#");
		Mouse mouse = Mouse.parse(mouseData);
                setMouse(mouse);
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
}
