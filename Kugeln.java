
/**
 * Beschreiben Sie hier die Klasse Kugeln.
 * 2 Farben, je 8 Kugeln pro Spieler, werden nacheinander auf Spielfeld gelegt,
 * umgelegt und eins weiter gegen den Uhrzeigersinn gedreht.
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kugeln
{
    /**
     * Konstruktor für Objekte der Klasse Kugeln
     */
    public String color;
    //private int kugelNummer;
    public Kugeln(String color) {
        this.color = color;
        //this.kugelNummer = kugelNummer;
    }
 
    public boolean gleicheFarbe(Kugeln andere) {
        return andere != null && this.color.equals(andere.color);
    }

}
