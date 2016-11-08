package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import library.CompressFileToZip;
import library.DecompressZipToFiles;
import library.FileDownload;
import szyfrowanie.OpenFile;
import szyfrowanie.SzyfrowanieASE;

public class TestClass 
{
	public static void main(String[] args) throws Exception 
	{
		while(true)
		{
			System.out.println("Wybierz test\n1-Damian\n2-Maciej\n3-Wyjdz");
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			
			switch(choice)
			{
				case "1" : TestDamian(); break;
				case "2" : TestMaciej(); break;
				case "3" : System.exit(1);
				default  : System.out.println("Nie ma takiej opcji"); break;
			}	
			scan.close();
		}
		
	}
	
	private static void TestMaciej() throws Exception, Exception 
	{
		SzyfrowanieASE szyfrowanie = new SzyfrowanieASE();
		System.out.println("Podaj klucz: ");
		Scanner scan = new Scanner(System.in);
		String pass = scan.nextLine();
		OpenFile of = new OpenFile();
		String fileContent = of.openFile();
		try {
			
			szyfrowanie.szyfrowanie(fileContent,pass );
			
		} catch (InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
		scan.close();
	}

	public static void TestDamian()
	{
		URL url;
		try 
		{
			url = new URL("http://www.wp.pl");
			FileDownload fileDownload = new FileDownload(url, "Plik1.txt");
			fileDownload.Download();
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		CompressFileToZip compressFileToZip = new CompressFileToZip("Plik1.txt", "Zip1");		
		DecompressZipToFiles decompressFileToZip = new DecompressZipToFiles("Zip1.zip", "Folder");
		
		try 	
		{
			compressFileToZip.Compress();
			decompressFileToZip.Decompress();
			System.out.println("All Good!");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
