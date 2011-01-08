package ee.ignorance.transformiceapi.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

	public static String SHA256(String s) {

		MessageDigest algorithm = null;

		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException nsae) {
			System.out.println("Cannot find digest algorithm");
			System.exit(1);
		}

		byte[] defaultBytes = s.getBytes();
		algorithm.reset();
		algorithm.update(defaultBytes);
		byte messageDigest[] = algorithm.digest();
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < messageDigest.length; i++) {
			String hex = Integer.toHexString(0xFF & messageDigest[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		String ret = hexString.toString();
		return ret;
	}
}
