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
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		try {
			szyfrowanie.szyfrowanie();
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
