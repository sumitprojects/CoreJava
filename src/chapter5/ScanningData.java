package chapter5;

/*
 * Introducing Scanner Class which allows you to get the input from the console.
 *
 *
 * below code is the import package of the scanner class
 * */

import java.util.Scanner;

public class ScanningData {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("\t\t Scanning Data");
        System.out.println("-------------------------------------------------------------------------");
        User u = new User();
        System.out.println("Enter your Id: ");
        u.setId(sc.nextInt());
        System.out.println("Enter your Name: ");
        u.setName(sc.next());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Hello, your name is " + u.getId() +
                " and Name is " + u.getName());
        System.out.println("-------------------------------------------------------------------------");
    }
}
