import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Spieler.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */

public class Spieler extends Orbito

{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    

    /**
     * Konstruktor für Objekte der Klasse Spieler
     */
    public Spieler()
    {
        //
    }
    
    public void abfrageName1 (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie heißt Spieler 1 ?");
        String name = scanner.nextLine();
        System.out.println("Spieler1 heißt" + name + ".");
    }
    
    public void abfrageName2 (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie heißt Spieler 2 ?");
        String name = scanner.nextLine();
        System.out.println("Spieler 2 heißt" + name + ".");
    }
    
}
