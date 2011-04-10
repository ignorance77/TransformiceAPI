package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.RoomResponseProcessor;

import java.util.List;

public class RoomResponse extends AbstractResponse {

        private String room;

        public RoomResponse(List<String> rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(List<String> rawMessage) {
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
