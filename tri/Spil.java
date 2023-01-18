package tri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;







public class Spil {

	private static final String[] BOJE = "\u2660,\u2665,\u2666,\u2663".split(",");
	private static final int[] RANGOVI = {2,3,4,5,6,7,8,9,10,11,12,13,14};
	private static final String[] DZOKERI = "\u2605,\u2606".split(",");
	private static final Random random = new Random();

	public Karta uzmi() {
		int id = random.nextInt(54);
		if (id == 53) {
			return new Karta(15,DZOKERI[0]);
		}
		if (id == 52) {
			return new Karta(15,DZOKERI[1]);
		}
		String boja = BOJE[id / 13];
		int rang = RANGOVI[id % 13];
		return new Karta(rang , boja);
	}
}
