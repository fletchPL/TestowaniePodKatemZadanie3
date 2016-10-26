package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class TestClass 
{

	public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException 
	{
		String message = "Moja wiadomo�� jest bardzo fajna i d�uga";
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		try {
			String pass = "key";
			szyfrowanie.szyfrowanie(message,pass );
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
		
	}

}
