// Prufung Aufgabe!!!!

import java.text.DecimalFormat;

public class CD extends Artikel{

    private static final long serialVersionUID = 1L;

    private int tracks;

    public CD(int Id, String Titel, int Erscheinungsdatum, String Verlag, double Grundpreis, int tracks){
        super(Id, Titel, Erscheinungsdatum, Verlag, Grundpreis);
        if(tracks < 1) throw new IllegalArgumentException("Error: Parameter ungueltig.");
        this.tracks = tracks;
    }

    public int getTracks(){return tracks;}


    @Override
    public String toString() {
        DecimalFormat df = getDecimalFormat();
        return 	"Typ:        " +  "CD\n" +
                "Id:         " + getId() +  "\n" +
                "Titel:      " + getTitel() +  "\n" +
                "Jahr:       " + getErscheinungsdatum() +  "\n" +
                "Verlag:     " + getVerlag() +  "\n" +
                "Grundpreis: " + getGrundpreis() +  "\n" +
                "Preis:      " + Artikel.getDecimalFormat().format((getGrundpreis()- (getGrundpreis() * rabatt())))+  "\n" +
                "tracks:     " + getTracks() +  "\n";
    }

    @Override
    public double rabatt() {
        if (tracks <= 5){
            return 0.1;
        }else if (tracks <= 10){
            return 0.05;
        }else if (tracks < 20){
            return 0.02;
        }
        return 0;
    }
}
