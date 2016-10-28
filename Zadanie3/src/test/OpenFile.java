package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OpenFile {
	
	public String openFile()
	{
		System.out.println("Podaj œcie¿kê do pliku");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String everything = null;
		Path p = Paths.get(input);
		String fileName = p.getFileName().toString();
		System.out.println(fileName);
		File file = new File(input);
		
		if(!file.isDirectory())
		{
			file = file.getParentFile();
			
		}
		if (file.exists())
		{
			System.out.println("File exist");
			System.out.println(input);
			try {
				BufferedReader br = new BufferedReader(new FileReader(p.toString()));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while(line != null)
				{
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				everything = sb.toString();
				br.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		scan.close();
		return everything;
	}
}
