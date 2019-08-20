package chapter5;

/*
 * Introducing Scanner Class which allows you to get the input from the console.
 *
 *
 * below code is the import package of the scanner class
 * */

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScanningData {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t Scanning Data");
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("Enter your Id & Name: ");
        User u = null;
        try {
            u = new User(sc.nextInt(), sc.nextLine());
            int c = 10 / 0;
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Hello, your id is " + u.getId() +
                    " and Name is " + u.getName().trim());
            System.out.println("-------------------------------------------------------------------------");
        } catch (ArithmeticException | InputMismatchException e) {
            System.out.println("Integer not found! \n" + e.getStackTrace()[e.getStackTrace().length - 1]);
        }
        //  u.setId(sc.nextInt());
//      System.out.println("Enter your Name: ");
        //   String data = sc.nextLine();
        //   u.setName(data);
    }
}
