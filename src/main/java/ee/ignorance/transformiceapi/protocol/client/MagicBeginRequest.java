package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.MagicType;
import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public final class MagicBeginRequest implements StringMessageRequest {

        private int x;
        private int y;
        private MagicType code;
        private int rotation;

        public MagicBeginRequest(MagicType code, int x, int y, int rotation) {
                this.x = x;
                this.y = y;
                this.code = code;
                this.rotation = rotation;
        }

        public MagicBeginRequest(MagicType code, int x, int y) {
                this(code, x, y, 0);
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x05);
                bf.write(13);
                bf.write(0x01);
                bf.print("" + code.value());
                bf.write(0x01);
                bf.print("" + x);
                bf.write(0x01);
                bf.print("" + y);
                bf.write(0x01);
                bf.print("" + rotation);
                return bf.getBytes();
        }
}
