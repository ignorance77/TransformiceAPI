package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class MagicBeginRequest extends AbstractClientRequest {

        private int x;
        private int y;
        private int code;

        public MagicBeginRequest(int code, int x, int y) {
                this.x = x;
                this.y = y;
                this.code = code;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(0x08);
                bf.write(0x01);
                bf.print("" + code);
                bf.write(0x01);
                bf.print("" + x);
                bf.write(0x01);
                bf.print("" + y);
                bf.write(0x01);
                bf.print("0");
                return bf.getBytes();
        }
}
