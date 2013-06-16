package a.star;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testejä Logic-luokalle
 *
 * @author Miika
 */
public class LogicTest {

    private Logic logic;
    private Comparator<Node> nodeComparator = new NodeComparator();

    @Before
    public void setUp() {
        MapMaker mapMaker = new MapMaker(10,10,1000);
        char map[][];
        map = mapMaker.createMap();
        map[5][5] = '#';
        logic = new Logic(map);
    }
    
    @Test
    public void testFindRoute() {
        boolean expectedResult = true;
        boolean routeFound = logic.findRoute();
        assertEquals("Did not found route even though should have!", expectedResult, routeFound);
    }

    @Test
    public void testCreateNodeMap() {
        Node[][] result = logic.createNodeMap();
        Node[][] expected = new Node[10][10];
        assertEquals("Create nodeMap created wrong sized map", expected.length, result.length);
        assertEquals("Create nodeMap created wrong sized map", expected[0].length, result[0].length);
    }
    ///////////////////
    //Liikkumistestit:
    //////////////////
    @Test
    public void testCheckUp() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 1;
        int y  = 13;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUp(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkUp");
        }
        x = 5;
        y = 4;
        logic.checkUp(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckDown() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 0;
        int y = 0;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDown(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkDown");
        }
        x = 5;
        y = 6;
        logic.checkDown(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckLeft() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 0;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkLeft");
        }
        x = 6;
        y = 5;
        logic.checkLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckRight() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 10;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkRight");
        }
        x = 4;
        y = 5;
        logic.checkRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckDownRight() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 2;
        int y = 0;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDownRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkDownRight");
        }
        x = 10;
        y = 5;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkDownRight");
        }
        x = 4;
        y = 6;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckDownLeft() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 0;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkDownLeft");
        }
        x = 2;
        y = 0;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkDownLeft");
        }
        x = 6;
        y = 6;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckUpLeft() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 0;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkUpLeft");
        }
        x = 2;
        y = 10;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkUpLeft");
        }
        x = 6;
        y = 4;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
    
    @Test
    public void testCheckUpRight() {
        PriorityQueue queue = new PriorityQueue(5);
        int x = 10;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUpRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkUpRight");
        }
        x = 2;
        y = 10;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to set index out of range to checkUpRight");
        }
        x = 4;
        y = 4;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (queue.nodesInQueue() > 0) {
            fail("Possible to go through walls even though should not");
        }
    }
}
