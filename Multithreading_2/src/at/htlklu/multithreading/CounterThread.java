package at.htlklu.multithreading;

public class CounterThread extends Thread {
	
	public CounterThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		super.run();
		
		for (int i = 1; i <= 20; i++) {
			System.out.println(getName() + " " + i);
			ThreadUtil.sleepRandom(500);
		}
	}

}
