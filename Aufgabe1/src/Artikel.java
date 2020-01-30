import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;

/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer:01428941
 */

public abstract class Artikel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int Id;
	private String Titel;
	private int Erscheinungsdatum;
	private String Verlag;
	private double Grundpreis;

	public Artikel(int Id, String Titel, int Erscheinungsdatum, String Verlag, double Grundpreis){
        if( Titel.isEmpty() || Verlag.isEmpty() || Grundpreis <= 0 ) throw new IllegalArgumentException("Error: Parameter ungueltig.");
        if( Erscheinungsdatum > Calendar.getInstance().get(Calendar.YEAR) ) throw new IllegalArgumentException("Error: Erscheinungsjahr ungueltig.");
	    this.Id = Id;
	    this.Titel = Titel;
	    this.Erscheinungsdatum = Erscheinungsdatum;
	    this.Verlag = Verlag;
	    this.Grundpreis = Grundpreis;
    }


	public int getId() { return Id; }

	public String getTitel() { return Titel; }

	public int getErscheinungsdatum() { return Erscheinungsdatum; }

	public String getVerlag() { return Verlag; }

	public double getGrundpreis() { return Grundpreis; }

	public int alter() { return Calendar.getInstance().get(Calendar.YEAR) - Erscheinungsdatum; }

	public static DecimalFormat getDecimalFormat() {
		DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
		dfs.setDecimalSeparator('.');
		return new DecimalFormat("0.00", dfs);
	}

	public double preis(){
	    return getGrundpreis() - (getGrundpreis() * rabatt());
    }

    public abstract double rabatt();
}
