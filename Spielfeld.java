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
    private Spieler spieler3;
    Spieler aktuellerSpieler;
    boolean spielFertig = false; //das Spiel ist von Beginn an nicht fertig
    /**
     * Konstruktor für Objekte der Klasse Spielfeld
     */
    public Spielfeld()
    {
        this.spielbrett = new Kugeln [4][4];
        Scanner scanner = new Scanner(System.in); //ein allgemeiner Scanner wird erstellt
        
        //spielerZuweisung
        Spieler[] spieler = Spieler.spielerZuweisung(); //Spieler werden Zahl 0 und 1 zugewiesen und gespeichert
        spieler1 = spieler[0];
        spieler2 = spieler[1];
        
        aktuellerSpieler = spieler1;
        anzeige();
        pruefeSpielzustand();
       
    }
    
    public void anzeige () { //Spielfeld wird angezeigt
        System.out.println("  0 1 2 3"); //Spaltennummerierung
        for (int x = 0; x < 4 ; x++) { // Jede neue Zeile wird von 0-3 mit Leerzeichen nummeriert
            String spalte = "" + x; 
            for (int y = 0; y < 4; y++) { 
                if (spielbrett[x][y] == null) { //Jedes leeres Feld wird mit einem Punkt markiert
                    spalte = spalte + " ."; 
                }
                else { //andernfalls wird die Farbe der gelegten Kugel angezeigt
                    spalte = spalte + " " + spielbrett[x][y].color;
                }
            }
            System.out.println(spalte); //die Spalte mit der Zeilennummerierung wird gedruckt
        }
    }
    
    public boolean platzPruefen(int x,int y, Spieler spieler) {
        if (x < 0 || x > 3 || y < 0 || y > 3) { //Zahlen, die nicht zwischen 0 und 3 liegen sind ungültig
            System.out.println("Ungültige Koordinaten!");
            return false;
        } else if (spielbrett [x][y] != null) { //man kann keine Kugel über eine andere legen
            System.out.println("Feld ist bereits belegt!");
            return false;
        }
        
        spielbrett[x][y] = new Kugeln(spieler.farbe); //wenn alles richtig eingegeben wurde, 
        //wird eine Kugel des jeweiligen Spielers mit der jeweiligen Farbe erstellt 
        spieler.ungenutzteKugeln--;                   //und von den ungenutzten Kugeln abgezogen

        return true;
    }
    
    public void pruefeSpielzustand() { //hier werden die Spieler abwechselnd nach den Kugelkoordinaten gefragt
            while (!spielFertig) {
            // Spieler nach Koordinaten fragen
            aktuellerSpieler.kugelLegen(this); // Die Methode fragt x und y ab und setzt die Kugel
            
            // Prüfen ob das Spiel vorbei ist (z.B. alle Felder voll)
            //spielFertig = this.istVoll(); 
            
            if (aktuellerSpieler == spieler1) { //Spieler wechseln
                aktuellerSpieler = spieler2;
            } else {
                aktuellerSpieler = spieler1;
            }
            anzeige(); //aktuelles Spielfeld mit allen gelegten Kugeln wird angezeigt
        }
    } 
    
    private void spielGewonnen() {
        //System.out.println(spieler1 + "hat gewonnen!");
    }

    private void spielVerloren() {
        //System.out.println(spieler2 * "hat verloren!");
    }
}