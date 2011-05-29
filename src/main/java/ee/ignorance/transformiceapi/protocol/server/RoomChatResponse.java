package ee.ignorance.transformiceapi.protocol.server;

import java.io.DataInputStream;
import java.io.IOException;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.RoomChatProcessor;

public final class RoomChatResponse implements Processable {

        private String sender;
        private String message;

        public RoomChatResponse(DataInputStream in) throws IOException {
	            int playerCode = in.readInt();
	            sender = in.readUTF();
	            message = in.readUTF();
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new RoomChatProcessor();
        }
}
