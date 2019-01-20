package at.htlklu.multithreading;

public class CounterRunnable implements Runnable {
	
	private String name;
	
	public CounterRunnable(String name) {
		this.name = name;
	}
	
	public void run() {
		
		for (int i = 1; i <= 20; i++) {
			System.out.println(name + " " + i);
			ThreadUtil.sleepRandom(500);
		}
	}

}
