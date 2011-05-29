package ee.ignorance.transformiceapi.protocol.server.mouse;

import java.util.List;

import ee.ignorance.transformiceapi.Mouse;
import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.mouse.MouseJoinRoomProcessor;
import ee.ignorance.transformiceapi.protocol.server.Processable;

public final class MouseJoinRoomResponse implements Processable {

        private Mouse mouse;

        public MouseJoinRoomResponse(List<String> rawMessage) {
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
