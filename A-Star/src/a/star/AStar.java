package a.star;

/**
 * Projektin pääluokka, jossa ensin luodaan kartta käyttäen apuna MapMakeria
 * ja sen jälkeen Logic-luokan avulla käydään kartta läpi ja etsitään reitti
 * @author Miika
 */
public class AStar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        findRoute();
                
    }
    
    public static void findRoute() {
        MapMaker mapMaker = new MapMaker(5,5,500);
        char map[][];
        map = mapMaker.createMap();
        mapMaker.printMap(map);
        
        boolean routeFound;
        
        Logic logic = new Logic(map);
        routeFound = logic.findRoute();
        
        if(routeFound) {
            System.out.println("Reitti löytyi!");
        } else {
            System.out.println("Reittiä ei löytynyt!");
        }
    }
}
