package chapter3.abstraction;

/*
 * Interfaces are fully abstracted class.
 * So, Interface must not have body any methods.
 * All method must be implemented in all child.
 * */
interface PureAbstract {
    void method1();

    long method2(long a, long b);
}

public class InterfaceClass implements PureAbstract {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t Interface Class Example");
        System.out.println("----------------------------------------------------------------");

        PureAbstract p = new InterfaceClass();
        p.method1();
        System.out.println(p.method2(10, 10));
    }

    @Override
    public void method1() {
        System.out.println("I am successfully implemented in Child class");
    }

    @Override
    public long method2(long a, long b) {
        return a * b;
    }
}
