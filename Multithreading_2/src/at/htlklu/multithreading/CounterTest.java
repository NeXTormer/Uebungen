package at.htlklu.multithreading;

public class CounterTest {

	public static void main(String[] args) {
		
		CounterThread t1 = new CounterThread("t1");
		CounterThread t2 = new CounterThread("t2");
		CounterThread t3 = new CounterThread("t3");

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
