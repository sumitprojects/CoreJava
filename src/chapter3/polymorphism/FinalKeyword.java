package chapter3.polymorphism;

/*
 * variable
 * method
 * class
 *
 * */
final class Demo {
    void disp() {
        System.out.println("I am final and I am Can't be override / overload");
    }
}


public class FinalKeyword {
    final static int data = 100;

    public static void main(String[] args) {
        Demo d = new Demo();
        d.disp();
        //data =1000;   // compile time error

    }
}
