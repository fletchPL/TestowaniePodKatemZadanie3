package test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OpenFile {
	
	public void openFile()
	{
		System.out.println("Podaj œcie¿kê do pliku");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
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
		}
		scan.close();
	}
}
