package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class ProfileRequest extends AbstractClientRequest {

        private String nickname;

        public ProfileRequest(String nickname) {
                this.nickname = nickname;
        }

        @Override
        public char[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.print("profile ");
                bf.print(nickname);

                return bf.getBytesChar();
        }
}
