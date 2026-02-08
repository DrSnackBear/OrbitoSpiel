import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spiler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spieler
{
    public int spielerNummer;
    public String name;
    public String farbe;
    public int ungenutzteKugeln;
    public Spieler(int spielerNummer, String name,String farbe) {
        this.spielerNummer = spielerNummer;
        this.name = name;
        this.farbe = farbe;
    }
    public void resetUngenutzteKugeln() {
        this.ungenutzteKugeln= 8;
    }
    
    //Kugel legeKugel(String farbe) { //Spieler kann Kugeln legen
      //    return new Kugel(farbe);
    //}
    public void kugelLegen(Spielfeld spielfeld)
    {
        Scanner scanner = new Scanner (System.in);
        
        int x;
        int y;
        
        boolean gelegt = false;
        
        while (!gelegt) {
            System.out.println( name + " ( " + farbe + " ) , x eingeben: ");
            x = scanner.nextInt();
            
            System.out.println("y eingeben: ");
            y = scanner.nextInt();
            
            gelegt = spielfeld.platzPrüfen(x, y, this);
        
        }
    }
    }
