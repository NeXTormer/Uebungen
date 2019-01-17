package at.htlklu.multithreading;

public class StoppableCounterTest {

	public static void main(String[] args) {
		
		StoppableCounterThread t = new StoppableCounterThread();
		t.start();
		
		ThreadUtil.sleep(5000);
		
		t.interrupt();

	}

}
