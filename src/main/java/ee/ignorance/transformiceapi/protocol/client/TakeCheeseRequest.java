package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class TakeCheeseRequest extends AbstractClientRequest {

        private String gameCode;

        public TakeCheeseRequest(String gameCode) {
                this.gameCode = gameCode;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(0x13);
                bf.write(0x01);
                bf.print(gameCode);
                return bf.getBytes();
        }
}
