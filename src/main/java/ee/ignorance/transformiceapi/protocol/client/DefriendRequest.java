package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;


public class DefriendRequest implements StringMessageRequest {

        private String nickname;

        public DefriendRequest(String nickname) {
                this.nickname = nickname.substring(0,1).toUpperCase() + nickname.substring(1).toLowerCase(); // Server is picky about case
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x08);
                bf.write(0x0e);
                bf.write(0x01);
                bf.print(nickname);
                return bf.getBytes();
        }
}