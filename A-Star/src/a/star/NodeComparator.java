/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

import java.util.Comparator;

/**
 * Vertaa eri nodeja toisiinsa
 * @author Miika
 */
public class NodeComparator implements Comparator<Node> {
    
    @Override
    public int compare(Node x, Node y) {
        if (x.getArvo() < y.getArvo())
        {
            return -1;
        }
        if (x.getArvo() > y.getArvo())
        {
            return 1;
        }
        return 0;
    }
    
}
