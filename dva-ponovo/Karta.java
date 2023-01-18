package da;

import java.util.Objects;


/* Implementirati klasu 'Karta' sa osobinama 'boja' i 'rang' koje predstavljaju
 * standardne osobine karata klasicnog spila od 52+2 karte.
 * 
 * Potrebno je predstaviti sledece boje: pik, karo, herc i tref, dok su dozvo-
 * ljene vrednosti za rang poredjane po velicini: brojevi od 2 do 10, zandar,
 * kraljica, kralj i kec. Takodje je potrebno predstaviti i dva dzokera, jedan
 * u boji, jedan ne.
 * 
 * Implementirati klasu 'Spil' ciji konstruktor kreira nov spil koji sadrzi sve
 * 54 razlicite karte. Takodje, implementirati sledece operacije:
 * 
 *   int velicina()            - vraca broj karata trenutno u spilu
 *   Karta uzmiOdGore()        - ukljanja gornju kartu i vraca je kao rezultat
 *   Karta uzmiOdDole()        - ukljanja donju kartu i vraca je kao rezultat
 *   Karta uzmiIzSredine()     - ukljanja nasumicno izabranu kartu i vraca je
 *   void staviGore(Karta)     - dodaje kartu na vrh spila
 *   void staviDole(Karta)     - dodaje kartu na dno spila
 *   void staviUSredinu(Karta) - dodaje kartu na nasumicno izabrao mesto u spilu
 *   void promesaj()           - nasumicno rasporedjuje karte trenutno u spilu
 * 
 * Napisati program koji implementira sledecu igru za 12 igraca. Igraci redom
 * vuku po jednu kartu sa vrha spila i okrecu je. Program ispisuje koji igrac
 * je izvukao koju kartu. Pobednik je onaj igrac (ili igraci) cija je karta
 * najjaca, pri cemu se ne gleda boja karte a dzokeri su jaci od svih ostalih
 * karata. Ako je bilo vise pobednika igra se ponavlja samo sa pobednicima dok
 * ne ostane samo jedan. Program ispisuje ime konacnog pobednika.
 * 
 * Unapred smisliti imena za igrace, kreirati jedan spil i promesati ga pre
 * igre. Pretpostaviti da u toku igre nece nestati karata u spilu.
 */

public class Karta {
	private final BojaKarte boja;
	private final RangKarte rang;
	
	public Karta(BojaKarte boja,RangKarte rang) {
		if(boja == null) {
			throw new IllegalArgumentException("boja");
			
		}
		if (rang == null) {
			throw new IllegalArgumentException("rang");
		}
		
		this.boja = boja;
		this.rang = rang;
	}
	
	public Karta(boolean uBoji) {
		if (uBoji)
			this.boja = BojaKarte.HERC;
		else 
			this.boja = null;
		this.rang = null;
	}

	public BojaKarte getBoja() {
		return boja;
	}

	public RangKarte getRang() {
		return rang;
	}
	public int hashCode() {
		if (rang == null) {
			return 0;
		}
		int rezultat = boja.ordinal() + 1;
		rezultat = rezultat * 17 + rang.ordinal() + 1;
		return rezultat;
	}
	
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		Karta that = (Karta) object;
		if (!Objects.equals(this.rang, that.rang)) {
			return false;
		}
		if (rang == null) {
			return (this.boja == null) == (that.boja == null);
		}
		if (!Objects.equals(this.boja, that.boja)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (rang == null && boja != null) {
			return " Dzoker u boji";
		}
		if (rang == null && boja == null) {
			return " Dzoker bez boje";
		}
		return "\uD83C" + (char) (boja.getVrednost() + rang.getVrednost());
	}
	
	
	
	
	

}
enum BojaKarte{
	PIK(0xDCA0),KARO(0xDCC0),HERC(0xDCB0),TREF(0xDCD0);
	private final int vrednost;
	private BojaKarte(int vrednost) {this.vrednost = vrednost;}
	public int getVrednost() {return vrednost;}
}
enum RangKarte{
	DVA(2),TRI(3),CETIRI(4),PET(5),SEST(6),SEDAM(7),OSAM(8),DEVET(9),DESET(10),ZANDAR(11),KRALJICA(12),KRALJ(13),KEC(1);
	private final int vrednost;
	private RangKarte(int vrednost) {this.vrednost = vrednost;}
	public int getVrednost() {return vrednost;}
}