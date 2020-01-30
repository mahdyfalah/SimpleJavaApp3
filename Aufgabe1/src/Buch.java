import java.text.DecimalFormat;

/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer: 01428941
 */

public class Buch extends Artikel{

	private static final long serialVersionUID = 1L;

	private int seitenAnzahl;

	public Buch(int Id, String Titel, int Erscheinungsdatum, String Verlag, double Grundpreis, int seitenAnzahl){
		super(Id, Titel, Erscheinungsdatum, Verlag, Grundpreis);
		if(seitenAnzahl < 1) throw new IllegalArgumentException("Error: Parameter ungueltig.");
		this.seitenAnzahl = seitenAnzahl;
	}

	public int getSeitenAnzahl(){return seitenAnzahl;}


	@Override
	public String toString() {
		DecimalFormat df = getDecimalFormat();
		return 	"Typ:        " +  "Buch\n" +
				"Id:         " + getId() +  "\n" +
				"Titel:      " + getTitel() +  "\n" +
				"Jahr:       " + getErscheinungsdatum() +  "\n" +
				"Verlag:     " + getVerlag() +  "\n" +
				"Grundpreis: " + getGrundpreis() +  "\n" +
				"Preis:      " + Artikel.getDecimalFormat().format((getGrundpreis()- (getGrundpreis() * rabatt())))+  "\n" +
				"Seiten:     " + getSeitenAnzahl() +  "\n";
	}

	@Override
	public double rabatt() {
		int alter = this.alter();
		double temp = 0.0;
		for(int i=0; i<alter && i < 6; i++){
			temp += 0.05;
		}
		return seitenAnzahl > 1000 ? temp + 0.03 : temp;
	}
}