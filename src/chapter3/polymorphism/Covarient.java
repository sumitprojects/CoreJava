package chapter3.polymorphism;

public class Covarient {
  int a = 0, b = 0;
  
  public static void main (String[] args) {
    Covarient obj = new Covarient();
    obj.mul(10, 20);
    System.out.println(obj.a);
    obj = obj.add(1000, 20);
    System.out.println(obj.a);
  }
  
  Covarient add (int a, int b) {
    Covarient obj = new Covarient();
    obj.a = a;
    obj.b = b;
    return obj;
  }
  
  Covarient mul (int a, int b) {
    this.a = a;
    this.b = b;
    return this;
  }
}
