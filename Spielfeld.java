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
    private Kugeln[][] spielbrett;
    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld()
    {
        //Scanner scanner = new Scanner(System.in);

        //System.out.print("Name eingeben: ");
        //String name = scanner.nextLine();

        //System.out.print("Farbe eingeben: ");
        //String farbe = scanner.nextLine();

        //Spieler spieler = new Spieler(name, farbe);
        //spieler.resetUngenutzteKugeln();
        this.spielbrett = new Kugeln [4][4];
        System.out.println("Spiel gestartet mit 8 Kugeln!");
        //pause(1);
        //Spielfeld spielfeld = new Spielfeld();
        //Anzeige();
        
    
        /*public void Anzeige() 
        {
        System.out.println("  A B C D");
        System.out.println("1 . . . .");
        System.out.println("2 . . . .");
        System.out.println("3 . . . .");
        System.out.println("4 . . . .");
        System.out.println("          ");
        System.out.println("GAME START");
        }
        */
    }
    
    public void pruefeSpielzustand() {
        if (spieler.getLeben() <= 0) {
            spielVerloren();
        }

        if (alleZieleGetroffen()) {
            spielGewonnen();
        }
    }

    private void spielGewonnen() {
        System.out.println("Gewonnen!");
    }

    private void spielVerloren() {
        System.out.println("Verloren!");
    }
    
    public void erzeugung () {
        System.out.println("0 1 2 3");
        for (int x = 0; x < 4 ; x++) {
            String spalte = "" + x;
            for (int y = 0; y < 4; y++) {
                if (spielbrett[x][y] == null) {
                    spalte = spalte + " .";
                }
                else {
                    spalte = spalte + " " + spielbrett[x][y].color;
                }
            }
            System.out.println(spalte);
        }
    }
    
    
}