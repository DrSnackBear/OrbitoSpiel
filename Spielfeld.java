
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 4x4 Feld, 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfeld
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld()
    {
        f_Anzeige();
    }

    
    public void f_Anzeige() 
    {
        System.out.println(". . . .");
        System.out.println(". . . .");
        System.out.println(". . . .");
        System.out.println(". . . .");
        System.out.println("       ");
        System.out.println("GAME START");
    }
}
