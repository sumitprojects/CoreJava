package chapter3.polymorphism;

/*
 *
 * Only allowed in Inheritance
 * signature must be same
 * only body can be chanageble
 * */


class Car {
  void run () {
    System.out.println("Car is running.");
  }
}

class Ferrari extends Car {
  void run () {
    System.out.println("Ferrari is running.");
  }
}

class Toyota extends Car {
  void run () {
    System.out.println("Toyota is running");
  }
}


public class MethodOverriding {
  public static void main (String[] args) {
    Ferrari f = new Ferrari();
    Toyota t = new Toyota();
    for (int i = 0; i < 50; i++) {
      System.out.print("-");
    }
    System.out.println();
    f.run();
    t.run();
    for (int i = 0; i < 50; i++) {
      System.out.print("-");
    }
  }
}
