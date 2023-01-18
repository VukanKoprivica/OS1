package tri;

import java.util.ArrayList;
import java.util.List;

public class Igra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Spil spil = new Spil();
		Talon talon = new Talon();
		
		String[] imena = {"Vukan","Joka","Pera","zika","cvare","boskic","Dragn","Smit","Bjeka","Bogi"};
		List<Igrac> igraci = new ArrayList<Igrac>();
		for(int i = 0;i<10;i++) {
			Igrac igrac = new Igrac(spil, talon,imena[i]);
			igraci.add(igrac);
			igrac.start();
		}
	}

}
