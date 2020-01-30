/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer: 01428941
 */

public class ArtikelverwaltungClient {
	public static void main(String[] args){
        try{
            Artikelverwaltung artikelverwaltung = new Artikelverwaltung(args[0]);

            switch (args[1]) {
                case "add" :
                    if (args[2] == "buch"){
                        artikelverwaltung.addArtikel(
                                new Buch(Integer.valueOf(args[3]), args[4], Integer.valueOf(args[6]), args[5],
                                        Double.valueOf(args[7]), Integer.valueOf(args[8])));
                    }else if (args[2] == "cd"){
                    artikelverwaltung.addArtikel(
                            new Buch(Integer.valueOf(args[3]), args[4], Integer.valueOf(args[6]), args[5],
                                    Double.valueOf(args[7]), Integer.valueOf(args[8])));
                    }else if (args[2] == "dvd"){
                        artikelverwaltung.addArtikel(
                                new DVD(Integer.valueOf(args[3]), args[4], Integer.valueOf(args[6]), args[5],
                                        Double.valueOf(args[7]), Integer.valueOf(args[8]), Integer.valueOf(args[9])));
                    }else throw new IllegalArgumentException("Error: Parameter ungueltig.");
                    break;
                case "list" :
                    if (args.length == 2){
                        for(Artikel a: artikelverwaltung.getArtikel())
                            System.out.println(a);
                    } else if (artikelverwaltung.getArtikel(Integer.valueOf(args[2])) != null){
                        System.out.println(artikelverwaltung.getArtikel(Integer.valueOf(args[2])));
                    }
                    else throw new IllegalArgumentException("Error: Artikel nicht vorhanden. (id="+ Integer.valueOf(args[2]) + ")");
                    break;
                case "delete" :
                    if (args.length == 3) artikelverwaltung.deleteArtikel(Integer.valueOf(args[2]));
                    break;
                case "count" :
                    if (args.length == 2) System.out.println("Artikels: " + artikelverwaltung.numberOfObjects());
                    break;
                case "meanprice" :
                    if (args.length == 2) System.out.println(Artikel.getDecimalFormat().format(artikelverwaltung.meanPrice()));
                    break;
                case "oldest" :
                    if (args.length == 2){
                        for (int id : artikelverwaltung.getOldest())
                            System.out.println("Id: " + id);
                    }
                    break;
                default: throw new IllegalArgumentException("Error: Parameter ungueltig.");
            }

        }catch (NumberFormatException e) {
            System.out.println("Error: Parameter ungueltig.");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: Parameter ungueltig.");
        }
    }
}