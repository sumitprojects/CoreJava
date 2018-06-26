package chapter6;

/*
 * Life cycle of Thread
 * New
 * Runnable
 * Running
 * Non-Runnable (Blocked)
 * Terminated
 * */

/*
 * For creating thread either you can use Thread class to Extends
 * or you can use Runnable for implements run method.
 * */
public class Threading extends Thread implements Runnable {
    public static void main(String[] args) {
        Threading t1 = new Threading();
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\t Method 1");
        System.out.println("------------------------------------------------------------------");
        t1.start();
        System.out.println("------------------------------------------------------------------");
        System.out.println("\t\t Method 2");
        System.out.println("------------------------------------------------------------------");
        Thread t = new Thread(t1);
        t.start();
        System.out.println("------------------------------------------------------------------");


    }

    /*
     * Run method is compulsory for Creating and Running the thread.
     * It is abstract method in Runnable. So, it must be override.
     * */
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                /*
                 * It will make the thread into sleep mode for 100ms
                 * */
                Thread.sleep(100);
                System.out.println("i = " + i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
