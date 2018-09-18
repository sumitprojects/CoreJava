package chapter3.polymorphism;

/*
 * variable
 * method
 * class
 *
 * */

/*final class could be inherited in to any other class*/
final class Demo {
  void disp () {
    System.out.println("I am final and I can't be overrided / overloaded by another class.");
  }
}


class Another {
  
  /*
   * Final method without parameter
   * */
  final void disp () {
    System.out.println("I am unmodifiable.");
  }
  
  /*
   * Final Method with parameter
   * */
  final long power (long n, int pow) {
    if (pow == 1) {
      return n;
    } else {
      return n * power(n, --pow);
    }
  }
  
}

public class FinalKeyword extends Another {
  final static int data;
  
  static {
    data = 100;
  }
  
  final int instanceData;
  
  {
    instanceData = 200;
  }
  
  //final void disp(){}
  public static void main (String[] args) {
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
    System.out.println(f.power(10, 5));
    
    //data =1000;   // compile time error
    
  }
}
