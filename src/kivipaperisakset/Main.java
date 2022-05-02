package kivipaperisakset;

/**
 * Luokka pelin luomista ja käynnistämistä varten.
 * 
 * @author Eljas Hirvelä
 *
 */
public class Main {

	public static void main(String[] args) {
		Pelaaja p1 = new Pelaaja();
		Pelaaja p2 = new Pelaaja();
		Peli peli = new Peli(p1, p2, 30);
		peli.pelaa();

	}

}
