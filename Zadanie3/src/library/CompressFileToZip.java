package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressFileToZip 
{
	String fileName = null;
	String zipName = null;
	
	public CompressFileToZip(String fileName, String zipName)
	{
		this.fileName = fileName;
		this.zipName = zipName + ".zip";
	}
	
	public void Compress() throws IOException
	{
		FileOutputStream fileOutputStream = null;
		ZipOutputStream zipOutputStream = null;
		FileInputStream fileInputStream = null;
		
		byte[] buffer = new byte[1024];
		
		try
		{
			File file = new File(this.fileName);
			if(file.exists())
			{
				fileOutputStream = new FileOutputStream(this.zipName);
				zipOutputStream = new ZipOutputStream(fileOutputStream);
				ZipEntry zipEntry = new ZipEntry(this.fileName);
				
				zipOutputStream.putNextEntry(zipEntry);
				
				fileInputStream = new FileInputStream(this.fileName);
				
				int len = 0;
				
				while((len = fileInputStream.read(buffer)) > 0)
				{
					zipOutputStream.write(buffer, 0, len);
				}
				zipOutputStream.closeEntry();
				zipOutputStream.close();
				
				fileOutputStream.close();
				fileInputStream.close();
				
				System.out.println("File " + this.fileName + ", was compressed to zip file: " + this.zipName);
			}
			else
			{
				System.out.println("File: " + this.fileName + ", does not exists");
			}
		}
		finally
		{


		}
	}
}