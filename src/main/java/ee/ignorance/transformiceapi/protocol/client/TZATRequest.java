package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class TZATRequest extends AbstractClientRequest {

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x1a);
                bf.write(0x1a);
                return bf.getBytes();
        }
}
