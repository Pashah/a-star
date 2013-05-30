/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miika
 */
public class MapMakerTest {
    
    private int korkeus;
    private int leveys;
    private int tyhjat;
    
    private MapMaker mapMaker;
    
    public MapMakerTest() {
    }
    
    
    
    @Before
    public void setUp() {
        korkeus = 10;
        leveys = 10;
        tyhjat = 0;
    }
    

    @Test
    public void testCreateMap() {
        MapMaker mapMaker = new MapMaker(korkeus,leveys,tyhjat);
        char[][] expected = new char[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                expected[i][j] = '#';
            }
        }
        char[][] result = mapMaker.createMap();
        assertArrayEquals(expected, result);
        mapMaker.setTyhjat(400);
        mapMaker.createSpace(result);
        expected[0][0] = '.';
        assertEquals("Expected . but was #",expected[0][0],result[0][0]);
    }


    @Test
    public void testCreateSpace() {
        System.out.println("createSpace test");
        MapMaker instance = new MapMaker(korkeus,leveys,tyhjat);
        if(tyhjat != instance.getTyhjat()) {
            fail("Space percent is not same!");
        }
    }
}
