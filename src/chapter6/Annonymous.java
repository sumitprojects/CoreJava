package chapter6;

public class Annonymous {
    public static void main (String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Hello thread");
            System.out.println("Hello two");
        });
        Thread t2 = new Thread(() -> System.out.println("Hello thread2"));
        Thread t3 = new Thread(() -> System.out.println("Hello thread3"));
        t1.start();
        t2.start();
        t3.start();
        
        
        Runnable run1 = () -> System.out.println("I am runnable");
        Runnable run2 = () -> System.out.println("I am runnable2");
        Runnable run3 = () -> System.out.println("I am runnable3");
        Thread t4 = new Thread(run1);
        Thread t5 = new Thread(run2);
        Thread t6 = new Thread(run3);
        t4.start();
        t5.start();
        t6.start();
    }
}
