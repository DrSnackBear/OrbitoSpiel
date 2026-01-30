import java.util.Scanner;
/**
 * Beschreiben Sie hier die Klasse Orbito.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Orbito
{
    public Orbito() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Name eingeben: ");
        String name = scanner.nextLine();

        System.out.print("Farbe eingeben: ");
        String farbe = scanner.nextLine();

        Spieler spieler = new Spieler(name, farbe);
        spieler.resetPunktestand();

        System.out.println("Spiel gestartet mit Punktestand 0!");
        Spielfeld spielfeld = new Spielfeld();
    }
}
