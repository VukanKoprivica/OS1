package dva;

public class Igrac extends Thread {
	private volatile Karta karta;

	public Igrac(String ime) {setName(ime);}
	
	public void run() {
		while (karta == null) {
			
		}
		System.out.printf("%-5s je dobio: %3s%n", getName(), karta);
	}
	
	public void primiKartu(Karta karta) { this.karta = karta;}
}
