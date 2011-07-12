package ee.ignorance.transformiceapi.protocol.client;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class ClientInfoRequest implements ByteMessageRequest {

	private String language;
	private String platform;
	private String version;

	public ClientInfoRequest(String language, String platform, String version) {
		this.language = language;
		this.platform = platform;
		this.version = version;
	}

	@Override
	public byte[] getBytes() {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(byteOut);

		try {
			out.writeByte(0x1c);
			out.writeByte(0x11);
			out.writeUTF(language);
			out.writeUTF(platform);
			out.writeUTF(version);
		}
		catch (IOException e) {
			// Ignore?
		}

		return byteOut.toByteArray();
	}
}
