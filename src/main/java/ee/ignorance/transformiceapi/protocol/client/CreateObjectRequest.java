package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class CreateObjectRequest extends AbstractClientRequest {

        private int type;
        private int x;
        private int y;

        public CreateObjectRequest(int type, int x, int y) {
                this.type = type;
                this.x = x;
                this.y = y;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(21);
                bf.write(0x01);
                bf.print("" + type);
                bf.write(0x01);
                bf.print("" + x);
                bf.write(0x01);
                bf.print("" + y);
                bf.write(0x01);
                bf.print("" + 1);
                bf.write(0x01);
                bf.print("" + 0);
                bf.write(0x01);
                bf.print("" + 0);
                bf.write(0x01);
                bf.print("" + 1);
                return bf.getBytes();
        }
}
