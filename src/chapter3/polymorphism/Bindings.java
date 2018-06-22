package chapter3.polymorphism;
/*
* static binding (also known as early binding).
* dynamic binding (also known as late binding).
* */

class Animals{
    void disp(){
        System.out.println("Hello I am animal.");
    }
}
class Dog{
    void disp(){
        System.out.println("Hello I am Dog");
    }
}
public class Bindings {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Static Bining");
        Animals a = new Animals();
        a.disp();
        System.out.println("----------------------------------------------------------------");
        Dog d = new Dog();
        System.out.println("\t\t Dynamic Bining");
        d.disp();
        System.out.println("----------------------------------------------------------------");

    }
}
