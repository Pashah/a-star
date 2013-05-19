/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

/**
 *
 * @author Miika
 */
public class Node {
    
    private int x;
    private int y;
    private int arvo;
    
    /**
     * Konstruktori
     * @param x x-koordinaatti
     * @param y y-koordinaatti 
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = Integer.MAX_VALUE;
    }

    public int getArvo() {
        return arvo;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
}
