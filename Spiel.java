import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spiel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Spiel
{
    public Spielfeld spielfeld;
    Spieler[] spieler;
    public Spiel()
    {
        Begrüßung();
        spieler = spielerZuweisung();
        this.spielfeld = new Spielfeld();
    }
    
    public Spieler[] spielerZuweisung() {
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
    public void Begrüßung() {
        System.out.println("Hallo liebe Orbito-Spieler.");
        System.out.println("Gebt euren Namen ein. Der erste Spieler spielt mit der Farbe weiß und beginnt.");
        System.out.println("Schwarz ist s und weiß ist w."); 
        System.out.println("Um eure Kugeln zu legen müsst ihr die Koordinaten auf dem Feld eingeben."); 
        System.out.println("Viel Spaß beim Spielen!");   
    }

    public void erstesLegen(Spieler spieler1) {
        System.out.println( spieler1.name + "beginnt zuerst mit dem legen");
        spieler1.kugelLegen(spielfeld);
        
    }
    
}
