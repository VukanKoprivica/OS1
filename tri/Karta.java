package tri;

import java.util.Objects;



public class Karta {
	private String boja;
	public int rang;

	

	public Karta(int rang, String boja) {
	
		this.boja = boja;
		this.rang = rang;
	}



	@Override
	public String toString() {
		return rang + boja;
	}

}

