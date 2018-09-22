package chapter3.abstraction;

interface Main {
    void method1();

    void method2();

    void method3();

    void method4();
}

//abstraction level 1
abstract class Level1 implements Main {
  //concrete class and concrete method
  @Override
  public void method1 () {
    System.out.println("Hello I am implemented in " + getClass());
  }
}

//abstraction level 2
abstract class Level2 extends Level1 {
    @Override
    public void method2() {
        System.out.println("Hello I am implemented in " + getClass());
    }
}

abstract class Level3 extends Level2 {
    @Override
    public void method3() {
        System.out.println("Hello I am implemented in " + getClass());
    }
}

public class FinaleAbstraction extends Level3 {
    public static void main(String[] args) {
        Main m = new FinaleAbstraction();
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Final Abstraction example ");
        System.out.println("----------------------------------------------------------------");
        m.method1();
        m.method2();
        m.method3();
        m.method4();
    }

    @Override
    public void method4() {
        System.out.println("Hello I am implemented in " + this.getClass());
    }
}
