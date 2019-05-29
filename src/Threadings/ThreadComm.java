package Threadings;

public class ThreadComm {
	public static void main (String[] args) {
		final Customer c = new Customer();
		new Thread(() -> c.withdraw(10000)).start();
		new Thread(() -> c.withdraw(10000)).start();
		new Thread(() -> c.withdraw(10000)).start();
		new Thread(() -> c.withdraw(10000)).start();
		new Thread(() -> c.deposit(30000)).start();
		
		try {
			Thread.sleep(3000);
			System.out.println(c.amount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Customer {
	int amount = 2000;
	int widraw = 0;
	
	synchronized void withdraw (int amount) {
		System.out.println("going to withdraw...");
		
		if (Thread.currentThread().isAlive()) {
			widraw += amount;
		}
		
		if (this.amount <= amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				System.out.println("Please, deposit greater than " + this.widraw);
				wait(1000);
				if (this.amount > amount) {
					this.amount -= amount;
					System.out.println("withdraw completed...");
				} else {
					throw new ArithmeticException("Insufficient Amount for pending transaction " + this.widraw);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			this.amount -= amount;
			System.out.println("withdraw completed...");
		}
	}
	
	synchronized void deposit (int amount) {
		System.out.println("going to deposit...");
		this.amount += amount;
		this.widraw -= amount;
		System.out.println("deposit completed... ");
		notifyAll();
	}
}
