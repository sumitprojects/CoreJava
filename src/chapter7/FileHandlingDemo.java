package chapter7;

import java.io.*;
import java.util.Scanner;

//enum data{YES,NO}
public class FileHandlingDemo {
	public static void main (String[] args) {
		String path = "E:\\CoreJava\\src\\chapter7\\txt\\Data3.txt";
		
		try {
			writingToFile(path);
			readingFromFile(path);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void readingFromFile (String path) {
		try {
			File file = new File(path);
			if (file.exists()) {
				FileInputStream inputStream = new FileInputStream(file);
				int i;
				if (file.canRead() && file.isFile() && !file.isHidden()) {
					while ((i = inputStream.read()) != -1) {
						System.out.print(((char) i));
					}
				} else {
					throw new IOException("File Reading Permission is not available.");
				}
				inputStream.close();
			} else {
				throw new FileNotFoundException("File Not Found");
			}
		} catch (IOException e) {
			System.out.println("File Reading Error : " + e.getMessage());
		}
	}
	
	
	private static void writingToFile (String path) {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(System.in);
			if (file.canWrite() && file.isFile()) {
				FileOutputStream outputStream = new FileOutputStream(file, true);
				System.out.println("Enter the data to write");
				String data = scanner.nextLine();
				outputStream.write(data.getBytes());
				outputStream.close();
				System.out.println("Data written Successfully");
			} else {
				throw new IOException("You are not permitted to change current File!");
			}
		} catch (IOException e) {
			System.out.println("File Reading Error : " + e.getMessage());
		}
	}
}
