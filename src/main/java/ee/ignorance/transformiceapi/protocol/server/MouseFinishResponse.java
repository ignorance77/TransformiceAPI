package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class MouseFinishResponse extends AbstractResponse {

	public int mouseID;
        public int standing;
        public double finishTime;

	public MouseFinishResponse(List<String> rawMessage) {
		super(rawMessage);
	}

	@Override
	public void parse(List<String> rawMessage) {
                this.mouseID = Integer.valueOf(rawMessage.get(1));
                this.standing = Integer.valueOf(rawMessage.get(4));
                this.finishTime = Integer.valueOf(rawMessage.get(5)) / 10.0;
        }

	public int getMouseID() {
		return mouseID;
	}

	public void setMouseID(int mouseID) {
		this.mouseID = mouseID;
	}

        public double getFinishTime() {
		return finishTime;
	}

	public void setMouseID(double finishTime) {
		this.finishTime = finishTime;
	}

        public int getStanding() {
		return standing;
	}

        public void setStanding(int standing) {
		this.standing = standing;
	}
}

