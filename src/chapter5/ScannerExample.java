package chapter5;

import java.util.Scanner;

public class ScannerExample {
	public static void main (String args[]) {
		String str = "e2 to e5";
		//Create scanner with the specified String Object
		Scanner scanner = new Scanner(str);
		//Change the delimiter of this scanner
		scanner.useDelimiter(" to ");
		//Printing the tokenized Strings
		System.out.println("---Tokenizes String---");
		while (scanner.hasNext("[a-e]{1}[1-8]{1}")) {
			System.out.println(scanner.next());
		}
		//Display the new delimiter
		System.out.println("Delimiter used: " + scanner.delimiter());
		scanner.close();
	}
}
