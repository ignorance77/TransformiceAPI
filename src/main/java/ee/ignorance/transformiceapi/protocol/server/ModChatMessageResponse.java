package ee.ignorance.transformiceapi.protocol.server;

import ee.ignorance.transformiceapi.processors.AbstractProcessor;
import ee.ignorance.transformiceapi.processors.ModChatMessageProcessor;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class ModChatMessageResponse extends AbstractResponse {

        private String message;
        private String sender;
        private int type;

        public ModChatMessageResponse(byte[] rawMessage) {
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
                return new ModChatMessageProcessor();
        }
}
