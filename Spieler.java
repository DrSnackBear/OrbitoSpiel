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
    
        public static Spieler[] spielerZuweisung() {
        Scanner scanner = new Scanner(System.in);

        //Spieler 1
        System.out.print("Name Spieler 1: ");
        String name1 = scanner.nextLine();
        Spieler spieler1 = new Spieler(1, name1, "weiß");
        spieler1.resetUngenutzteKugeln();
        System.out.println(name1 + " startet mit 8 weißen Kugeln!");
        //pause(1);
        
        //Spieler 2
        System.out.print("Name Spieler 2: ");
        String name2 = scanner.nextLine();
        Spieler spieler2 = new Spieler(2, name2, "schwarz");
        spieler2.resetUngenutzteKugeln();
        System.out.println(name2 + " startet mit 8 schwarzen Kugeln!");
        
        return new Spieler[]{spieler1, spieler2};
    }
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
