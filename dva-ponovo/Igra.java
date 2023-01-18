package da;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Igra {
	public static void main(String[]args) {
		List<Igrac> igraci = Stream.of("Vukan","Joka")
				.map(Igrac::new)
				.collect(Collectors.toList());
		
		Spil spil = new Spil();
		spil.promesaj();
		
		boolean pobeda;
		do {
			igraci.stream()
			.filter(Igrac::isAktivan)
			.forEach(igrac -> igrac.dodajKartu(spil.uzmiOdGore()));

			Igrac pobednik = igraci.stream()
					.filter(Igrac::isAktivan)
					.max(Comparator.naturalOrder())
					.get();
			System.out.println(pobednik);
			pobeda = true;
		}while(!pobeda);
		igraci.stream().forEach(System.out::println);
		
	}

}
