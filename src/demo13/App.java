package demo13;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		Future<?> future = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if (duration > 2000)
					throw new IOException("Sleep too late");
				System.out.println("Starting ...");
				
				Thread.sleep(duration);
				
				System.out.println("Finished.");
				
				return null;
			}
		});
		executor.shutdown();
		try {
			System.out.println("Result is: " + future.get());
		}	catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			
			System.out.println(e.getMessage());
		}
	}
}
