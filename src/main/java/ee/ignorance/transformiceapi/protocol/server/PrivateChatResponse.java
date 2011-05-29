package ee.ignorance.transformiceapi.protocol.server;

import java.io.DataInputStream;
import java.io.IOException;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.PrivateChatProcessor;

public final class PrivateChatResponse implements Processable {

        private String sender;
        private String message;
        private int type;

        public PrivateChatResponse(DataInputStream in) throws IOException {
	            type = in.readByte();
	            sender = in.readUTF();
	            message = in.readUTF();
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        public int getType() {
                return type;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new PrivateChatProcessor();
        }
}
