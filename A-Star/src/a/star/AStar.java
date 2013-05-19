/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

/**
 * Projektin pääluokka, jossa ensin luodaan kartta käyttäen apuna MapMakeria
 * @author Miika
 */
public class AStar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MapMaker mapMaker = new MapMaker(5,5,100);
        char map[][];
        map = mapMaker.createMap();
        mapMaker.printMap(map);
                
    }
}
