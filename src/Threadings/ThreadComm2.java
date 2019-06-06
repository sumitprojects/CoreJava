package Threadings;

public class ThreadComm2 implements Runnable {
	final Customer2 c = new Customer2();
	
	public static void main (String[] args) {
		ThreadComm2 threadComm = new ThreadComm2();
		Thread t1 = new Thread(threadComm);
		Thread t2 = new Thread(threadComm);
		Thread t3 = new Thread(threadComm);
		Thread t4 = new Thread(threadComm);
		Thread t5 = new Thread(threadComm);
		
		t1.setPriority(1);
		t2.setPriority(1);
		t3.setPriority(1);
		t4.setPriority(10);
		t5.setPriority(10);
		
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		t5.start();
		
		try {
			Thread.sleep(3000);
			System.out.println(threadComm.c.amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run () {
		try {
			Thread.sleep(1000);
			synchronized (this) {
				if (Thread.currentThread().getPriority() == 10) {
					//Thread.sleep(Thread.currentThread().getPriority());
					this.c.deposit(1000);
				} else {
					Thread.sleep(Thread.currentThread().getPriority() * 500);
					this.c.withdraw(2000);
				}
			}
		} catch (Exception e) {
		
		}
	}
}

class Customer2 {
	int amount = 2000;
	int widraw = 0;
	
	synchronized void withdraw (int amount) {
		System.out.println("going to withdraw..." + this.amount);
		
		if (Thread.currentThread().isAlive()) {
			widraw += amount;
		}
		
		if (this.amount < amount) {
			System.out.println("Less balance; waiting for deposit...");
//			try {
//				//wait();
//				System.out.println("Please, deposit greater than " + this.widraw);
//				if (this.amount > amount) {
//					this.amount -= amount;
//					System.out.println("withdraw completed...");
//				} else {
//					throw new ArithmeticException("Insufficient Amount for pending transaction " + this.widraw);
//				}
//			} catch (Exception e) {
//				System.err.println(e.getMessage());
//			}
		} else {
			this.amount -= amount;
			System.out.println("withdraw completed...");
		}
	}
	
	synchronized void deposit (int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		this.widraw -= amount;
		System.out.println("deposit completed... " + this.amount);
		//notify();
	}
}