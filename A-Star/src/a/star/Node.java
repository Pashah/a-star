/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

/**
 * Node-luokka, node tietää paikkansa, arvonsa, etäisyyden maaliin sekä
 * lisäksi sen onko nodessa jo käyty
 * @author Miika
 */
public class Node {
    
    private int x;
    private int y;
    private int arvo;
    private boolean visited;
    private int distanceToGoal;
    
    
    /**
     * Konstruktori
     * @param x x-koordinaatti
     * @param y y-koordinaatti 
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
        this.visited  = false;
        this.distanceToGoal = (30 - x) + (40 - y);
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistanceToGoal() {
        return distanceToGoal;
    }

    public void setDistanceToGoal(int distanceToGoal) {
        this.distanceToGoal = distanceToGoal;
    }
    
    
    
}
