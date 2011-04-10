package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.TribeChatMessageProcessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class TribeChatMessageResponse extends AbstractResponse {

        private String sender;
        private String message;

        public TribeChatMessageResponse(byte[] rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(byte[] rawMessage) {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
                try {
                        message = in.readUTF();
                        sender = in.readUTF();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public String getSender() {
                return sender;
        }

        public String getMessage() {
                return message;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new TribeChatMessageProcessor();
        }
}
