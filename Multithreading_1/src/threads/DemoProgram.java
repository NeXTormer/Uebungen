package threads;

public class DemoProgram {
	
	public static void main(String[] args) {
		PingThread t = new PingThread("ping");
		t.start();
		
		Thread t2 = new PingThread("pong");
		t2.start();
		
		System.out.println("program ended.");
	}

}
