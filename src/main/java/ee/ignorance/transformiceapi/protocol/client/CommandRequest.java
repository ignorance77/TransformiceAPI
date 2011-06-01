package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class CommandRequest implements StringMessageRequest {

        private String message;

        public CommandRequest(String message) {
                this.message = message;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x06);
                bf.write(0x1a);
                bf.write(0x01);
                bf.print(message);
                return bf.getBytes();
        }
}
