package Threadings;

public class DeamonThread implements Runnable {
	public static void main (String[] args) {
		Thread thread1 = new Thread(new DeamonThread(), "First");
		Thread thread2 = new Thread(new DeamonThread(), "Second");
		Thread thread3 = new Thread(new DeamonThread(), "Third");
		
		thread1.setDaemon(true);
		thread2.setDaemon(true);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	@Override
	public void run () {
		try {
			if (Thread.currentThread().isDaemon()) {
				Thread.sleep(100);
				System.out.println("Deamon " + Thread.currentThread().getName());
			} else {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}
