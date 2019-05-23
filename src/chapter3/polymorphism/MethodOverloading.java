package chapter3.polymorphism;
/*
Different ways to overload the method
        There are two ways to overload the method in java

        By changing number of arguments
        By changing the data type
*/

public class MethodOverloading {
    static int add(int a, int b) {
        System.out.println("Int Data 2 para");
        return a + b;
    }
    static int add(int a, int b, int c) {
        System.out.println("Int Data 3 para");
        return a + b + c;
    }

    static double add(double a, double b) {
        System.out.println("Double Data");
        return a + b;
    }

    static long add(long a, long b) {
        System.out.println("Long Data");
        return (a + b);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("\t\t Method Overloading");
        System.out.println(MethodOverloading.add(11, 11));
        System.out.println(MethodOverloading.add(11, 11, 11));
        System.out.println(MethodOverloading.add(12.3, 12.6));
        System.out.println(MethodOverloading.add(11L, 11));
        for (int i = 0; i < 50; i++) {
            System.out.print("-");
        }

    }
}