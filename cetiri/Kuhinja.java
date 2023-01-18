package cetiri;
/*Napisati program u Javi koji simulira rad vrlo popularnog
vegetarijanskog restorana "Vege Laza".

U danasnjoj ponudi restorana su tri obroka: vegetarijanski
sendvic (230 din), potaz od bundeve (340 din) i grilovani
tofu sa povrcem (520 din).

U restoranu u prodaji i pripremi porcija rade dve konoba-
rice: Rada i Dara. One svakih 10 sekundi obrade po jednu
porudzbinu.

Za vegetarijanski sendvic je od sastojaka potrebno: dva
parceta domaceg hleba, jedan komad grilovanog tofu sira i
100 grama povrca.

Za porciju potaza od bundeve je potrebno pola litre potaza
i jedno parce domaceg hleba.

Za grilovani tofu sa povrcem je potreban jedan komad grilo-
vanog tofu sira i 300g povrca.

U kuhinji, na pripremi povrca radi Miki koji za 90 sekundi
isecka kilu povrca. Takodje, Mica svaka 4 minuta skuva 10
litara potaza, a Joki isece 6 parcadi hleba svaki minut.
Na rostilju rade Vule i Gule koji svaki minut ispeku po ko-
mad tofu sira.

Napisati program koji kreira svakog od zaposlenih kao pose-
ban proces i pokrece ih. 5 minuta kasnije, prekida procese
koji uredno zavrsavaju svoj rad, posle cega program ispisuje
ukupnu sumu novca koju je restoran zaradio.*/

public class Kuhinja {
	private int gramaPovrca;
	private int mililitaraPotaza;
	private int parcadiHleba;
	private int komadaSira;
	private int dinaraPazara;

	private void stampajPoruku(String poruka) {
		System.out.printf("%4s %-30s Stanje u kuhinji: %5d %5d %2d %2d %5d%n", Thread.currentThread().getName(), poruka,
				gramaPovrca, mililitaraPotaza, parcadiHleba, komadaSira, dinaraPazara);
	}

	public Kuhinja() {
		stampajPoruku("je otvorio restoran");
	}

	public synchronized void dodajPovrce(int kolicina) {

		gramaPovrca = gramaPovrca + kolicina;
		notifyAll();
		stampajPoruku(" je isekao povrce");
	}

	public synchronized void dodajPotaz(int kolicina) {

		mililitaraPotaza = mililitaraPotaza + kolicina;
		notifyAll();
		stampajPoruku(" je kuvala potaz");
	}

	public synchronized void dodajHleb(int kolicina) {

		parcadiHleba = parcadiHleba + kolicina;
		notifyAll();
		stampajPoruku(" je isekao hleb");
	}

	public synchronized void dodajTofu(int kolicina) {

		komadaSira = komadaSira + kolicina;
		notifyAll();
		stampajPoruku(" je isekao tofu");
	}

	public synchronized void napraviSendvic() throws InterruptedException {
		while(gramaPovrca < 100 || komadaSira < 1 || parcadiHleba <2) {
			stampajPoruku(" ceka ");
			wait();
		} 
		
		parcadiHleba = parcadiHleba-2;
		gramaPovrca = gramaPovrca-100;
		komadaSira = komadaSira - 1;
		dinaraPazara = dinaraPazara +230;
		
		stampajPoruku(" je napravila sendvic.");
	}
	
	public synchronized void napraviPorcijuPotaza() throws InterruptedException {
		while(mililitaraPotaza <500 || parcadiHleba <1) {
			stampajPoruku("ceka sastojke ");
			wait();
		}
		mililitaraPotaza = mililitaraPotaza-500;
		parcadiHleba = parcadiHleba-1;
		dinaraPazara = dinaraPazara +340;
		stampajPoruku(" je posluzio porciju ");
	}
	public synchronized void napraviTofu() throws InterruptedException {
		while (komadaSira <1 || gramaPovrca <300) {
			stampajPoruku("cekaj sastojke ");
			wait();
		}
		komadaSira = komadaSira-1;
		gramaPovrca = gramaPovrca-300;
		dinaraPazara = dinaraPazara +520;
		stampajPoruku(" je posluzila tofu ");
	}
	public synchronized int uzmiPazar() {
		int pare = dinaraPazara;
		dinaraPazara = 0;
		stampajPoruku("je uzeo pare od pazara");
		return pare;
	}
	
	
}
