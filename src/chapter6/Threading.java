package chapter6;

/*
 * Life cycle of Thread
 * New
 * Runnable
 * Running
 * Non-Runnable (Blocked)
 * Terminated
 * */

import java.util.Scanner;

/*
 * For creating thread either you can use Thread class to Extends
 * or you can use Runnable for implements run method.
 * */
public class Threading extends Thread implements Runnable {
    public static void main(String[] args) {
        //Method 1 Thread 1
        Threading t1 = new Threading();
        //Method 2 Thread 2
        Threading t2 = new Threading();
        Thread t = new Thread(t2);
        //Thread 3
        Threading t3 = new Threading();

        int choice = 0;
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t\t\t Exceptions call");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Enter the choice Below:\n" +
                "1. Normal Thread Creation\n" +
                "2. Directly Running the Threads\n" +
                "3. Method 1 Joining\n" +
                "4. Method 2 Joining\n" +
                "5. Thread with the Name\n" +
                "6. Thread Priority\n" +
                "7. Deamon Thread and Thread Group\n");
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Method 1 & 2 (Multitasking)");
                System.out.println("------------------------------------------------------------------");
                t1.start();
                t.start();
                System.out.println("------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Method 1 & 2 (Sequential/without Multitasking)");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Method(Thread) 1 is running");
                t1.run();
                System.out.println("\t\t Method(Thread) 2 is running");
                t.run();
                System.out.println("------------------------------------------------------------------");
                break;
            case 3:
              System.out.println("------------------------Joining------------------------------------------");
              System.out.println("\t\t Method 1(Thread )");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Thread 1 (Join) is running");
                t1.start();
                try {
                    /*
                     * Hold the thread for completing current Thread execution
                     * */
                    t1.join();
                } catch (Exception e) {
                    System.out.println(e);
                }
              System.out.println("\t\t Thread 2-3 is running");
                t.start();
              t3.start();
                System.out.println("------------------------------------------------------------------");
                break;
            case 4:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Method 2(Thread Joining)");
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Thread 1 (Join) is running");
                t1.start();
                try {
                    /*
                     * Hold the thread for 200ms for continuous execution
                     * */
                    t1.join(200);
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("\t\t Thread 2 is running");
                t.start();
                System.out.println("------------------------------------------------------------------");
                break;
            case 5:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Naming the thread");
                System.out.println("------------------------------------------------------------------");
                /*
                 * Thread Name Given Below
                 * */
                t1.setName("FirstThread");
                t.setName("SecondThread");
                System.out.println("\t\t " + t1.getName() + " is running");
                t1.start();
                System.out.println("\t\t " + t.getName() + " is running");
                t.start();
                System.out.println("------------------------------------------------------------------");
                break;
            case 6:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Thread Priority");
                System.out.println("------------------------------------------------------------------");
                /*
                 * Thread Name Given Below
                 * */
                t1.setName("FirstThread");
                t.setName("SecondThread");
                t3.setName("ThirdThread");

                /*
                 * Priority of individual Thread is given Below
                 * */
                t1.setPriority(1);  //t1.setPriority(MIN_PRIORITY);
                t.setPriority(5);   //t.setPriority(NORM_PRIORITY);
              t3.setPriority(10); //t3.setPriority(7);
                System.out.println("\t\t " + t1.getName() + " is running");
                t1.start();
                System.out.println("\t\t " + t.getName() + " is running");
                t.start();
                System.out.println("\t\t " + t3.getName() + " is running");
                t3.start();
                System.out.println("------------------------------------------------------------------");
                break;
            case 7:
                System.out.println("------------------------------------------------------------------");
                System.out.println("\t\t Daemon Thread and Thread Group ");
                System.out.println("------------------------------------------------------------------");
                ThreadGroup threadGroup = new ThreadGroup("New Thread Group");
                /*
                 * Adding The Thread to the created Group
                 * */
              Thread one = new Thread(threadGroup, t1, "First");
                Thread two = new Thread(threadGroup, t, "Second");
              Thread three = new Thread(threadGroup, t3, "Third");
                /*
                 * Thread Name Given Below
                 * */
                one.setName("FirstThread");
                two.setName("SecondThread");
                three.setName("ThirdThread");
                one.setDaemon(true);
                threadGroup.list();
                System.out.println("\t\t " + one.getName() + " is running");
                one.start();
                System.out.println("\t\t " + two.getName() + " is running");
                two.start();
                System.out.println("\t\t " + three.getName() + " is running");
                three.start();
                System.out.println("------------------------------------------------------------------");
              try {
                two.interrupt();
              } catch (Exception e) {
                System.out.println(e);
              }
              if (two.isInterrupted()) {
                System.err.println("------------------------------------------------------------------");
                System.err.println("I am out of your group");
                System.err.println("------------------------------------------------------------------");
              }

                break;
            default:
                System.err.println("Wrong Choice");
                break;
        }
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
                 * For getting current thread information
                 * */
              if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread Name : " + Thread.currentThread().getName() + "\t |" +
                        "Thread Priority :" + Thread.currentThread().getPriority() + "\t |" +
                        "Thread Daemon :" + Thread.currentThread().isDaemon() + "\t |" +
                        "output : i = " + i);
              } else {
                System.out.println("Thread Name : " + Thread.currentThread().getName() + "\t |" +
                        "Thread Priority :" + Thread.currentThread().getPriority() + "\t |" +
                        "Thread Daemon :" + Thread.currentThread().isDaemon() + "\t |" +
                        "output : i = " + i);
              }
                System.out.println("------------------------------------------------------------------");
              /*
               * It will make the thread into sleep mode for 100ms
               * */
              Thread.sleep(100);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}