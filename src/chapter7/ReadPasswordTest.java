package chapter7;

import java.io.Console;

public class ReadPasswordTest {
	public static void main (String args[]) {
		String text = null, pass = null;
		try {
			Console c = System.console();
			try {
				text = c.readLine("%s", "Enter your name:\n");
				pass = String.valueOf(c.readPassword("%s", "Enter password:\n"));
			} catch (Exception e) {
				System.err.println("Error: You have mot run the program on console.");
				text = "";
				pass = "";
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Name is: " + text + "\nPassword is: " + pass);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (text.equals("sumit") && pass.equals("sumit123")) {
				System.out.println("You are authorised user");
			} else {
				System.err.println("You are not authorised");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
