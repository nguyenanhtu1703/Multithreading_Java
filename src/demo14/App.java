package demo14;

import java.util.Random;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread();
		
		System.out.println("Starting.");
		
		Thread t11 = new Thread(new Runnable() {
			public void run() {
				Random ran = new Random();
				for(int i = 0; i < 1000; i++) {
					if (Thread.currentThread().isInterrupted())
					{
						System.out.println("Interrupted!");
						break;
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Interrupted!");
			//			break;
					}
					Math.sin(ran.nextDouble());
				}
			}
		});
		
		t11.start();
		
		//Thread.sleep(500);
		
		t11.interrupt();
		
		t11.join();
		
		System.out.println("Finished.");
	}
}
