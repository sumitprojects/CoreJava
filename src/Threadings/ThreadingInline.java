package Threadings;

public class ThreadingInline {
	public static void main (String[] args) {
		Thread thread = new Thread(() -> {
			try {
				String[] arg = new String[3];
				arg[0] = "10";
				arg[1] = "5";
				arg[2] = "1";
				System.out.println("Thread 1 is running");
				Thread.sleep(500);
				ThreadingDemo2.main(arg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "First");
		Thread thread2 = new Thread("Second") {
			public void run () {
				try {
					String[] arg = new String[3];
					arg[0] = "5";
					arg[1] = "10";
					arg[2] = "1";
					System.out.println("Thread 2 is running");
					Thread.sleep(500);
					ThreadingDemo2.main(arg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		thread.start();
		thread2.start();
	}
}
