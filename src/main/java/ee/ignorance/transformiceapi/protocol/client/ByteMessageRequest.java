package ee.ignorance.transformiceapi.protocol.client;

public interface ByteMessageRequest extends Request {
	byte[] getBytes();
}
