package com.indhawk.payment.encode;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA512Encoding {
	
	public static String sha512Encode(String str, String salt) throws NoSuchAlgorithmException, IOException {

		/*MessageDigest md = MessageDigest.getInstance("SHA-512");
		ByteArrayInputStream fis = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));
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
		return hexString.toString();*/
		
		byte[] b = hash(str);
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			hexString.append(Integer.toHexString(0xFF & b[i]));
		}
		return hexString.toString();
	}
	
	public static byte[] hash(String password) throws NoSuchAlgorithmException {
	    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");        
	    byte[] passBytes = password.getBytes();
	    byte[] passHash = sha256.digest(passBytes);
	    return passHash;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException 
    {
		String text = "QsdZAtJV|TX0000000000001|50|[{'itemid':'HS001', 'price':'50', 'quantity':'1'}]|Manoj|mj.sharma009@gmail.com|||||||||||fuqArMEbIj";
		//String text ="C0Dr8m|12345|10|Shopping|Test|test@test.com||abc||15|||||||3sf0jURk";
		String salt = "fuqArMEbIj";
		System.out.println("HASH = " + sha512Encode(text, salt));
    }

    public static String getSHA512(String toHash, String salt)
    {
        for (int i = 0; i < 100000; i++)
        {
            toHash = SHA512once(toHash+salt);
        }
        return SHA512once(toHash);
    }

    private static String SHA512once(String toHash)
    {

        MessageDigest md;
        String message = toHash;
        try 
        {
            md= MessageDigest.getInstance("SHA-512");

            md.update(message.getBytes());
            byte[] mb = md.digest();
            String out = "";
            for (int i = 0; i < mb.length; i++) 
            {
                byte temp = mb[i];
                String s = Integer.toHexString(new Byte(temp));
                while (s.length() < 2) 
                {
                    s = "0" + s;
                }
                s = s.substring(s.length() - 2);
                out += s;
            }
            return(out);

        } catch (NoSuchAlgorithmException e) 
        {
            System.out.println("ERROR: " + e.getMessage());
        }
        return "error";
    }

    public static String salt(String toSalt, String salt)
    {
        return "";
    }

}
