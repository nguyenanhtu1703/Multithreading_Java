package demo3;

public class App {
	private volatile int count = 0;
	public static void main(String[] args) throws InterruptedException {
		App app = new App();
		app.doWork();
	}
	public synchronized void increment() {
		count++;
	}
	public void doWork() throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) 
					increment();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++)
					increment();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count is: " + count);
	}
}
