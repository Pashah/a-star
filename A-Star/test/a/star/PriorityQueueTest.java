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
    
    @Before
    public void setUp() {
        prioQueue = new PriorityQueue(5);
    }
    /**
     * Testaa myös metodeita: returnMin, heapify ja doubleQueue
     */
    @Test
    public void insertTest() {
        Node node0 = new Node(0, 0);
        node0.setArvo(5);
        Node node1 = new Node(0, 1);
        node1.setArvo(3);
        Node node2 = new Node(1, 1);
        node2.setArvo(2);
        Node node3 = new Node(1, 2);
        node3.setArvo(4);
        Node node4 = new Node(2, 2);
        node4.setArvo(1);
        prioQueue.insert(node0);
        prioQueue.insert(node1);
        assertSame("PriorityQueue did not return expected node", node1, prioQueue.returnMin());
        prioQueue.insert(node2);
        assertSame("PriorityQueue did not return expected node", node2, prioQueue.returnMin());
        prioQueue.insert(node3);
        assertSame("PriorityQueue did not return expected node", node2, prioQueue.returnMin());
        prioQueue.insert(node4);
        assertSame("PriorityQueue did not return expected node", node4, prioQueue.returnMin());
        Node node5 = new Node(2,3);
        node5.setArvo(6);
        Node node6 = new Node(3,3);
        node6.setArvo(7);
        Node node7 = new Node(4,3);
        node7.setArvo(0);
        prioQueue.insert(node5);
        prioQueue.insert(node6);
        prioQueue.insert(node7);
        assertSame("PriorityQueue did not return expected node", node7, prioQueue.returnMin());
    }
    
    /**
     * Testaa myös metodeita: extractMin, heapifyDown ja getChildIndex
     */
    @Test
    public void extractMinTest() {
        Node node0 = new Node(0, 0);
        node0.setArvo(5);
        Node node1 = new Node(0, 1);
        node1.setArvo(3);
        Node node2 = new Node(1, 1);
        node2.setArvo(2);
        Node node3 = new Node(1, 2);
        node3.setArvo(4);
        Node node4 = new Node(2, 2);
        node4.setArvo(1);
        prioQueue.insert(node0);
        prioQueue.insert(node1);
        prioQueue.insert(node2);
        prioQueue.insert(node3);
        prioQueue.insert(node4);
        assertSame("PriorityQueue did not return expected node", node4, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node2, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node1, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node3, prioQueue.extractMin());
        assertSame("PriorityQueue did not return expected node", node0, prioQueue.extractMin());
    }
    
}
