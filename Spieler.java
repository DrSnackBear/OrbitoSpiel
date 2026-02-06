
/**
 * Beschreiben Sie hier die Klasse Spiler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public int spielerNummer;
    public String name;
    public String farbe;
    public int ungenutzteKugeln;
    public Spieler(int spielerNummer, String name,String farbe) {
        this.spielerNummer = spielerNummer;
        this.name = name;
        this.farbe = farbe;
    }
    public void resetUngenutzteKugeln() {
        this.ungenutzteKugeln= 8;
    }

    //Kugel legeKugel(String farbe) { //Spieler kann Kugeln legen
      //    return new Kugel(farbe);
    //}
    }
