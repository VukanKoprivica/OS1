package klk1;

public class Ispis extends Thread {

	private Kvadrati kvadrat;

	public Ispis(Kvadrati kvadrat) {
	
		setDaemon(true);
		this.kvadrat = kvadrat;
	}

	public void run() {
		while(!interrupted()) {
			if(kvadrat.kraj) {
				System.out.println(":::" + kvadrat.kvadrat);
				kvadrat.kraj = false;
			}
		}
		
	}
	
	
	
}
