import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer: 01428941
 */

public class DVD extends Artikel {
	
	private static final long serialVersionUID = 1L;

	private int spielDauer;
	private int alterFreigabe;


	public DVD(int Id, String Titel, int Erscheinungsdatum, String Verlag, double Grundpreis, int spielDauer, int alterFreigabe) {
		super(Id, Titel, Erscheinungsdatum, Verlag, Grundpreis);

		if(spielDauer < 1) throw new IllegalArgumentException("Error: Parameter ungueltig.");
		int[] arr = new int[]{0, 6, 12, 16, 18};
		if(Arrays.stream(arr).noneMatch(i -> i == alterFreigabe)) throw new IllegalArgumentException("Error: Altersfreigabe ungueltig.");

		this.spielDauer = spielDauer;
		this.alterFreigabe = alterFreigabe;
	}

	public int getSpielDauer(){return spielDauer;}
	public int getAlterFreigabe(){return alterFreigabe;}

	@Override
	public String toString() {
		DecimalFormat df = getDecimalFormat();
		return 	"Typ:        " +  "DVD\n" +
				"Id:         " + getId() +  "\n" +
				"Titel:      " + getTitel() +  "\n" +
				"Jahr:       " + getErscheinungsdatum() +  "\n" +
				"Verlag:     " + getVerlag() +  "\n" +
				"Grundpreis: " + getGrundpreis() +  "\n" +
				"Preis:      " + Artikel.getDecimalFormat().format((getGrundpreis()- (getGrundpreis() * rabatt())))+  "\n" +
				"Dauer:      " + getSpielDauer() +  "\n" +
				"Freigabe:   " + getAlterFreigabe() +  "\n";

	}

	@Override
	public double rabatt() {
		double temp = 0.0;
		switch (alterFreigabe){
			case 0:
				temp += 0.2;
				break;
			case 6:
				temp += 0.15;
				break;
			case 12:
				temp += 0.1;
				break;
			case 16:
				temp += 0.05;
				break;
			default :
				temp = 0;
		}
		return temp;
	}
}