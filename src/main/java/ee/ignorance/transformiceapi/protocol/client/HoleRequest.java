package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class HoleRequest implements StringMessageRequest {

        private String gameCode;

        public HoleRequest(String gameCode) {
                this.gameCode = gameCode;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(18);
                bf.write(0x01);
                bf.print("0");
                bf.write(0x01);
                bf.print(gameCode);
                return bf.getBytes();
        }
}
