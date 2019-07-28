package demo6;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable {
	private CountDownLatch latch;
	public Processor(CountDownLatch t) {
		latch = t;
	}
	public void run() {
		System.out.println("Started. " + latch.getCount());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	} 
}

public class App {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		for(int i = 0; i < 10;i++) {
			executor.submit(new Processor(latch));
		}		
		
		latch.await();
		
		System.out.println("Completed." + latch.getCount());
	}
}
