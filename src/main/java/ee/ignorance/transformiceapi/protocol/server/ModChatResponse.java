package ee.ignorance.transformiceapi.protocol.server;

import java.io.DataInputStream;
import java.io.IOException;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.ModChatProcessor;

public final class ModChatResponse implements Processable {

        private String message;
        private String sender;
        private int type;

        public ModChatResponse(DataInputStream in) throws IOException {
	            type = in.readByte();
	            sender = in.readUTF();
	            message = in.readUTF();
        }

        public String getMessage() {
                return message;
        }

        public String getSender() {
                return sender;
        }

        public int getType() {
                return type;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new ModChatProcessor();
        }
}
