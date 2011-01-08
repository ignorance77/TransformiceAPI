package ee.ignorance.transformiceapi;

public abstract class Blocker {

	public Blocker(long interval) {
		while (true) {
			if (check()) {
				break;
			}
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public abstract boolean check();
	
}
