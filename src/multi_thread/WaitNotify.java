package multi_thread;

public class WaitNotify {
	public static void main(String args[]) {
		CleanHair clean = new CleanHair(); // single object
		new HairThread("Lather", clean);
		new HairThread("Rinse", clean);
	}
}
