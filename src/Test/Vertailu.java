package Test;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import kivipaperisakset.Pelaaja;
import kivipaperisakset.Peli;

public class Vertailu {
	
	@Test
	public void vertailu() {
		Pelaaja p1 = new Pelaaja();
		Pelaaja p2 = new Pelaaja();
		
		Peli peli = new Peli(p1, p2, 3);
		
		p1.setValinta("kivi");
		p2.setValinta("sakset");
		//Pelaajan yksi pitäisi voittaa, sillä kivi > sakset
		assertTrue(peli.vertaa(p1, p2).equals(p1));
		
		p2.setValinta("paperi");
		//Pelaajan kaksi pitäisi voittaa, sillä kivi < paperi
		assertTrue(peli.vertaa(p1, p2).equals(p2));
		
		p1.setValinta("sakset");
		p2.setValinta("paperi");
		//Pelaajan yksi pitäisi voittaa, sillä sakset > paperi
		assertTrue(peli.vertaa(p1, p2).equals(p1));
	}
	
	@Test
	public void voittojenAsettaminen() {
		Pelaaja p1 = new Pelaaja();
		Pelaaja p2 = new Pelaaja();
		
		Peli peli = new Peli(p1,p2,3);
		peli.pelaa();
		
		//Jommalla kummalla pitäisi olla 3 voittoa.
		assertTrue(p1.getVoitot()==3 || p2.getVoitot()==3);
	}

}
