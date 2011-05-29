package ee.ignorance.transformiceapi.util;

import java.util.Formatter;

public final class StringUtils {
	public static String byteArrayToHexString(byte[] raw) {
		StringBuilder sb = new StringBuilder(raw.length * 2);
		Formatter formatter = new Formatter(sb);
		
		for (byte b : raw) {
			formatter.format("%02x ", b);
		}
		
		return sb.toString();
	}
}

