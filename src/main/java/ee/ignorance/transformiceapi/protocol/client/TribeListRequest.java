package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class TribeListRequest extends AbstractClientRequest {

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x10);
                bf.write(0x10);
                return bf.getBytes();
        }
}
