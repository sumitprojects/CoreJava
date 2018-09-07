public class ThreadGroupDemo implements Runnable {
    public static void main (String[] args) {
        ThreadGroupDemo runnable = new ThreadGroupDemo();
        
        ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");
        
        Thread t1 = new Thread(tg1, runnable, "one");
        t1.start();
        Thread t2 = new Thread(tg1, runnable, "two");
        t2.start();
        Thread t3 = new Thread(tg1, runnable, "three");
        t3.start();
        
        
        ThreadGroup tg2 = new ThreadGroup(tg1, "Child ThreadGroup");
        
        Thread t4 = new Thread(tg2, runnable, "four");
        t4.start();
        Thread t5 = new Thread(tg2, runnable, "five");
        t5.start();
        Thread t6 = new Thread(tg2, runnable, "six");
        t6.start();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread Group Name: " + tg1.getName());
        tg1.list();
        System.out.println("Thread Group Name: " + tg2.getName());
        tg2.list();
        
    }
    
    public void run () {
        System.out.println(Thread.currentThread().getName());
    }
}
