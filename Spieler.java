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
    public Spieler(int spielerNummer, String name,String farbe, Scanner scanner) {
        this.spielerNummer = spielerNummer; 
        this.name = name;
        this.farbe = farbe;
        this.scanner = scanner; //lokaler Scanner wird mit allgemeinem Scanner verbunden
    }
    
    /**
     * zu Beginn hat jeder Spieler 8 Kugeln
     */
    public void resetUngenutzteKugeln() { 
        this.ungenutzteKugeln= 8;
    }
    
    public static Spieler[] spielerZuweisung() {
        Scanner scanner = new Scanner(System.in); //Konsole wird aufgerufen

        //Spieler 1
        System.out.print("Name Spieler 1: "); 
        String name1 = scanner.nextLine(); //Spieler1 gibt seinen Namen ein
        Spieler spieler1 = new Spieler(1, name1, "w", scanner); //Spieler1 wird erstellt, erhält Nummer 1 und Farbe weiß
        spieler1.resetUngenutzteKugeln(); //zu Beginn hat jeder Spieler 8 Kugel
        System.out.println(name1 + " startet mit 8 weißen Kugeln!");
        
        //Spieler 2
        System.out.print("Name Spieler 2: ");
        String name2 = scanner.nextLine(); //Spieler2 gibt seinen Namen ein
        Spieler spieler2 = new Spieler(2, name2, "s", scanner); //Spieler2 wird erstellt, erhält Nummer 2 und Farbe schwarz
        spieler2.resetUngenutzteKugeln(); //zu Beginn hat jeder Spieler 8 Kugeln
        System.out.println(name2 + " startet mit 8 schwarzen Kugeln!");
        
        return new Spieler[]{spieler1, spieler2}; //beide Spieler werden erstellt
    }
    /**
     * der Spieler legt seine Kugeln auf das Spielfeld
     */
    public void kugelLegen(Spielfeld spielfeld)
    {        
        int x; //Zeilen
        int y; //Spalten
        
        boolean gelegt = false; //zu Beginn wurden noch keine Kugeln gelegt
        boolean gewonnen = false; //zu Beginn wurde noch nicht gewonnen
        
        while (!gelegt) { //wiederholt, solange noch nichts gelegt wird
            System.out.println(name + " (" + farbe + ") , Zahl eingeben: "); //Spieler wird nach Position x gefragt
            x = scanner.nextInt(); //Eingabe für die Zeilen
            
            System.out.println(name + " (" + farbe + ") , Buchstabe eingeben: "); //Spieler wird nach Position y gefragt
            //y = scanner.nextInt(); //Eingabe für die Spalten
            
            String eingabe = scanner.next();  // charAt() funktioniert nur auf einem String, deshalb muss man die Eingabe(scanner) als String speichern
            y = eingabe.charAt(0) - 'a';      // a=0, b=1, c=2, d=3; Eingabe für die Spalten werden für den Computer in Zahlen übersetzt
            
            ungenutzteKugeln = ungenutzteKugeln - 1;
            System.out.println("Spieler " + name + " hat noch " + ungenutzteKugeln + " Kugeln übrig."); //Die Anzahl der ungenutzten Kugeln wird angezeigt

            gelegt = spielfeld.platzPruefen(x, y, this); //Es wird geprüft, ob man eine Kugeln auf diese Position legen darf

        }
        spielfeld.spielbrett = spielfeld.drehtaste.drehen(spielfeld.spielbrett);
    }
    }
   