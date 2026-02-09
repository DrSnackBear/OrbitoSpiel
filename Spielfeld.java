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
        
        Begrüßung();
        //spielerZuweisung();
        Spieler[] spieler = Spieler.spielerZuweisung();
        spieler1 = spieler[0];
        spieler2 = spieler[1];
        anzeige();
    }
    
    public void Begrüßung() {
        System.out.println("Hallo liebe Orbito-Spieler.");
        System.out.println("Gebt euren Namen ein. Der erste Spieler spielt mit der Farbe weiß und beginnt.");   
        System.out.println("Viel Spaß beim Spielen!");   
    }
    
    /*public void spielerZuweisung() {
        Scanner scanner = new Scanner(System.in);

        //Spieler 1
        System.out.print("Name Spieler 1: ");
        String name1 = scanner.nextLine();
        Spieler spieler1 = new Spieler(1, name1, "weiß");

        System.out.print("Farbe eingeben: ");
        String farbe = scanner.nextLine();
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
    */
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
            System.out.println("Ungültige Koordinaten! loser");
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