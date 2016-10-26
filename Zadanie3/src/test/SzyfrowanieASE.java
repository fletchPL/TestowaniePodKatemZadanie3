package test;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SzyfrowanieASE {

	public void szyfrowanie(String message, String key) throws NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, NoSuchAlgorithmException{
		
		byte[] input = message.getBytes();
		byte[] pass = key.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		pass = md.digest(pass);
		pass = Arrays.copyOf(pass,16);
		//KeyGenerator kGen = KeyGenerator.getInstance("AES");
		//kGen.init(128);
 
		//SecretKey sKey = kGen.generateKey();
 
		//byte[] rawKey = sKey.getEncoded();
 
		SecretKeySpec sKeySpec = new SecretKeySpec(pass, "AES");
 
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
 
		cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
 
		// zakodowana wiadomoœæ
		byte[] encrypted = cipher.doFinal(input);
 
		cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
		// odkodowana wiadomosc
		byte[] decrypted = cipher.doFinal(encrypted);
 
		print(input);
		print(encrypted);
		print(decrypted);
 

		System.out.println(Arrays.equals(input, decrypted));
	}

	public static void print(byte[] b){
		System.out.println(new String(b));
		System.out.println("Length: " + b.length * 8);
		System.out.println("---------------");
	}
}
