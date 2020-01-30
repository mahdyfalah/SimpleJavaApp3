import java.util.ArrayList;
import java.util.List;

/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer: 01428941
 */
 
public class Artikelverwaltung {
	private ArtikelDAO aDAO;

    public Artikelverwaltung(String filename) { this.aDAO = SerializationArtikelDAO.getInstance(filename);}

    public List<Artikel> getArtikel(){
        return aDAO.getArtikel();
    }

    public Artikel getArtikel(int id) {
        return aDAO.getArtikel(id);
    }

    public void addArtikel(Artikel artikel) { aDAO.saveArtikel(artikel); }

    public void deleteArtikel(int id) { aDAO.deleteArtikel(id); }

    public int numberOfObjects() {
        return (int) getArtikel().size();
    }

    public Double meanPrice() {
        double sum = 0;

        for(Artikel a: getArtikel())
            sum += a.preis();

        return getArtikel().isEmpty()? sum : sum/getArtikel().size();
    }

    public List<Integer> getOldest() {
        int max = 0;
        List<Integer> oldestList = new ArrayList<Integer>();

        for(Artikel a: getArtikel()){
            if (a.alter() > max) max = a.alter();
        }

        for (Artikel a : getArtikel()){
            if(a.alter() == max) oldestList.add(a.getId());
        }

        return oldestList;
    }
}