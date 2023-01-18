package da;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Spil {
	private final List<Karta> spil = new ArrayList<>(54);
	private final int random = (int) ((Math.random() * (54 - 0)) +0);
	
	public Spil() {
		
		for(BojaKarte boja : BojaKarte.values()) {
			for(RangKarte rang : RangKarte.values()) {
				spil.add(new Karta(boja,rang));
			}
		}
		spil.add(new Karta(true));
		spil.add(new Karta(false));
		
	}
	
	int velicina()    {return spil.size();}        
	Karta uzmiOdGore()   {return spil.remove(spil.size()-1);} 
	
    Karta uzmiOdDole() {return spil.remove(0);}       
	Karta uzmiIzSredine() {return spil.remove(random);}    
	void staviDole(Karta karta) {spil.add(karta) ;}  
	void staviUSredinu(Karta karta) {spil.add(random, karta);}
	void promesaj()  {
		Collections.shuffle(spil);
	} 
	
}
