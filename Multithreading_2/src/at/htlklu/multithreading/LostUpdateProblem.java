package at.htlklu.multithreading;

public class LostUpdateProblem implements Runnable {
	
	private int value = 0;
	
	@Override
	public void run() {
		
		for (int i = 0; i < 200; i++) {
			increment();
		}
		
	}
	
	private synchronized void increment() {
		int i = value;
		value = i + 1;
		System.out.println("Value = " + value);
	}

}
