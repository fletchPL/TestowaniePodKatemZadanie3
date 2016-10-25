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
}