package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownload 
{
	URL url;
	String fileName;
	
	FileDownload(URL url, String fileName)
	{
		this.url = url;
		this.fileName = fileName;
		
		try 
		{
			Download(this);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private void Download(FileDownload fileDownload) throws IOException
	{
		InputStream inputStream = null;
		FileOutputStream fileOutputStream = null;
		
		try
		{
			URLConnection urlConnection = fileDownload.url.openConnection();
			
			inputStream = urlConnection.getInputStream();
			fileOutputStream = new FileOutputStream(fileDownload.fileName);
			
			byte[] buffer = new byte[4096];
			int len;
			
			while((len = inputStream.read(buffer)) > 0)
			{
				fileOutputStream.write(buffer,0,len);
			}
		}
		finally
		{
			try
			{
				if(inputStream != null)
				{
					inputStream.close();
				}
			}
			finally
			{
				if(fileOutputStream != null)
				{
					fileOutputStream.close();
				}
			}
		}
	}
}