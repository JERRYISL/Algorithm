package algorithm;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Andorid,Java通用AES加密算法
 * @author lujiabin
 * @since 2014-11-6
 */
public class AES {
	public static final String VIPARA = "1234567887654321";
	public static final String bm = "UTF-8";
	
	/**
	 * @param pwd 秘钥
	 * @param text 明文
	 * @return 密文
	 * @throws Exception
	 */
	public static String encrypt(String pwd, String text) throws Exception {
		IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
		SecretKeySpec key = new SecretKeySpec(pwd.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(text.getBytes(bm));
		return new String(Base64.encode(encryptedData));
	}
	
	/**
	 * @param pwd 秘钥
	 * @param encryptedtext 密文
	 * @return 明文
	 * @throws Exception
	 */
	public static String decrypt(String pwd, String encryptedtext) throws Exception {
		byte[] byteMi = Base64.decode(encryptedtext);
		IvParameterSpec zeroIv = new IvParameterSpec(VIPARA.getBytes());
		SecretKeySpec key = new SecretKeySpec(pwd.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte[] decryptedData = cipher.doFinal(byteMi);
		return new String(decryptedData, bm);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("JERRYISLJERRYISL", "abc123"));
		System.out.println(decrypt("JERRYISLJERRYISL", "T6E8LqxnhPajlW9m4Rz4Eg=="));
	}
}
