package a.star;

import java.util.Scanner;

/**
 * Projektin pääluokka, jossa ensin luodaan kartta käyttäen apuna MapMakeria ja
 * sen jälkeen Logic-luokan avulla käydään kartta läpi ja etsitään reitti
 *
 * @author Miika
 */
public class AStar {

    /**
     * Projektin main-metodi, kysyy käyttäjältä kartan leveyden ja korkeuden
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Syota leveys kokonaislukuna: ");
        int leveys = Integer.parseInt(scanner.nextLine());
        System.out.println("Syota korkeus kokonaislukuna: ");
        int korkeus = Integer.parseInt(scanner.nextLine());
        findRoute(leveys, korkeus);
    }

    /**
     * Etsii reitin maaliin ja ilmoittaa löytyikö reitti vai ei
     * @param leveys kartan leveys
     * @param korkeus kartan korkeus
     */
    public static void findRoute(int leveys, int korkeus) {

            MapMaker mapMaker = new MapMaker(leveys, korkeus, 200);
            char map[][];
            map = mapMaker.createMap();

            boolean routeFound;

            Logic logic = new Logic(map);
            routeFound = logic.findRoute();
            if (routeFound) {
                System.out.println("Reitti löytyi!");
            } else {
                System.out.println("Reittiä ei löytynyt!");
            }
        }
}
