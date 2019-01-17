package at.htlklu.multithreading;

public class ThreadUtil {
	
	public static void sleepRandom(int ms) {
		
		try {
			Thread.sleep( (int) (Math.random() * ms) );
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}
	
	public static void sleep(int ms) {
		
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
	}

}
