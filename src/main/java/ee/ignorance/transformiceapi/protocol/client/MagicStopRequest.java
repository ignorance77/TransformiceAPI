package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class MagicStopRequest extends AbstractClientRequest {

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(0x09);
                return bf.getBytes();
        }
}
