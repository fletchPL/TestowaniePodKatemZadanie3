package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileToZip 
{
	String fileName = null;
	String zipName = null;
	
	FileToZip(String fileName, String zipName)
	{
		this.fileName = fileName;
		this.zipName = zipName;
	}
	
	public void ConvertToZip(FileToZip fileToZip) throws IOException
	{
		byte[] buffer = new byte[1024];
		
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream(fileToZip.zipName);
			ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
			ZipEntry zipEntry = new ZipEntry(fileToZip.fileName);
			
			zipOutputStream.putNextEntry(zipEntry);
			
			FileInputStream fileInputStream = new FileInputStream(fileToZip.fileName);
			
			
		}
		finally
		{
			
		}
	}
}