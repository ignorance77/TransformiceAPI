package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;


public class MouseGotCheeseResponse extends AbstractResponse {

	private int mouseID;

	public MouseGotCheeseResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
                setMouseID(Integer.parseInt(rawMessage.get(1)));
	}

        public int getMouseID(){
                return mouseID;
        }

        public void setMouseID(int mouseID){
                this.mouseID = mouseID;
        }
}
