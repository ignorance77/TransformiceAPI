package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class CryRequest extends AbstractClientRequest {

        @Override
        public char[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.write(0x70);
                bf.write(0x6c);
                bf.write(0x65);
                bf.write(0x75);
                bf.write(0x72);
                bf.write(0x65);
                bf.write(0x72);
                bf.write(0x00);
                return bf.getBytesChar();
        }
}
