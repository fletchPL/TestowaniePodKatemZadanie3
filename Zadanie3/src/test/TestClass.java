package test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class TestClass 
{

	public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException 
	{
		String message = "Moja wiadomo�� jest bardzo fajna i d�uga";
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		OpenFile of = new OpenFile();
		of.openFile();
		/*try {
			String pass = "key";
			//szyfrowanie.szyfrowanie(message,pass );
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}*/
		
	}

}
