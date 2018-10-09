package chapter7;

import java.io.Console;

public class ReadPasswordTest {
	public static void main (String args[]) {
		String pass;
		Console c = System.console();
		String text = c.readLine("%s", "Enter your name:\n");
		pass = String.valueOf(c.readPassword("%s", "Enter password:\n"));
		System.out.println("Name is: " + text + "\nPassword is: " + pass);
		if (text.equals("sumit") && pass.equals("sumit123")) {
			System.out.println("You are authorised user");
		} else {
			System.err.println("You are not authorised");
		}
	}
}
