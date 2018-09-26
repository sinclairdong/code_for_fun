package multi_thread;

public class HairThread extends Thread {
	String name;
	CleanHair cleanRef;

	HairThread(String name, CleanHair cleanRef) {
		this.name = name;
		this.cleanRef = cleanRef;
		setName(name);
		start();
	}

	@Override
	public void run() {
		if (name.equals("Lather")) {
			cleanRef.Lather();
		}
		if (name.equals("Rinse")) {
			cleanRef.Rinse();
		}
	}
}
