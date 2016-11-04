package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DecompressZipToFiles 
{
	private String zipName = null; // Name of compressed zip file
	private String outputFolder = null; // Path where to store decompressed files
	
	public DecompressZipToFiles(String zipName, String outputFolder)
	{
		this.zipName = zipName;
		this.outputFolder = outputFolder;
	}
		
	public void Decompress(DecompressZipToFiles zipFile) throws IOException
	{
		byte[] buffer = new byte[1024];
		
		ZipInputStream zipInputStream = null;
		ZipEntry zipEntry = null;
		FileOutputStream fileOutputStream = null;
		
		try
		{
			// Assign folder path, if does not exists, create it
			File folder = new File(zipFile.outputFolder);
			if(!folder.exists())
			{
				folder.mkdir();
			}
			
			// Open stream to read zip
			zipInputStream = new ZipInputStream(new FileInputStream(zipFile.zipName));
			zipEntry = zipInputStream.getNextEntry();
			
			// Read files from zip
			while(zipEntry != null)
			{
				String fileName = zipEntry.getName();
				File newFile = new File(zipFile.outputFolder + File.separator + fileName);
				
				System.out.println("File unzipped to: " + newFile.getAbsolutePath());
				
				new File(newFile.getParent()).mkdirs();
				
				fileOutputStream = new FileOutputStream(newFile);
				
				int len;
				while((len = zipInputStream.read(buffer)) > 0)
				{
					fileOutputStream.write(buffer, 0, len);
				}
				
				fileOutputStream.close();
				zipEntry = zipInputStream.getNextEntry();
			}
		}
		finally
		{
			zipInputStream.closeEntry();
			zipInputStream.close();
		}
	}
}
