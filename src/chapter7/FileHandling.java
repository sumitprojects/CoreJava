package chapter7;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private static final StringBuffer data = new StringBuffer("Hello World Java");
    private static final String string_data = "Hello World Java";
    private final static File file = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data.txt");
    private final static FileStreamDemo filedemo = new FileStreamDemo();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int choice = 0;
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\t\t File Handling Demo");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. File Write\n" +
                "2. File Read\n");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Writing Started");
                System.out.println("-------------------------------------------------------------------");
                filedemo.fileoutputstream(file, string_data);
                break;
            case 2:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
                StringBuffer sb = filedemo.fileinputstream(file);
                System.out.println("\t\t File Data: \n" + sb);
                break;
            default:
                System.out.println("Invalid Choice");
                break;

        }

    }
}
