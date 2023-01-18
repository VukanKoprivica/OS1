package klkVetnic;

import java.util.ArrayList;
import java.util.List;

public class Picerija {
	
	List<Porudzbina> spremna;
	
	
	

	public Picerija() {
		
		this.spremna = new ArrayList<Porudzbina>();
	}

	public synchronized Porudzbina preuzmi() throws InterruptedException {
		while(spremna.size() == 0)wait();
		return spremna.remove(0);
		
	}

	public synchronized void spremno(Porudzbina porudzbina) {

		spremna.add(porudzbina);
		notifyAll();
	}
}
