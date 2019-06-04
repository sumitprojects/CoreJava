public class ThreadingConcepts extends Thread {
	public static void main (String[] args) {
		ThreadingConcepts th = new ThreadingConcepts();
		ThreadingConcepts th2 = new ThreadingConcepts();
		ThreadingConcepts th3 = new ThreadingConcepts();
		th.setName("process 1");
		th2.setName("process 2");
		th3.setName("process 3");
		th.start();
		th2.start();
		th3.start();
		System.out.println("hello");
	}
	
	@Override
	public void run () {
		try {
			for (int i = 1; i <= 5; i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " -" + i);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
