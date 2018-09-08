package chapter6;

import java.util.Scanner;

interface DataFunction {
    void disp ();
}

interface DataFunction2 {
    double compute (double a, double b);
}

public class LambdaFun {
    public static void main (String[] args) {
        String option = "N";
        double num1 = 0, num2 = 0;
        DataFunction b1 = () -> {
            System.out.println("Hello java");
        };
        
        Scanner sc = new Scanner(System.in);
        do {
            
            /*
             * Addition Block
             * */
            DataFunction2 add = (double a, double b) -> {
                return a + b;
            };
            System.out.println("Enter two numbres for addition:");
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
            System.out.println("Add : " + add.compute(sc.nextDouble(), sc.nextDouble()));
            
            
            /*
             * Subtraction Block
             * */
            add = (double a, double b) -> {
                return a - b;
            };
            System.out.println("Enter two numbres for substraction:");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
            System.out.println("Sub : " + add.compute(sc.nextDouble(), sc.nextDouble()));
            
            /*
             * Division Block
             * */
            add = (double a, double b) -> {
                if (b == 0)
                    return 0;
                else
                    return a / b;
            };
            System.out.println("Enter two numbres for Division:");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
            System.out.println("Div : " + add.compute(sc.nextDouble(), sc.nextDouble()));
            
            
            /*
             * Multiplication block
             * */
            add = (double a, double b) -> {
                return a * b;
            };
            System.out.println("Enter two numbres for Multiplication:");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
            System.out.println("Mul : " + add.compute(sc.nextDouble(), sc.nextDouble()));
            
            System.out.println("Do you want to continue?\n y for yes - other for no");
            option = sc.next();
            try {
                System.out.println("Application is going to Exit");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error : " + e);
            }
        } while (option.toLowerCase().equals("y"));
        
        
    }
}
