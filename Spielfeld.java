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
    //public boolean platz;
    private Spieler spieler1;
    private Spieler spieler2;
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
        //System.out.println("Spiel gestartet mit 8 Kugeln!");
        //pause(1);
        //Spielfeld spielfeld = new Spielfeld();
        


        //spielerZuweisung();
        Spieler[] spieler = Spieler.spielerZuweisung();
        spieler1 = spieler[0];
        spieler2 = spieler[1];

        anzeige();
    }
    
 
    public void pruefeSpielzustand() {
        /*if (spieler.getLeben() <= 0) {
            spielVerloren();
        }

        if (alleZieleGetroffen()) {
            spielGewonnen();
        }
        }*/
    }

    private void spielGewonnen() {
        //System.out.println(spieler1 + "hat gewonnen!");
    }

    private void spielVerloren() {
        //System.out.println(spieler2 * "hat verloren!");
    }
    
    public void anzeige () {
        System.out.println("  0 1 2 3");
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
    
    public boolean platzPrüfen(int x,int y, Spieler spieler) {
        if (x < 0 || x > 3 || y < 0 || y > 3) {
            System.out.println("Ungültige Koordinaten!");
            return false;
        } else if (spielbrett [x][y] != null) {
            System.out.println("Feld ist bereits belegt!");
            return false;
        }
        
        spielbrett[x][y] = new Kugeln(spieler.farbe);
        spieler.ungenutzteKugeln--;

        return true;
    }
}