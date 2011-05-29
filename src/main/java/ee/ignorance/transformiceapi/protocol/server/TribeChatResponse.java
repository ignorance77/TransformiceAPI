package ee.ignorance.transformiceapi.protocol.server;

import java.io.DataInputStream;
import java.io.IOException;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribeChatProcessor;

public final class TribeChatResponse implements Processable {

        private String sender;
        private String message;

        public TribeChatResponse(DataInputStream in) throws IOException {
	        	 message = in.readUTF();
	             sender = in.readUTF();
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new TribeChatProcessor();
        }
}
