package kivipaperisakset;

/**
 * Luokka sisältää pelin logiikan kokonaisuudessaan, mutta se käynnistetään ulkopuolelta.
 *
 * @author Ira Dook
 * @author Eljas Hirvelä
 */
public class Peli {
	private int voittojenLKM; //Kuinka monta voittoa tarvitaan koko pelin voittamiseen
	private Pelaaja p1; //Pelaaja 1
	private Pelaaja p2; //Pelaaja 2
	
	/**
	 * 
	 * @param p1 viittaus pelaajan 1
	 * @param p2 viittaus pelaajan 2
	 * @param voittojenLKM tarvittavien voittojen määrä
	 */
	public Peli(Pelaaja p1, Pelaaja p2, int voittojenLKM) {
		this.p1 = p1;
		this.p2 = p2;
		this.voittojenLKM = voittojenLKM;
	}
	
	/**
	 * Pelataan niin monta kierrosta peliä, kuin konstruktorissa on asetettu tarvittavien voittojen lukumääräksi.
	 */
	public void pelaa() {
		boolean peliLoppui = false;
        int pelatutPelit = 0; // Pelattujen pelien lkm
        int tasapelit = 0; // Tasapelien lkm
       
        do {
        	//Tulostetaan pelattujen erien määrä, sekä tasapelit.
            System.out.println("=========== Erä: "
                    + pelatutPelit + " ==========\n");
            System.out.println("Tasapelien lukumäärä: "
                    + tasapelit + "\n");
            
            //Luodaan pelaajalle 1 valinta ja tulostetaan.
            p1.pelaajanValinta();
            System.out.println("Pelaaja 1: " + p1.getValinta()
                    + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.\n");
            
            //Luodaan pelaajalle 2 valinta ja tulostetaan.
            p2.pelaajanValinta();
            System.out.println("Pelaaja 2: " + p2.getValinta()
                    + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.\n");
            
            //Katsotaan tuliko tasapeli vai joudutaanko valintoja vertailemaan tarkemmin
            if(p1.getValinta().equals(p2.getValinta())) {
            	tasapelit++;
                System.out.println("\n\t\t\t Tasapeli \n");
            } else {
            	//Kasvatetaan voittajan voiton määrää hakemalla voittaja 'vertaa' metodilla.
            	vertaa(p1,p2).setVoitot();
            }
            
            
            pelatutPelit++;
            if ((p1.getVoitot() >= voittojenLKM) || (p2.getVoitot() >= voittojenLKM)) {
                peliLoppui = true;
                System.out.println("\n\n\t\tKOLME VOITTOA - PELI PÄÄTTYY");
            }
            System.out.println();
        } while (peliLoppui != true);
	}
    
    /**
     * Metodi vertaa pelaajien valintoja
     * 
     * @param p1 pelaajan 1 viittaus
     * @param p2 pelaajan 2 viittaus
     * 
     * @return palauttaaja voittajan olion
     */
    public Pelaaja vertaa(Pelaaja p1, Pelaaja p2) {
    	
    	//Kirjataan arvot muuttujiin, niin minimoidaan kirjoitusvirheiden määrä
    	final String kivi = "kivi";
    	final String sakset = "sakset";
    	final String paperi = "paperi";
    	String p1Voittaa = "\n\t\t\t Pelaaja 1 voittaa";
    	
    	//Verrataan pelaajan yksi valintaa pelaajan kaksi valintaan
    	switch(p1.getValinta()) {
	    	case kivi:
	    		if(p2.getValinta().equals(sakset)) {
	    			System.out.println(p1Voittaa);
	    			return p1;
	    		}
	    		break;
	    	case sakset:
	    		if(p2.getValinta().equals(paperi)) {
	    			System.out.println(p1Voittaa);
	    			return p1;
	    		}
	    		break;
	    	case paperi:
	    		if(p2.getValinta().equals(kivi)) {
	    			System.out.println(p1Voittaa);
	    			return p1;
	    		}
	    		break;
    	}
    	System.out.println("\n\t\t\t Pelaaja 2 voittaa");
    	return p2;
    }
}
