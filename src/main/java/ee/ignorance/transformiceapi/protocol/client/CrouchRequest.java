package ee.ignorance.transformiceapi.protocol.client;

import ee.ignorance.transformiceapi.protocol.ByteBuffer;

public class CrouchRequest extends AbstractClientRequest {

        boolean crouched;

        public CrouchRequest(boolean crouched) {
                this.crouched = crouched;
        }

        @Override
        public byte[] getBytes() {
                ByteBuffer bf = new ByteBuffer();
                bf.write(0x04);
                bf.write(0x09);
                bf.write(0x01);
                bf.print(crouched ? "1" : "0");
                return bf.getBytes();
        }
}
