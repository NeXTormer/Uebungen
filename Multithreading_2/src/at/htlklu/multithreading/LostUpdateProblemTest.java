package at.htlklu.multithreading;

public class LostUpdateProblemTest {

	public static void main(String[] args) {
		
		Runnable r = new LostUpdateProblem();
		
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();

	}

}
