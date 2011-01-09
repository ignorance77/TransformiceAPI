package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class SmileRequest extends AbstractClientRequest {

        private String gameCode;

        public SmileRequest(String gameCode) {
                this.gameCode = gameCode;
        }

        @Override
        public char[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.write(0x72);
                bf.write(0x69);
                bf.write(0x72);
                bf.write(0x65);
                bf.write(0x00);
                return bf.getBytesChar();
        }
}
