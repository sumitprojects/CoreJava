package chapter6;

class MyThread extends Thread {
    @Override
    public void run () {
        System.out.println("shut down hook task completed..");
    }
}


public class ShutdownHook {
    public static void main (String[] args) {
        MyThread mt = new MyThread();
        Runtime run = Runtime.getRuntime();
        ThreadGroup tg = new ThreadGroup("Mythread");
        Thread t1 = new Thread(tg, mt, "one");
        Thread t2 = new Thread(tg, mt, "two");
        Thread t3 = new Thread(tg, mt, "three");
        run.addShutdownHook(t1);
        run.addShutdownHook(t2);
        run.addShutdownHook(t3);
        System.out.println("Now main sleeping... press ctrl+c to exit");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
