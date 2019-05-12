package com.car.utils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密和解密工具类
 * 
 * @author wind
 */
public class AESUtils {

	// AES密码器
	private static Cipher cipher;

	// 算法方式
	private static final String KEY_ALGORITHM = "AES";

	private static final Integer PRIVATE_KEY_SIZE_BIT = 128;
	private static final Integer PRIVATE_KEY_SIZE_BYTE = 16;

	public static void main(String[] args) throws Exception {
		Path keyPath = Paths.get("D:/aes.key");
		SecretKey secretKey = generateKey();
		System.out.println(parseByte2HexStr(secretKey.getEncoded()) +"\n");
		System.out.println(getAESKey());
	}

	public final static String ENCODING = "UTF-8";

	/**
	 * 将二进制转换成16进制
	 *
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 *
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	/**
	 * 生成密钥 自动生成base64 编码后的AES128位密钥
	 *
	 * @throws //NoSuchAlgorithmException @throws //UnsupportedEncodingException
	 */
	public static String getAESKey() throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
		kg.init(128);// 要生成多少位，只需要修改这里即可128, 192或256
		SecretKey sk = kg.generateKey();
		byte[] b = sk.getEncoded();
		return parseByte2HexStr(b);
	}

	/**
	 * AES 加密
	 *
	 * @param base64Key base64编码后的 AES key
	 * @param text      待加密的字符串
	 * @return 加密后的byte[] 数组
	 * @throws Exception
	 */
	public static byte[] getAESEncode(String base64Key, String text) throws Exception {
		byte[] key = parseHexStr2Byte(base64Key);
		SecretKeySpec sKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
		byte[] bjiamihou = cipher.doFinal(text.getBytes(ENCODING));
		return bjiamihou;
	}

	/**
	 * AES解密
	 *
	 * @param base64Key base64编码后的 AES key
	 * @param text      待解密的字符串
	 * @return 解密后的byte[] 数组
	 * @throws Exception
	 */
	public static byte[] getAESDecode(String base64Key, byte[] text) throws Exception {
		byte[] key = parseHexStr2Byte(base64Key);
		SecretKeySpec sKeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
		byte[] bjiemihou = cipher.doFinal(text);
		return bjiemihou;
	}

	private static SecretKey generateKey() throws Exception {
		// 获取一个密钥生成器实例
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		SecureRandom random = new SecureRandom();
//	    random.setSeed("123456".getBytes());//设置加密用的种子，密钥  
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey;
	}

}