package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class DeathRequest extends AbstractClientRequest {

        private int gameCode;

        public DeathRequest(String gameCode) {
                this.gameCode = Integer.valueOf(gameCode);
        }

        @Override
        public char[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.writeByte(4);
                        out.writeByte(5);
                        out.writeInt(gameCode);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                byte[] bytes = byteOut.toByteArray();
                char[] chars = new char[bytes.length];
                for (int i = 0; i < chars.length; i++) {
                        chars[i] = (char) bytes[i];
                }

                return chars;
        }
}
