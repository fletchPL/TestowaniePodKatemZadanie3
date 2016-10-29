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
		String message = "Moja wiadomoœæ jest bardzo fajna i d³uga";
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		
		OpenFile of = new OpenFile();
		String fileContent = of.openFile();
		try {
			String pass = "key";
			szyfrowanie.szyfrowanie(fileContent,pass );
			
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
		
	}

}
