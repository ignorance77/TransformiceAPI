package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class PrivateChatRequest implements ByteMessageRequest {

        private String message;
        private String recipient;

        public PrivateChatRequest(String recipient, String message) {
                this.recipient = recipient;
                this.message = message;
        }

        @Override
        public byte[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.writeByte(6);
                        out.writeByte(7);
                        out.writeUTF(recipient);
                        out.writeUTF(message);

                } catch (Exception e) {
                        e.printStackTrace();
                }
                return byteOut.toByteArray();
        }
}
