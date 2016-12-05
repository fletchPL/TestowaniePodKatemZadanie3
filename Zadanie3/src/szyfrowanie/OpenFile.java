package szyfrowanie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OpenFile {

	public String openFile() {

		String everything = null;
		String input = "Plik1.txt";
		File file = new File(input);

		if (file.exists()) {
			System.out.println("File exist");
			System.out.println(input);
			try {
				BufferedReader br = new BufferedReader(new FileReader(input));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while (line != null) {
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				everything = sb.toString();
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Checksum check = new Checksum();
		try {
			/*System.out.println("\n");
			System.out.println("Checksum MD5");
			System.out.println(check.getMD5Checksum(input));
			System.out.println("Checksum SHA");
			System.out.println(check.getSHAChecksum(input));
			System.out.println("\n\n");*/
			check.getMD5Checksum(input);
			check.getSHAChecksum(input);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return everything;
	}
}
