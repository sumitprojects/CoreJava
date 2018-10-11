package chapter7;

import java.io.FilePermission;
import java.security.PermissionCollection;

public class FilePermissionExample {
	
	public static void main (String[] args) {
		String srg = "E:\\CoreJava\\src\\chapter7\\txt\\Data.txt";
		FilePermission file1 = new FilePermission("E:\\CoreJava\\src\\chapter7\\-", "read");
		PermissionCollection permission = file1.newPermissionCollection();
		permission.add(file1);
		FilePermission file2 = new FilePermission(srg, "write");
		permission.add(file2);
		if (permission.implies(new FilePermission("E:\\CoreJava\\src\\chapter7\\-", "read"))) {
			System.out.println("Read, Write permission is granted for the path " + srg);
		} else {
			System.out.println("No Read, Write permission is granted for the path " + srg);
		}
	}
}
