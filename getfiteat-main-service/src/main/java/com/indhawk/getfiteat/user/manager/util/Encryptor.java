package com.indhawk.getfiteat.user.manager.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encryptor {
	
	private static final Logger LOG = LoggerFactory.getLogger(Encryptor.class);
	
	private static final String SALT = "TaeTifTeg";
	
	public static String encrypt(String text) {
		try {
			return sha512Encode(text);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Error: Encryption failed ", e);
			throw new RuntimeException("Encryption failed");
		} catch (IOException e) {
			LOG.error("Error: Encryption failed ", e);
			throw new RuntimeException("Encryption failed");
		}
	}
	
	private static String sha512Encode(String str) throws NoSuchAlgorithmException, IOException {
		StringBuilder textBuilder = new StringBuilder(str);
		textBuilder.append(SALT);
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		ByteArrayInputStream fis = new ByteArrayInputStream(textBuilder.toString().getBytes(Charset.forName("UTF-8")));
		byte[] dataBytes = new byte[1024];
		int nread = 0;
		while ((nread = fis.read(dataBytes)) != -1) {
			md.update(dataBytes, 0, nread);
		}
		;
		byte[] mdbytes = md.digest();
		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println("Hex format : " + sb.toString());
		// convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < mdbytes.length; i++) {
			hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
		}
		return hexString.toString();
	}

}
