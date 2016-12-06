package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import szyfrowanie.OpenFile;
import szyfrowanie.SzyfrowanieASE;


public class TestClass 
{

	public static void main(String[] args) throws NoSuchProviderException, NoSuchAlgorithmException 
	{
		
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		System.out.println("Podaj klucz: ");
		Scanner scan = new Scanner(System.in);
		String pass = scan.nextLine();
		OpenFile of = new OpenFile();
		String fileContent = of.openFile();
		try {
			
			szyfrowanie.szyfrowanie(fileContent,pass );
			System.out.println(szyfrowanie.getInp());
			System.out.println(szyfrowanie.getDec());
			System.out.println(szyfrowanie.getEnc());
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
		scan.close();
	}

}
