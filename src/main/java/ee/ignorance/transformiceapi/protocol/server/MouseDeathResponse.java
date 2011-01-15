package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

public class MouseDeathResponse extends AbstractResponse {

        private int mouseID;

        public MouseDeathResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                setMouseID(Integer.valueOf(rawMessage.get(1)));
        }

        public int getMouseID() {
                return mouseID;
        }

        public void setMouseID(int mouseID) {
                this.mouseID = mouseID;
        }
}
