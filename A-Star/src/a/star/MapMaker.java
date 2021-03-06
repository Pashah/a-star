/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

import java.util.*;

/**
 * Tekee kartan, jossa #-merkki tarkoittaa seinää ja .-merkki tarkoittaa vapaata reittiä
 * jota pitkin voi kulkea. Kartta on char tyyppinen matriisi, jonka korkeus ja leveys
 * määritellään konstruktorissa intteinä. Lisäksi kartalle annetaan tyhjien prosenttiosuus
 * konstruktoriin. Tyhjät paikat laitetaan karttaan randomilla, jolloin on mahdollista
 * että ne ovat päällekkäin
 * @author Miika
 */
public class MapMaker {
    
    private static Random randomizer = new Random(); 
    
    private int korkeus;
    private int leveys;
    private int tyhjat;
    
    /**
     * Konstruktori
     * @param korkeus kartan korkeus
     * @param leveys kartan leveys
     * @param tyhjat kartan prosenttuaalinen tyhjien määrä
     */
    public MapMaker(int korkeus, int leveys, int tyhjat) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.tyhjat = tyhjat;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getTyhjat() {
        return tyhjat;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public void setLeveys(int leveys) {
        this.leveys = leveys;
    }

    public void setTyhjat(int tyhjat) {
        this.tyhjat = tyhjat;
    }
    
    
    
    /**
     * Tekee käyttäjän syötteen mukaisen kartan.
     * Kartan jokainen ruutu täytetään #-merkillä, joka tarkoittaa seinää
     * @return kartta täynnä seiniä
     */
    public char[][] createMap() {
        char[][] map = new char[korkeus] [leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                map[i][j] = '#';
            }
        }
        createSpace(map);
        return map;
    }
    
    /**
     * Tekee karttaa randomisti tyhjiä kohtia käyttäjän antaman prosenttimäärän
     * mukaan. Vapaa reitti merkitään . Tekee randomilla tyhjiä kohtia, joten 100%
     * ei takaa täysin tyhjää karttaa koska tyhjät kohdat voivat mennä päällekkäin tällä hetkellä
     * @param map kartta, jossa on kaikki ruudut seiniä
     * @return kartta, jossa on .-merkkejä jotka tarkoittavat vapaata reittiä
     * ja #-merkkejä, jotka tarkoittavat seinää
     */
    public char[][] createSpace(char[][] map) {
        double count = (korkeus * leveys) * (tyhjat*0.01);
        while(count > 0) {
            int kork = randomizer.nextInt(korkeus);
            int lev = randomizer.nextInt(leveys);
            map[kork][lev] = '.';
            count--;
        }
        printMap(map);
        return map;
    }
    
    /**
     * Apumetodi, joka tulostaa kartan
     * @param map kartta, joka tulostetaan
     */
    public void printMap(char[][] map) {
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println("");
        } 
    }
    
}
