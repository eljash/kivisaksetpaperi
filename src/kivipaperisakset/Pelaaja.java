
package kivipaperisakset;

/**
 * Pelaajan luokka. Luokka pitää kirjaa pelaajan voitoista, sekä pelaajan valinnoista.
 *
 * @author Ira Dook
 * @author Eljas Hirvelä
 */
public class Pelaaja {

    private int voitot;      //Voittojen lukumäärä
    private String valinta; //Pelaajan valinta

    /**
     * Valitsee pelaajalle satunnaisesti vaihtoehdon arvoista [kivi, paperi, sakset].
     */
    public void pelaajanValinta() {
    	//Luodaan satunnainen arvo väliltä 0-2 ja sen mukaan annetaan pelaajalle valinta.
        switch ((int) (Math.random() * 3)) {
            case 0:
                valinta = "kivi";
                break;
            case 1:
                valinta = "paperi";
                break;
            case 2:
                valinta = "sakset";
                break;
            default:
            	//Varmuudenvuoksi default tilanne, jos satunnainen luku onnistuu mahdottomassa.
            	valinta = "paperi";
            	break;
                	
        }
    }
    
    /**
     * 
     * @param valinta pelaajalle annettava valinta.
     */
    public void setValinta(String valinta) {
    	this.valinta = valinta;
    }
    
    /**
     * 
     * @return pelaajan tämän hetkinen valinta
     */
    public String getValinta() {
    	return valinta;
    }

    /**
     * Kasvattaa pelaajan voittojen määrää, sekä palauttaa sen.
     * @return pelaajan kasvatetun voittojen määrän.
     */
    public int setVoitot() {
        return ++voitot;
    }
    
    /**
     * 
     * @return pelaajan voitot.
     */
    public int getVoitot() {
        return voitot;
    }
}
