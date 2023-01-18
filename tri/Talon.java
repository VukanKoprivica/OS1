package tri;

public class Talon {

	private int br;
	private Karta najjaca;
	
	public synchronized void staviKartu(Karta karta) {
		if(najjaca == null || karta.rang > najjaca.rang   ) {
			najjaca = karta;
		}
		br++;
		if(br==10)
			notifyAll();
	}
	
	
	public synchronized void cakajOstale() throws InterruptedException {
		while(br < 10) {
			wait();
		}
	}
	
	
	
	public synchronized boolean jeNajjaca(Karta karta) {
		return karta.rang == najjaca.rang;
	}
}
