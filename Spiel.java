import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    public Spielfeld spielfeld;
    Spieler[] spieler;
    public Spiel()
    {
        Begrüßung();
        this.spielfeld = new Spielfeld();
    }
    
    public void Begrüßung() {
        System.out.println("Hallo liebe Orbito-Spieler.");
        System.out.println("Gebt euren Namen ein. Der erste Spieler spielt mit der Farbe weiß und beginnt.");
        System.out.println("Schwarz ist s und weiß ist w."); 
        System.out.println("Um eure Kugeln zu legen müsst ihr die Koordinaten auf dem Feld eingeben."); 
        System.out.println("Viel Spaß beim Spielen!");   
    }

    public void erstesLegen(Spieler spieler1) {
        System.out.println( spieler1.name + "beginnt zuerst mit dem legen");
        spieler1.kugelLegen(spielfeld);
        
    }
    
}
