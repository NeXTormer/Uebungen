package at.htlklu.multithreading;

public class StoppableCounterThread extends Thread {
	
	@Override
	public void run() {
		super.run();
		
		int i = 1;
		while (!isInterrupted()) {
			System.out.println(i);
			i++;
			ThreadUtil.sleepRandom(500);
		}
	}

}
