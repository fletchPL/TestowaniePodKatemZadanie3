package szyfrowanie;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SzyfrowanieASE {

	public String inp;
	public String enc;
	public String dec;
	
	public String getInp() {
		return inp;
	}

	public String getEnc() {
		return enc;
	}

	public String getDec() {
		return dec;
	}

	public void szyfrowanie(String message, String key) throws NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, NoSuchAlgorithmException {

		byte[] input = message.getBytes();
		byte[] pass = key.getBytes();
		MessageDigest md = MessageDigest.getInstance("MD5");
		pass = md.digest(pass);
		pass = Arrays.copyOf(pass, 16);

		SecretKeySpec sKeySpec = new SecretKeySpec(pass, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		byte[] encrypted = encrypt(sKeySpec, input, cipher);
		byte[] decrypted = decrypted(sKeySpec, input, cipher, encrypted);

		FileOutputStream fos;
		
		try
		{
			//print(input);
			inp = new String(input);
			
			//print(encrypted);
			enc = new String(encrypted);
			fos = new FileOutputStream("encrypted.txt");
			fos.write(encrypted);
			fos.close();
			
			//print(decrypted);
			dec = new String(decrypted);
			fos = new FileOutputStream("decrypted.txt");
			fos.write(decrypted);
			fos.close();
		}
		catch(IOException e)
		{
			
		}
		System.out.println(Arrays.equals(input, decrypted));
	}
	
	public static void print(byte[] b) {
		System.out.println(new String(b));
		System.out.println("Length: " + b.length * 8);
		System.out.println("---------------");
	}

	public byte[] encrypt(SecretKeySpec sKeySpec, byte[] input, Cipher cipher) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
		// zakodowana wiadomoœæ

		byte[] encrypted = cipher.doFinal(input);
		return encrypted;
	}

	public byte[] decrypted(SecretKeySpec sKeySpec, byte[] input, Cipher cipher, byte[] encrypted)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		cipher.init(Cipher.DECRYPT_MODE, sKeySpec);

		// odkodowana wiadomosc
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}
}
