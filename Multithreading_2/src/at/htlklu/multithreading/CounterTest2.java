package at.htlklu.multithreading;

public class CounterTest2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new CounterRunnable("t1"));
		Thread t2 = new Thread(new CounterRunnable("t2"));
		Thread t3 = new Thread(new CounterRunnable("t3"));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("End of main");
	}

}
