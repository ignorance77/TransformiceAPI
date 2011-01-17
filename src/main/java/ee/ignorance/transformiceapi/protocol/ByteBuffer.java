package ee.ignorance.transformiceapi.protocol;

import java.util.ArrayList;
import java.util.List;


public class ByteBuffer {

	private List<Byte> bytes;
	
	public ByteBuffer() {
		bytes = new ArrayList<Byte>();
	}
	
	public void write(byte b) {
		bytes.add(b);
	}
	
	public void write(int b) {
		write((byte) b);
	}
	
	public void print(String text) {
		byte[] textBytes = text.getBytes();
		for (byte x : textBytes) {
			bytes.add(x);
		}
	}
	
	public byte[] getBytes() {
		byte[] ret = new byte[bytes.size()];
		for (int i = 0; i < bytes.size(); i++) {
			ret[i] = (byte) bytes.get(i);
		}
		return ret;
	}
	
	public char[] getBytesChar() {
		char[] ret = new char[bytes.size()];
		for (int i = 0; i < bytes.size(); i++) {
			ret[i] = (char) bytes.get(i).byteValue();
		}
		return ret;
	}

	public int size() {
		return bytes.size();
	}

	@Override
	public String toString() {
		return "ByteBuffer [bytes=" + bytes + "]";
	}

	
}
