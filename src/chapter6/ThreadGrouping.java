package chapter6;

public class ThreadGrouping implements Runnable {
	int[] sum = new int[6];
	
	public static void main (String[] args) {
		ThreadGrouping th = new ThreadGrouping();
		
		ThreadGroup threadGroup = new ThreadGroup("Main Group");
		Thread t1 = new Thread(threadGroup, th, "Process 1");
		Thread t2 = new Thread(threadGroup, th, "Process 2");
		Thread t3 = new Thread(threadGroup, th, "Process 3");
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		ThreadGroup threadGroup2 = new ThreadGroup(threadGroup, "Child Group");
		Thread t4 = new Thread(threadGroup2, th, "Process 4");
		Thread t5 = new Thread(threadGroup2, th, "Process 5");
		Thread t6 = new Thread(threadGroup2, th, "Process 6");
		
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.NORM_PRIORITY);
		t6.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		
		try {
			Thread.sleep(10000);
			for (int s : th.sum) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run () {
		
		try {
			if (Thread.currentThread().getThreadGroup().getName().contains("Main")) {
				Thread.sleep(1000);
				if (Thread.currentThread().getPriority() == Thread.MAX_PRIORITY) {
					for (int i = 11; i <= 20; i++) {
						Thread.sleep(Thread.MAX_PRIORITY * 50);
						this.sum[0] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[0]);
					}
				}
				if (Thread.currentThread().getPriority() == Thread.NORM_PRIORITY) {
					for (int i = 1; i <= 10; i++) {
						Thread.sleep(Thread.NORM_PRIORITY * 150);
						this.sum[1] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[1]);
					}
				}
				if (Thread.currentThread().getPriority() == Thread.MIN_PRIORITY) {
					for (int i = 21; i <= 30; i++) {
						Thread.sleep(Thread.MIN_PRIORITY * 550);
						this.sum[2] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[2]);
					}
				}
				
			} else {
				Thread.sleep(1000);
				if (Thread.currentThread().getPriority() == Thread.MAX_PRIORITY) {
					for (int i = 31; i <= 40; i++) {
						Thread.sleep(Thread.MAX_PRIORITY * 50);
						this.sum[3] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[3]);
					}
				}
				if (Thread.currentThread().getPriority() == Thread.NORM_PRIORITY) {
					for (int i = 41; i <= 50; i++) {
						Thread.sleep(Thread.NORM_PRIORITY * 150);
						this.sum[4] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[4]);
					}
				}
				if (Thread.currentThread().getPriority() == Thread.MIN_PRIORITY) {
					for (int i = 51; i <= 60; i++) {
						Thread.sleep(Thread.MIN_PRIORITY * 550);
						this.sum[5] += i;
						System.out.println(Thread.currentThread().getName() + " -" + this.sum[5]);
					}
				}
			}
			System.out.println();
		} catch (Exception e) {
		}
	}
}
