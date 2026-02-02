import java.util.Scanner;
import javafx.scene.control.Spinner;
/**
 * Beschreiben Sie hier die Klasse Spielfeld.
 * 4x4 Feld, 
 * veranschaulicht das Spielfeld,
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spielfeld
{

    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld()
    {
        Begrüßung();
        spielerZuweisung();
        Anzeige();
    }
    
    public void Begrüßung() {
        System.out.println("Hallo liebe Orbito-Spieler.");
        System.out.println("Gebt euren Namen ein. Der erste Spieler spielt mit der Farbe weiß und beginnt.");   
        System.out.println("Viel Spaß beim Spielen!");   
    }
    
    public void spielerZuweisung() {
        Scanner scanner = new Scanner(System.in);

        //Spieler 1
        System.out.print("Name Spieler 1: ");
        String name1 = scanner.nextLine();
        Spieler spieler1 = new Spieler(1, name1, "weiß");

        //System.out.print("Farbe eingeben: ");
        //String farbe = scanner.nextLine();
        spieler1.resetUngenutzteKugeln();

        System.out.println(name1 + " gestartet mit 8 Kugeln!");
        //pause(1);
        //Spieler 2
        System.out.print("Name Spieler 2: ");
        String name2 = scanner.nextLine();
        Spieler spieler2 = new Spieler(2, name2, "schwarz");
        spieler2.resetUngenutzteKugeln();
        System.out.println(name2 + " gestartet mit 8 Kugeln!");
    }
    
    public void Anzeige() 
    {
        System.out.println("  A B C D");
        System.out.println("1 . . . .");
        System.out.println("2 . . . .");
        System.out.println("3 . . . .");
        System.out.println("4 . . . .");
        System.out.println("          ");
        System.out.println("GAME START");
    }
    
    /*public void pruefeSpielzustand() {
        if (spieler.getLeben() <= 0) {
            spielVerloren();
        }

        if (alleZieleGetroffen()) {
            spielGewonnen();
        }
    *///}

    private void spielGewonnen() {
        //System.out.println(spieler1 + "hat gewonnen!");
    }

    private void spielVerloren() {
        //System.out.println(spieler2 * "hat verloren!");
    }
}