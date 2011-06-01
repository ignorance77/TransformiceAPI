package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.MagicType;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public final class MagicCastRequest implements ByteMessageRequest {

        private int x;
        private int y;
        private MagicType code;
        private int rotation;
        private int dx;
        private int dy;
        private boolean solid;

        public MagicCastRequest(MagicType code, int x, int y, int rotation, int dx, int dy, boolean solid) {
                this.x = x;
                this.y = y;
                this.code = code;
                this.rotation = rotation;
                this.dx = dx;
                this.dy = dy;
                this.solid = solid;
        }

        public MagicCastRequest(MagicType code, int x, int y) {
                this(code, x, y, 0, 0, 0, true);
        }

        @Override
        public byte[] getBytes() {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(byteOut);
                try {
                        out.writeByte(5);
                        out.writeByte(20);
                        out.writeShort(code.value());
                        out.writeShort(x);
                        out.writeShort(y);
                        out.writeShort(rotation); //Rotation
                        out.writeByte(dx); //x Velocity
                        out.writeByte(dy); //Y Velocity
                        out.writeByte(solid ? 1 : 0);
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return byteOut.toByteArray();
        }
}
