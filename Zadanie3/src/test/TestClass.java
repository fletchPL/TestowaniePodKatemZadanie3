package test;

import java.io.IOException;

public class TestClass 
{

	public static void main(String[] args) 
	{
		//FileDownload fileDownload = new FileDownload(url, fileName);
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
