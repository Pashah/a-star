package a.star;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
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
        char map[][] = new char[10][10];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = '.';
            }
        }
        map[5][5] = '#';
        logic = new Logic(map);
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
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 0;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUp(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUp");
        }
        x = 0;
        y = -3;
        logic.checkUp(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUp");
        }
        y = 13;
        logic.checkUp(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUp");
        }
        x = 5;
        y = 4;
        logic.checkUp(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkUp(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckDown() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDown(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDown");
        }
        x = 0;
        y = -3;
        logic.checkDown(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDown");
        }
        y = 13;
        logic.checkDown(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDown");
        }
        x = 5;
        y = 6;
        logic.checkDown(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkUp(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckLeft() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkLeft");
        }
        x = 2;
        y = -3;
        logic.checkLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkLeft");
        }
        y = 13;
        logic.checkLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkLeft");
        }
        x = 6;
        y = 5;
        logic.checkLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkLeft(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckRight() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkRight");
        }
        x = 2;
        y = -3;
        logic.checkRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkRight");
        }
        y = 13;
        logic.checkRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkRight");
        }
        x = 4;
        y = 5;
        logic.checkRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkRight(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckDownRight() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDownRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownRight");
        }
        x = 2;
        y = -3;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownRight");
        }
        y = 13;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownRight");
        }
        x = 4;
        y = 6;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkDownRight(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckDownLeft() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownLeft");
        }
        x = 2;
        y = -3;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownLeft");
        }
        y = 13;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkDownLeft");
        }
        x = 6;
        y = 6;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkDownLeft(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckUpLeft() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpLeft");
        }
        x = 2;
        y = -3;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpLeft");
        }
        y = 13;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpLeft");
        }
        x = 6;
        y = 4;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkUpLeft(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    @Test
    public void testCheckUpRight() {
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        int x = -2;
        int y = 1;
        Node[][] nodeMap = logic.createNodeMap();
        logic.checkUpRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpRight");
        }
        x = 2;
        y = -3;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpRight");
        }
        y = 13;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to set index out of range to checkUpRight");
        }
        x = 4;
        y = 4;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (!queue.isEmpty()) {
            fail("Possible to go through walls even though should not");
        }
        y = 2;
        logic.checkUpRight(x, y, nodeMap, queue);
        if (queue.isEmpty()) {
            fail("Nothing set to queue even though should have");
        }
    }
    
    //TODO: test findRoute()
}
