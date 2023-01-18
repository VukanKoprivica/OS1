package klkVetnic;

public class Porudzbina {

	public final String id;
	public final int cena;
	public final long udaljenost;

	public Porudzbina() {
		System.out.printf("%s sprema porudzbinu...%n", Thread.currentThread().getName());
		this.id = String.format("#%H", System.identityHashCode(this));
		this.cena = (int) (40 + 160 * Math.random()) * 10;
		this.udaljenost = (long) (200 + 2800 * Math.random());
		System.out.printf("%s je spremio porudzbinu %s%n", Thread.currentThread().getName(), this.id);
	}

	public int dostavi() {
		System.out.printf("%s dostavlja porudzbinu %s%n", Thread.currentThread().getName(), this.id);
		boolean interrupted = Thread.interrupted();
		long timeout = 5 * udaljenost;
		long endTime = System.currentTimeMillis() + timeout;
		while ((timeout = endTime - System.currentTimeMillis()) > 0) {
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				interrupted = true;
			}
		}
		if (interrupted) {
			Thread.currentThread().interrupt();
		}
		System.out.printf("%s je dostavio porudzbinu %s%n", Thread.currentThread().getName(), this.id);
		return cena + 5 * (int) (0.04 * cena * Math.random());
	}
}
