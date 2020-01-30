import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <Mohammad Mahdi Fallah>
 * Matrikelnummer: 01428941
 */

public class SerializationArtikelDAO implements ArtikelDAO {

    private static SerializationArtikelDAO instance;
    private static List<Artikel> artikels = new ArrayList<Artikel>();
    private static File file;


    public static SerializationArtikelDAO getInstance(String data) {
        if (instance != null) { return instance; }
        file = new File(data);
        try {
            if (!file.exists() || file.length() == 0) return new SerializationArtikelDAO();
            ObjectInputStream reader;
            reader = new ObjectInputStream(new FileInputStream(data));
            artikels = (List<Artikel>)reader.readObject();
            reader.close();
        }
        catch (Exception e) {
            System.err.println("Fehler bei Deserialisierung: " + e.getMessage());
            System.exit(1);
            e.printStackTrace();
        }
        return instance = new SerializationArtikelDAO();
    }

    private SerializationArtikelDAO() { }

    @Override
    public List<Artikel> getArtikel() {
        return artikels;
    }

    @Override
    public Artikel getArtikel(int id) {
        for (Artikel artikel : artikels) {
            if (artikel.getId() == id) return artikel;
        }
        return null;
    }

    @Override
    public void saveArtikel(Artikel artikel) {
        if (getArtikel(artikel.getId()) != null) throw new IllegalArgumentException("Error: Artikel bereits vorhanden. (id=" + artikel.getId() + ")");
        artikels.add(artikel);
        serializeArtikels();
        System.out.println("Info: Artikel " + artikel.getId() + " added.");
    }

    private void serializeArtikels() {
        try {
            if (file.exists()) file.delete();
            else file.createNewFile();
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file, true));
            writer.writeObject(artikels);
            writer.close();
        }
        catch (Exception e) {
            System.err.println("Fehler bei Serialisierung: " + e.getMessage());
            System.exit(1);
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArtikel(int id) {
        if (getArtikel(id) == null) throw new IllegalArgumentException("Error: Artikel nicht vorhanden. (id="+ id + ")");
        artikels.remove(getArtikel(id));
        serializeArtikels();
        System.out.println("Info: Artikel " + id + " deleted.");
    }
}