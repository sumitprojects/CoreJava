package chapter6;

public class ThreadingDemo implements Runnable {
//	public static void main (String[] args) {
//		ThreadingDemo threadingDemo=new ThreadingDemo();
//		ThreadingDemo threadingDemo1=new ThreadingDemo();
//		ThreadingDemo threadingDemo2=new ThreadingDemo();
//		threadingDemo.start();
//		threadingDemo.setName("First");
//		threadingDemo1.start();
//		threadingDemo1.setName("Second");
//		threadingDemo2.start();
//		threadingDemo2.setName("Third");
//	}
	
	public static void main (String[] args) {
		ThreadingDemo threadingDemo = new ThreadingDemo();
		ThreadingDemo threadingDemo1 = new ThreadingDemo();
		ThreadingDemo threadingDemo2 = new ThreadingDemo();
		
		Thread thread = new Thread(threadingDemo, "First");
		Thread thread1 = new Thread(threadingDemo, "Second");
		Thread thread2 = new Thread(threadingDemo, "Three");
		
		thread.start();
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(2000);
			System.out.println("*********************Thread 2 Starting*******************");
		} catch (Exception e) {
		
		}
		
		thread = new Thread(threadingDemo1, "First");
		thread1 = new Thread(threadingDemo1, "Second");
		thread2 = new Thread(threadingDemo1, "Three");
		
		thread.start();
		thread1.start();
		thread2.start();
		
	}
	
	@Override
	public void run () {
		try {
			int sum = 0;
			for (int i = 1; i <= 5; i++) {
				if (Thread.currentThread().getName().equals("First")) {
					sum += i;
					System.out.println(Thread.currentThread().getName() + " " + sum);
				} else if (Thread.currentThread().getName().equals("Second")) {
					sum += 10;
					System.out.println(Thread.currentThread().getName() + " " + sum);
				} else {
					sum += 20;
					System.out.println(Thread.currentThread().getName() + " " + sum);
				}
				Thread.sleep(100);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
