package chapter3.polymorphism;

/*
 * Also Called as Instance Initializer block
 *
 * Also used for initializing final data
 * */
class Parent {
    final int data;
  
  static {
    System.out.println("Hello I am Static Block parent");
  }
  
  {
    data = 100;
    System.out.println("Hello I am Block of parent");
  }
    
    public Parent() {
      //data = 10;
        System.out.println("Hello I am Parent");
    }
}

class Child extends Parent {
  static {
    System.out.println("Hello I am static Block of Child");
  }
  
  int data;

    {
      data = 200;
      System.out.println("Hello I am Block of Child " + super.data);
    }

    public Child() {
        System.out.println("Hello I am Child");
    }
}

public class StaticBlock {
    public static void main(String[] args) {
      System.out.println("Main");
      Child c = new Child();
      System.out.println(c.data);
    }
}
