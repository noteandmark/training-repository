package src.main.java.com.home.andreimarkov.shoesupload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ShoesUpload {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File ("files/shoes.csv");
		Scanner scanner = new Scanner(file);
		
		File fileOutput = new File("files/result.txt");
		PrintWriter pw = new PrintWriter(fileOutput);
		
		while (scanner.hasNextLine()) {
			String[] array = scanner.nextLine().split(";");
			if (Integer.parseInt(array[2]) == 0) {
				pw.println(array[0] + ", " + array[1] + ", " + array[2]);
			}
		}
		pw.close();
		scanner.close();
	}
}
