package Threadings;

import java.util.Arrays;

public class ThreadingDemo2 implements Runnable {
	int sum;
	
	public static void main (String[] args) {
		ThreadingDemo2 threadingDemo2 = new ThreadingDemo2();
		
		Thread thread = new Thread(threadingDemo2, "First");
		Thread thread2 = new Thread(threadingDemo2, "Second");
		Thread thread3 = new Thread(threadingDemo2, "Third");
		try {
			if (args.length > 0) {
				System.out.println("Priority Updated" + Arrays.toString(args));
				thread.setPriority(Integer.valueOf(args[0]));
				thread2.setPriority(Integer.valueOf(args[1]));
				thread3.setPriority(Integer.valueOf(args[2]));
			} else {
				thread.setPriority(10);
				thread2.setPriority(5);
				thread3.setPriority(1);
			}
		} catch (Exception e) {
		
		}
		
		thread.start();

//		try{
//			thread.join();
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
		thread2.start();
//		try{
//			thread2.join(1000);
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
		//thread3.start();
		try {
			Thread.sleep(5000);
			System.out.println(threadingDemo2.sum);
		} catch (Exception e) {
		
		}
		
	}
	
	@Override
	public void run () {
		try {
			Thread.sleep(500);
			for (int i = 1; i <= 5; i++) {
//				Thread.sleep(500);
//				System.out.println(Thread.currentThread().getName() + " " +Thread.currentThread().getPriority() + " BASIC " + i);
				
				if (Thread.currentThread().getPriority() > 7) {
					Thread.sleep(500);
					this.sum += (i * 2);
					System.out.println(this.sum + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + " MAX " + i);
				} else if (Thread.currentThread().getPriority() <= 5 && Thread.currentThread().getPriority() >= 3) {
					Thread.sleep(500);
					this.sum -= i;
					System.out.println(this.sum + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + " NORM " + i);
				}
//				else{
//					Thread.sleep(500);
//					System.out.println(Thread.currentThread().getName() + " " +Thread.currentThread().getPriority() + " BASIC " + i);
//				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
