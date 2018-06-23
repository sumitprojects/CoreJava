package chapter3.inheritance;

class Cat extends Animal {
    void meow() {
        System.out.println("meowing...");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Hierarchical ");
        System.out.println("----------------------------------------------------------------");
        Cat c = new Cat();
        c.meow();
        c.eat();
        //c.bark();
    }
}
