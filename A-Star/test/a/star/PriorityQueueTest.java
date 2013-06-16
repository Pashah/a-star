package a.star;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testi priorityqueue luokalle
 * metodit returnMin, heapify, heapifyDown tulee testattua insertTestissä ja 
 * extractMin testissä
 * @author Miika
 */
public class PriorityQueueTest {
    
    private PriorityQueue prioQueue;
    private Node node0;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;
    private Node node6;
    private Node node7;
    
    @Before
    public void setUp() {
        prioQueue = new PriorityQueue(5);
        node0 = new Node(0, 0);
        node0.setArvo(5);
        node1 = new Node(0, 1);
        node1.setArvo(3);
        node2 = new Node(1, 1);
        node2.setArvo(2);
        node3 = new Node(1, 2);
        node3.setArvo(4);
        node4 = new Node(2, 2);
        node4.setArvo(1);
        node5 = new Node(2,3);
        node6 = new Node(3,3);
        node7 = new Node(4,3);
        prioQueue.insert(node0);
        prioQueue.insert(node1);
        prioQueue.insert(node2);
        prioQueue.insert(node3);
        prioQueue.insert(node4);
    }
    
    @Test
    public void queueIsEmptyAtStartTest() {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        assertTrue("New priorityQueue already has over 0 nodes in it!", priorityQueue.nodesInQueue() == 0);
    }
    
    @Test
    public void insertToQueueTest() {
        assertTrue("PriorityQueue does not have right amount of nodes in it", prioQueue.nodesInQueue() == 5);
    }
    
    @Test
    public void doubleQueueTest() {
        assertTrue("PriorityQueue did not double its size succesfully!", prioQueue.getSize() == 10);
    }
    
    @Test
    public void returnMinTest() {
        assertSame("PriorityQueue did not return expected node", node4, prioQueue.returnMin());
        node7.setArvo(0);
        prioQueue.insert(node7);
        assertSame("PriorityQueue did not return expected node", node7, prioQueue.returnMin());
    }
    
    @Test
    public void returnMinAfterAddingNewTest() {
        node5.setArvo(6);
        node6.setArvo(7);
        node7.setArvo(0);
        prioQueue.insert(node5);
        prioQueue.insert(node6);
        prioQueue.insert(node7);
        assertSame("PriorityQueue did not return expected node", node7, prioQueue.returnMin());
    }
    
    /**
     * Testaa myös metodeita: heapifyDown ja getChildIndex
     */
    @Test
    public void extractMinTest() {
        assertSame("PriorityQueue did not return expected node", node4, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node2, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node1, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node3, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node0, prioQueue.extractMin());
    }
    
}
