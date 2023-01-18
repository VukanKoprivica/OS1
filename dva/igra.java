package dva;

import java.util.ArrayList;
import java.util.List;

public class igra {
	public static void main(String args[]) {
		List<Igrac> igraci = new ArrayList<Igrac>();
		
		Igrac igrac = new Igrac("Joka");
		igraci.add(igrac);
		igrac.start();
		
		Igrac igrac1 = new Igrac("Vukan");
		igraci.add(igrac1);
		igrac1.start();
		
		Diler diler = new Diler(igraci);
		diler.start();
		
	}

}
