package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import library.CompressFileToZip;
import library.DecompressZipToFiles;
import library.FileDownload;

public class TestClass 
{
	public static void main(String[] args) 
	{
		
		TestDamian();
		TestMaciej();
	}
	
	private static void TestMaciej() 
	{
		
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
