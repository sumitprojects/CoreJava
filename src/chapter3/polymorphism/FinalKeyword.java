package chapter3.polymorphism;

/*
 * variable
 * method
 * class
 *
 * */

/*final class could be inerited in to any other class*/
final class Demo {
    void disp() {
        System.out.println("I am final and I can't be overrided / overloaded by another class.");
    }
}


class Another{
    final void disp(){
        System.out.println("I am unmodifiable.");
    }

}

public class FinalKeyword extends Another{
    final static int data = 100;

    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Final Class Call ");
        System.out.println("----------------------------------------------------------------");
        d.disp();

        FinalKeyword f = new FinalKeyword();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Final Method Call  ");
        System.out.println("----------------------------------------------------------------");
        f.disp();

        //data =1000;   // compile time error

    }
}
