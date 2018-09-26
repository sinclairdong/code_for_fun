package multi_thread;

public class CleanHair {
	String currentState = ""; // object state

	synchronized void Lather() {
		currentState = "Lather";
		System.out.println(currentState);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	synchronized void Rinse() {
		currentState = "Rinse";
		System.out.println(currentState);
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
