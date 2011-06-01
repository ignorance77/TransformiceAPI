package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class RoomChatRequest implements ByteMessageRequest {

        private String message;

        public RoomChatRequest(String message) {
                this.message = message;
        }

        @Override
        public byte[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.writeByte(6);
                        out.writeByte(6);
                        out.writeUTF(message);

                } catch (Exception e) {
                        e.printStackTrace();
                }
                return byteOut.toByteArray();
        }
}
