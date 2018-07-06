package chapter3.polymorphism;

/*
 * Also Called as Instance Initializer block
 *
 * Also used for initializing final data
 * */
class Parent {
    final int data;

    public Parent() {
        //data = 10; //
        System.out.println("Hello I am Parent");
    }
    
    {
        data = 100;
        System.out.println("Hello I am Block of parent");
    }
    
    {
        System.out.println("Hello I am Block of parent2");
    }
}

class Child extends Parent {
    {
        System.out.println("Hello I am Block of Child");
    }

    public Child() {
        System.out.println("Hello I am Child");
    }
}

public class StaticBlock {
    public static void main(String[] args) {
        Child c = new Child();
    }
}
