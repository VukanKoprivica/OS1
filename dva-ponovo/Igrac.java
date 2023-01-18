package da;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Igrac implements Comparable<Igrac> {

	private final String ime;
	private final List<Karta> karte;
	private boolean aktivan;
	
	
	public Igrac(String ime) {
	
		if(ime == null) {
			throw new IllegalArgumentException("ime");
		}
		this.ime = ime;
		this.karte = new ArrayList<>();
		aktivan = true;
		
		
	}
	
	

	public void dodajKartu(Karta karta) {
		karte.add(karta);
	}
	@Override
	public int compareTo(Igrac o) {
		int rezultat = this.karte.size() - o.karte.size();
		for (int i = 0;i<karte.size() && rezultat ==0;i++) {
			rezultat = Objects.compare(this.karte.get(i), o.karte.get(i), Komparator_karata);
		}
		return rezultat;
	}

	public boolean isAktivan() {
		return aktivan;
	}


	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}


	public String getIme() {
		return ime;
	}
	@Override
	public int hashCode() {return ime.hashCode();}

	

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Igrac  that = (Igrac) obj;
		
		return Objects.equals(this.ime,that.ime);
	}

	@Override
	public String toString() {
		String opis =karte.stream()
				.map(Karta::toString)
				.collect(Collectors.joining());
		return String.format("%s %s %s", ime,aktivan ? ":)" : " " , opis);
	}
	
	private static Comparator<RangKarte> Komparator_rang = Comparator.nullsLast(Comparator.naturalOrder());
	private static Comparator<Karta> Komparator_karata = Comparator.comparing(Karta::getRang,Komparator_rang);

	
}
