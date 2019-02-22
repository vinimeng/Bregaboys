package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    
    public static String hashingSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
	String hexString = "";
	for (byte b: messageDigest) {
            hexString += (String.format("%02X", 0xFF & b));
	}
	return hexString;
    }
}