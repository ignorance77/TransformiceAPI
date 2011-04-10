package ee.ignorance.transformiceapi.protocol.server.mouse;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseJoinRoomProcessor;
import ee.ignorance.transformiceapi.protocol.server.AbstractResponse;

import java.util.List;

public class MouseJoinRoomResponse extends AbstractResponse {

        private Mouse mouse;

        public MouseJoinRoomResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
                String[] mouseData = rawMessage.get(1).split("#");
                mouse = Mouse.parse(mouseData);
        }

        public Mouse getMouse() {
                return mouse;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new MouseJoinRoomProcessor();
        }
}
