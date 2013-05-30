/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miika
 */
public class NodeComparatorTest {
    
    private NodeComparator nodeComparator = new NodeComparator();
    
    
    @Test
    public void testEqual() {
        Node node1 = new Node(3, 3);
        Node node2 = new Node(3, 3);
        node1.setArvo(15);
        node2.setArvo(15);
        int result = nodeComparator.compare(node1, node2);
        assertTrue("expected to be equal", result == 0);
    }
    
    @Test
    public void testGreater() {
        Node node1 = new Node(6, 5);
        Node node2 = new Node(3, 3);
        node1.setArvo(20);
        node2.setArvo(15);
        int result = nodeComparator.compare(node1, node2);
        assertTrue("expected to be greater than", result >= 1);
    }
    
    @Test
    public void testSmaller() {
        Node node1 = new Node(6, 5);
        Node node2 = new Node(8, 6);
        node1.setArvo(10);
        node2.setArvo(15);
        int result = nodeComparator.compare(node1, node2);
        assertTrue("expected to be less than", result <= -1);
    }
    
}
