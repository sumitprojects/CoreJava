package chapter7;


import chapter8.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private static final String string_data = "Hello World Java";
    private static final User u = new User(2, "sumit");
    private final static File file = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data.txt"), file2 = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data2.txt");
    private final static FileStreamDemo filedemo = new FileStreamDemo();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        StringBuffer sb = null;
        int choice = 0;
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\t\t File Handling Demo");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. File Write\n" +
                "2. File Read\n" +
                "3. Seq Read");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Writing Started");
                System.out.println("-------------------------------------------------------------------");
                filedemo.fileoutputstream(file, u.toString());
                break;
            case 2:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
    
                try {
                    sb = filedemo.fileinputstream(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\t\t File Data: \n" + sb);
                break;
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
                try {
                    sb = filedemo.seqinputstream(file, file2);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("\t\t File Writing Started");
                    System.out.println("-------------------------------------------------------------------");
                    filedemo.fileoutputstream(file, sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\t\t File Data: \n" + sb);
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }
}
