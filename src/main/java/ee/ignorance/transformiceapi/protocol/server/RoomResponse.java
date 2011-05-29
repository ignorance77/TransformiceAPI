package ee.ignorance.transformiceapi.protocol.server;

import java.util.List;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.RoomResponseProcessor;

public final class RoomResponse implements Processable {

        private String room;

        public RoomResponse(List<String> rawMessage) {
        	room = rawMessage.get(1);
        }

        public String getRoom() {
                return room;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new RoomResponseProcessor();
        }
}
