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
		this.zipName = zipName + ".zip";
	}
	
	public void ConvertToZip(FileToZip fileToZip) throws IOException
	{
		FileOutputStream fileOutputStream = null;
		ZipOutputStream zipOutputStream = null;
		FileInputStream fileInputStream = null;
		
		byte[] buffer = new byte[1024];
		
		try
		{
			fileOutputStream = new FileOutputStream(fileToZip.zipName);
			zipOutputStream = new ZipOutputStream(fileOutputStream);
			ZipEntry zipEntry = new ZipEntry(fileToZip.fileName);
			
			zipOutputStream.putNextEntry(zipEntry);
			
			fileInputStream = new FileInputStream(fileToZip.fileName);
			
			int len;
			
			while((len = fileInputStream.read(buffer)) >0)
			{
				zipOutputStream.write(buffer, 0, len);
			}	
		}
		finally
		{
			fileOutputStream.close();
			fileInputStream.close();
			zipOutputStream.close();	
		}
	}
}