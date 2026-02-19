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
    private Spieler spieler1; //Spieler1 wird initialisiert 
    private Spieler spieler2; //Spieler2 wird initialisiert 
    Spieler aktuellerSpieler; //Das ist der Spieler, der gerade am Zug ist
    boolean spielFertig = false; //das Spiel ist von Beginn an nicht fertig
    private int xFeldLaenge = 4; //Länge einer Zeile auf dem Spielfeld
    private int yFeldLaenge = 4; //Länger einer Spalte auf dem Spielfeld
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
        spielAblauf();
       
    }
    
    /**
     * Spielfeld wird angezeigt
     */
    public void anzeige () { 
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
    
    /**
     * hier werden die Spieler abwechselnd nach den Kugelkoordinaten gefragt
     */
    public void spielAblauf() { 
            while (!spielFertig) { //solange das Spiel nicht fertig ist
            
            aktuellerSpieler.kugelLegen(this); // Die Methode fragt x und y ab und setzt die Kugel
                   
            pruefeSpielzustand(); //prüft, ob das Spiel vorbei ist (Unentschieden, Gewinn oder Niederlage)
            
            if (aktuellerSpieler == spieler1) { //Spieler wechseln
                aktuellerSpieler = spieler2;
            } else {
                aktuellerSpieler = spieler1;
            }
            anzeige(); //aktuelles Spielfeld mit allen gelegten Kugeln wird angezeigt
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
    
    private boolean spielfeldVoll() {
        for (int i = 0; i < xFeldLaenge; i++) {
            for (int j = 0; j < yFeldLaenge; j++) {
                if (spielbrett[i][j] == null) { //wenn eines der Felder noch nicht belegt ist, ist das Feld noch nicht voll
                                                //und das Spiel noch nicht zuende
                    return false;
                } 
            }
        }
        System.out.println("Unentschieden!");
        spielFertig = true;
        return true; //wenn kein Feld leer war, ist das Spielfeld voll
    }
    public boolean testNebeneinander (int x, int y, Spieler spieler) {

        if (spielbrett[x][y] != null && spielbrett[x][y+1] != null && spielbrett[x][y+2] != null && spielbrett[x][y+3] != null) {
            System.out.println("Gewonnen!");
            anzeige();
            return false;
        }              
 
        System.out.println("Noch nicht gewonnen!");
        return true;
    }
       public boolean kugelnNebeneinander() {
       /*
        // Horizontal
        for (int i = 0; i < xFeldLaenge; i++) {
            for (int j = 0; j <= yFeldLaenge - 4; j++) {
                Kugeln k1 = spielbrett[i][j];
                Kugeln k2 = spielbrett[i][j+1];
                Kugeln k3 = spielbrett[i][j+2];
                Kugeln k4 = spielbrett[i][j+3];
                if (k1 != null && k1.equalsFarbe(k2) && k1.equalsFarbe(k3) && k1.equalsFarbe(k4)) {
                    System.out.println("Horizontaler Sieg für " + k1.color + "!");
                    spielFertig = true;
                    return true;
                }
            }
        }

        // Vertikal
        for (int j = 0; j < yFeldLaenge; j++) {
            for (int i = 0; i <= xFeldLaenge - 4; i++) {
                Kugeln k1 = spielbrett[i][j];
                Kugeln k2 = spielbrett[i+1][j];
                Kugeln k3 = spielbrett[i+2][j];
                Kugeln k4 = spielbrett[i+3][j];
                if (k1 != null && k1.equalsFarbe(k2) && k1.equalsFarbe(k3) && k1.equalsFarbe(k4)) {
                    System.out.println("Vertikaler Sieg für " + k1.color + "!");
                    spielFertig = true;
                    return true;
                }
            }
        }

        // Diagonal \
        for (int i = 0; i <= xFeldLaenge - 4; i++) {
            for (int j = 0; j <= yFeldLaenge - 4; j++) {
                Kugeln k1 = spielbrett[i][j];
                Kugeln k2 = spielbrett[i+1][j+1];
                Kugeln k3 = spielbrett[i+2][j+2];
                Kugeln k4 = spielbrett[i+3][j+3];
                if (k1 != null && k1.equalsFarbe(k2) && k1.equalsFarbe(k3) && k1.equalsFarbe(k4)) {
                    System.out.println("Diagonaler Sieg (\\) für " + k1.color + "!");
                    spielFertig = true;
                    return true;
                }
            }
        }

        // Diagonal /
        for (int i = 0; i <= xFeldLaenge - 4; i++) {
            for (int j = 3; j < yFeldLaenge; j++) {
                Kugeln k1 = spielbrett[i][j];
                Kugeln k2 = spielbrett[i+1][j-1];
                Kugeln k3 = spielbrett[i+2][j-2];
                Kugeln k4 = spielbrett[i+3][j-3];
                if (k1 != null && k1.equalsFarbe(k2) && k1.equalsFarbe(k3) && k1.equalsFarbe(k4)) {
                    System.out.println("Diagonaler Sieg (/) für " + k1.color + "!");
                    spielFertig = true;
                    return true;
                }
            }
        }

        return false;

        //Woran kann der Computer erkennen,dass vier Kugeln nebeneinander sind?:
        //derselbe spieler, eine spalte/zeile/zwei diagonalen
        //eine zeile: (0 |0 ) (0 |1 ) (0 |2 ) (0 |3 )
        //Zeilenformel: alle y- werte unterschiedlich, alle x-werte gleich (x|y+1 ) 
        //eine spalte: (0 |0 ) (1 |0 ) (2 |0 ) (3 |0 )
        //Spaltenformel: alle x- werte unterschiedlich, alle y-werte gleich (x+1|y) 
        //eine Diagonale: 1. (0 |0 ) (1 |1 ) (2 |2 ) (3 |3 ) von links oben nach rechts unten
        //zweite Diagonale: (3 | 0)  (2 |1 ) (1 |2 ) (0 |3 ) von rechts oben nach links unten
        //Diagonalenformel: ( n | n) bzw. x==y oder ( n-1 | n+1);    
        /*        int count = 0;
         * 
         */   
        return false;
    }
    
        /**
         * hier wird geprüft,ob das Spiel gewonnen, verloren oder unentschieden ist
         */
    private void pruefeSpielzustand() { 
            if (spielfeldVoll()) { //wenn das Spielfeld voll ist und es vorher keinen Sieg gab, ist das Spiel unentschieden
                spielFertig = true; //das Spiel ist fertig und damit wird spielAblauf beendet
                System.out.println("Unentschieden!");
            } 
            if (kugelnNebeneinander()) {
               System.out.println("Sieg");
                //System.out.println(spieler1 + "hat gewonnen!");
                //System.out.println(spieler2 + "hat verloren!");
            } 
    }
}

