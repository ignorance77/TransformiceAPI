package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class KissRequest extends AbstractClientRequest {

        @Override
        public char[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.write(0x6b);
                bf.write(0x69);
                bf.write(0x73);
                bf.write(0x73);
                bf.write(0x00);
                return bf.getBytesChar();
        }
}
