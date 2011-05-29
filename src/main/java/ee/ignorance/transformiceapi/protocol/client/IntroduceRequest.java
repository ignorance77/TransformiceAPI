package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public final class IntroduceRequest extends AbstractClientRequest {

	private static final Logger logger = Logger.getLogger(IntroduceRequest.class);
	private final int version;

	public IntroduceRequest(int version) {
		this.version = version;
	}

	@Override
	public byte[] getBytes() {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		DataOutputStream out = new java.io.DataOutputStream(byteOut);

		try {
			out.writeByte(28);
			out.writeByte(1);
			out.writeShort(version);
			out.flush();
		} catch (IOException e) {
			logger.warn("failed constructing request", e);
		}

		return byteOut.toByteArray();
	}
}
