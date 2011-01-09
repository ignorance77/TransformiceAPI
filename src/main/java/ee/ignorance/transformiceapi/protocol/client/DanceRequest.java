package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class DanceRequest extends AbstractClientRequest {

        private String gameCode;

        public DanceRequest(String gameCode) {
                this.gameCode = gameCode;
        }

        @Override
        public char[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.write(0x64);
                bf.write(0x61);
                bf.write(0x6e);
                bf.write(0x73);
                bf.write(0x65);
                bf.write(0x00);
                return bf.getBytesChar();
        }
}
