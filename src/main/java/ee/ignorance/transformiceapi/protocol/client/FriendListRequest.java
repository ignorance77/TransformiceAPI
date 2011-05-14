package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class FriendListRequest extends AbstractClientRequest {

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x08);
                bf.write(0x0d);
                return bf.getBytes();
        }
}
