package Threadings;

import java.io.IOException;

public class RuntimeDemo {
	
	public static void main (String[] args) {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start cmd.exe /K \"tree && ping 192.168.0.1 -t  \"");
			//runtime.exec("/usr/bin/gnome-terminal -e \"ls -l\"");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
