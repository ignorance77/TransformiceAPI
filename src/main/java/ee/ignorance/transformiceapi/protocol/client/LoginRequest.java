package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.util.HashUtils;

public class LoginRequest extends AbstractClientRequest {

        private String username;
        private String password;

        public LoginRequest(String username, String password) {
                this.username = username;
                this.password = password;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x1a);
                bf.write(0x04);
                bf.write(0x01);
                bf.print(username);
                bf.write(0x01);
                bf.print(HashUtils.SHA256(password));
                bf.write(0x01);
                bf.write(0x31);
                return bf.getBytes();
        }
}
