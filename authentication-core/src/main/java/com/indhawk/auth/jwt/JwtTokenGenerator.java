package com.indhawk.auth.jwt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JWT (JSON Web Tokens) are an important piece in ensuring trust and security
 * in your application. JWT allow claims, such as user data, to be represented
 * in a secure manner. Simply put, a JWT is just a string with the following
 * format:
 * <p>
 * <b><code>header.payload.signature</code></b>
 * </p>
 * 
 * For more JWT understanding visit http link given below:
 * <p>
 * https://medium.com/vandium-software/5-easy-steps-to-understanding-json-web-tokens-jwt-1164c0adfcec
 * </p>
 * 
 * @author MJ
 *
 */
public class JwtTokenGenerator {
	
	private static final Logger LOG = LoggerFactory.getLogger(JwtTokenGenerator.class);
	
	private static final String SIGNATURE_PREFIX = "TaeTifTeg";
	
	private static final String SEPARATER = ".";
	
	public static String generateJwtToken(String userId) {
		String header = createHeaderToken();
		String payload = createPayloadToken(userId);
		String signature = createSignatureToken(userId);
		StringBuffer sb = new StringBuffer();
		return sb.append(header)
				.append(SEPARATER)
				.append(payload)
				.append(SEPARATER)
				.append(signature)
				.toString();
	}
	
	private static String createHeaderToken() {
		String header = "{\"typ\": \"JWT\",  \"alg\": \"SHA-256\"}";
		String encodedHeader = null;
		try {
			encodedHeader = sha256Encode(header);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("ERROR: Failed to generate JWT header token.", e);
			throw new RuntimeException("Failed to generate JWT token.");
		}
		return encodedHeader;
	}
	
	private static String createPayloadToken(String userId) {
		String payload = "{\"userId\": \"" + userId + "\"}";
		String encodedPayload = null;
		try {
			encodedPayload = sha256Encode(payload);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("ERROR: Failed to generate JWT payload token.", e);
			throw new RuntimeException("Failed to generate JWT token.");
		}
		return encodedPayload;
	}
	
	private static String createSignatureToken(String userId) {
		String signatureText = SIGNATURE_PREFIX + SEPARATER + userId;
		String signature = "{\"sig\": \"" + signatureText + "\"}";
		String encodedSignature = null;
		try {
			encodedSignature = sha256Encode(signature);
		} catch (NoSuchAlgorithmException e) {
			LOG.error("ERROR: Failed to generate JWT signature token.", e);
			throw new RuntimeException("Failed to generate JWT token.");
		}
		return encodedSignature;
	}
	
	private static String sha256Encode(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));

		// bytes to hex
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
	}
	
	
	
	

}
