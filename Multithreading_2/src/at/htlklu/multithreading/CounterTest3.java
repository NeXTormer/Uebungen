package at.htlklu.multithreading;

public class CounterTest3 {

	public static void main(String[] args) {
		
		CounterRunnable r1 = new CounterRunnable("t1");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);

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
