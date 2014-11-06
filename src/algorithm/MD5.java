package algorithm;

import java.security.MessageDigest;

/**
 * MD5加密算法
 * @author lujiabin
 * @since 2014-11-6
 */
public class MD5 {
	public static String digest(String content){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(content.getBytes("UTF-8"));
			byte[] b = md5.digest();
			StringBuffer buf = new StringBuffer("");
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if(i<0) i += 256;
				if(i<16) buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			return buf.toString().toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(digest("hello world"));
	}
}
