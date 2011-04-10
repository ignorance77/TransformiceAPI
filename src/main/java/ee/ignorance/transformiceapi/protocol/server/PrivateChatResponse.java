package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.PrivateChatProcessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class PrivateChatResponse extends AbstractResponse {

        private String sender;
        private String message;
        private int type;

        public PrivateChatResponse(byte[] rawMessage) {
                super(rawMessage);
        }

        @Override
        public void parse(byte[] rawMessage) {
                DataInputStream in = new DataInputStream(new ByteArrayInputStream(rawMessage));
                try {
                        type = in.readByte();
                        sender = in.readUTF();
                        message = in.readUTF();
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

        public int getType() {
                return type;
        }

        @Override
        public AbstractProcessor getProcessor() {
                return new PrivateChatProcessor();
        }
}
