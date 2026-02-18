import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spiler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    private Scanner scanner;
    public int spielerNummer; //unterscheidet die Spieler
    public String name; //Name des Spielers
    public String farbe; //Farbe der Kugel des Spielers
    public int ungenutzteKugeln; //Kugeln, die der Spieler noch nicht gelegt hat

    public Spieler(int spielerNummer, String name,String farbe ) {
        // Scanner scanner war noch als Parameter, warum aber ist die Frage?

        this.spielerNummer = spielerNummer; 
        this.name = name;
        this.farbe = farbe;
        //this.scanner = scanner; //lokaler Scanner wird mit allgemeinem Scanner verbunden
    }
    
    /**
     * zu Beginn hat jeder Spieler 8 Kugeln
     */
    public void resetUngenutzteKugeln() { 
        this.ungenutzteKugeln= 8;
    }
    /**
     * der Spieler legt seine Kugeln auf das Spielfeld
     */
    /**
     * der Spieler legt seine Kugeln auf das Spielfeld
     */

    public void kugelLegen(Spielfeld spielfeld)
    {        
        int x; //Zeilen
        int y; //Spalten
        
        boolean gelegt = false; //zu Beginn wurden noch keine Kugeln gelegt
        
        while (!gelegt) { //wiederholt, solange noch nichts gelegt wird
            System.out.println(name + " (" + farbe + ") , Zeile eingeben: "); //Spieler wird nach Position x gefragt
            x = scanner.nextInt();
            
            System.out.println(name + " (" + farbe + ") , Spalte eingeben: "); //Spieler wird nach Position y gefragt
            y = scanner.nextInt();
            
            gelegt = spielfeld.platzPruefen(x, y, this); //Es wird geprüft, ob man eine Kugeln auf diese Position legen darf
        
        }
    }
    }
