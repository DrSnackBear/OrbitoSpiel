
/**
 * Beschreiben Sie hier die Klasse Spiler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public String name;
    public String farbe;
    public int punktestand;

    /**
     * Konstruktor für Objekte der Klasse Spiler
     */
    public Spieler(String name,String farbe) {
        this.name = name;
        this.farbe = farbe;
        punktestand = 0;
    }
    public void resetPunktestand() {
        this.punktestand = 0;
    }

    //Kugel legeKugel(String farbe) { //Spieler kann Kugeln legen
      //    return new Kugel(farbe);
    //}
    }
