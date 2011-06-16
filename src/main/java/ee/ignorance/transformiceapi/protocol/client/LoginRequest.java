package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;
import ee.ignorance.transformiceapi.util.HashUtils;

public final class LoginRequest implements StringMessageRequest {

        private String username;
        private String password;
        private String room;

        public LoginRequest(String username, String password, String room) {
                this.username = username;
                this.password = password;
                this.room = room;
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
                bf.print(room);
                return bf.getBytes();
        }
}
