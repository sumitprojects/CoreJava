public class ThreadingConcepts implements Runnable {
	int sum;
	public static void main (String[] args) {
		Thread th = new Thread(new ThreadingConcepts(), "process 1");
		Thread th2 = new Thread(new ThreadingConcepts(), "process 2");
		Thread th3 = new Thread(new ThreadingConcepts(), "process 3");
		th3.start();
		try {
			th3.join(500);
		} catch (Exception e) {
		
		}
		th.start();
		th2.start();
		
		th.setPriority(1);
		th2.setPriority(5);
		th3.setPriority(10);
		
		
		try {
			Thread.sleep(10000);
			System.out.println("hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run () {
		try {
			Thread.sleep(1000);
			if (Thread.currentThread().getPriority() == Thread.MAX_PRIORITY) {
				for (int i = 11; i <= 20; i++) {
					Thread.sleep(Thread.MAX_PRIORITY * 50);
					this.sum += i;
					System.out.println(Thread.currentThread().getName() + " -" + this.sum);
				}
			}
			if (Thread.currentThread().getPriority() == Thread.NORM_PRIORITY) {
				for (int i = 1; i <= 10; i++) {
					Thread.sleep(Thread.NORM_PRIORITY * 150);
					this.sum += i;
					System.out.println(Thread.currentThread().getName() + " -" + this.sum);
				}
			}
			if (Thread.currentThread().getPriority() == Thread.MIN_PRIORITY) {
				for (int i = 21; i <= 30; i++) {
					Thread.sleep(Thread.MIN_PRIORITY * 550);
					this.sum += i;
					System.out.println(Thread.currentThread().getName() + " -" + this.sum);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
