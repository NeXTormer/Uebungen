package threads;

public class PingThread extends Thread {
	
	String name;
	
	public PingThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name);
		}
		// Add comment just for a change
	}

}
