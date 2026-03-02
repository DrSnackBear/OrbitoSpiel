
/**
 * Beschreiben Sie hier die Klasse Drehtaste.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Drehtaste
{
    public Drehtaste()
    {
        
        //drehen();
        //Spielfeld.spielbrett = drehen(Spielfeld.spielbrett);
    }
    
    public Kugeln[][] drehen(Kugeln[][] spielbrett) {
        Kugeln[][] gedrehtesSpielfeld = new Kugeln[4][4];
        for (int y = 0; y < 3; y++){ //links, allegedly richtig
            gedrehtesSpielfeld[y+1][0] = spielbrett[y][0];
        }
        for (int x = 0; x < 3; x++){ //unten, ar
            gedrehtesSpielfeld[3][x+1] = spielbrett[3][x];
        }
        for (int y = 3; y > 0; y--){ //
            gedrehtesSpielfeld[y-1][3] = spielbrett[y][3];
        }
        for (int x = 3; x > 0; x--) { 
            gedrehtesSpielfeld[0][x-1] = spielbrett[0][x];
        }
        gedrehtesSpielfeld[1][1] = spielbrett[1][2];
        gedrehtesSpielfeld[1][2] = spielbrett[2][2];
        gedrehtesSpielfeld[2][2] = spielbrett[2][1];
        gedrehtesSpielfeld[2][1] = spielbrett[1][1];
        return gedrehtesSpielfeld;
        }

    }