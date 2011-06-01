package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class DeathRequest implements ByteMessageRequest {

        private int gameCode;

        public DeathRequest(String gameCode) {
                this.gameCode = Integer.valueOf(gameCode);
        }

        @Override
        public byte[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.writeByte(4);
                        out.writeByte(5);
                        out.writeInt(gameCode);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return byteOut.toByteArray();
        }
}
