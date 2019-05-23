package chapter7;


import chapter8.User;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    private static final String string_data = "Hello World Java";
    private static final User u = new User(2, "sumit");
	private static final chapter7.User user = new chapter7.User(1, "sumit", 25);
    private final static File file = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data.txt"), file2 = new File("E:\\CoreJava\\src\\chapter7\\txt\\Data2.txt");
    private final static FileStreamDemo filedemo = new FileStreamDemo();
	private static StringBuffer stringbuffer = new StringBuffer();
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
				"3. Seq Read\n" +
				"4. Obj to file" + "\n" +
				"5. object reader" + "\n" +
				"6. Data append on file writer" + "\n" +
				"7. File Reader" + "\n" +
				"8. File Writing with printstream");
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Writing Started");
                System.out.println("-------------------------------------------------------------------");
				filedemo.fileoutputstream(file, "sumit");
                break;
            case 2:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
    
                try {
                    sb = filedemo.fileinputstream(file);
					System.out.println("\t\t File Data: \n" + sb);
                } catch (IOException e) {
                    e.printStackTrace();
                }
	
				break;
            case 3:
                System.out.println("-------------------------------------------------------------------");
                System.out.println("\t\t File Reading Started");
                System.out.println("-------------------------------------------------------------------");
                try {
                    sb = filedemo.seqinputstream(file2, file);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("\t\t File Writing Started");
                    System.out.println("-------------------------------------------------------------------");
                    filedemo.fileoutputstream(file, sb.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("\t\t File Data: \n" + sb);
                break;
			case 4:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t Object to File Writing Started");
				System.out.println("-------------------------------------------------------------------");
				filedemo.transferObject(user, file);
				System.out.println("success");
				break;
			case 5:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t Object to File Writing Started");
				System.out.println("-------------------------------------------------------------------");
				chapter7.User user = filedemo.readObject(file);
				System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
				System.out.println("success");
				break;
			case 6:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t File append");
				System.out.println("-------------------------------------------------------------------");
				filedemo.fileWriterWithAppend(file, u.toString());
				System.out.println("success");
				break;
			case 7:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t File Reader");
				System.out.println("-------------------------------------------------------------------");
				stringbuffer = filedemo.fileReader(file);
				System.out.println(stringbuffer);
				//System.out.format("Data : %s \n",stringbuffer);
				break;
			case 8:
				System.out.println("-------------------------------------------------------------------");
				System.out.println("\t\t File Writing with printstream");
				System.out.println("-------------------------------------------------------------------");
				filedemo.fileprintstream(file, u.toString());
				break;
            default:
				System.err.println("Invalid Choice");
                break;

        }

    }
}
