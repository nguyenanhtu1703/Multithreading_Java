package demo1_3;

class Runner implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class App {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("Hello " + i);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
			}
		});
		t1.start();
	}
}
