/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package a.star;

import java.util.Random;

/**
 * Node-luokka, node tietää paikkansa, arvonsa, etäisyyden maaliin, onko se maalinode
 * sekä lisäksi sen onko nodessa jo käyty. Sisältää myös apumetodeja maalin vaihtamiseen
 * nodesta toiseen
 *
 * @author Miika
 */
public class Node {
    

    private int x;
    private int y;
    private int arvo;
    private boolean visited;
    private int distanceToGoal;
    private boolean goalNode;
    
    /**
     * Tyhjä konstruktori
     */
    public Node() {
        
    }

    /**
     * Konstruktori parametrien kanssa
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.arvo = 0;
        this.visited = false;
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

    public boolean isGoalNode() {
        return goalNode;
    }

    public void setGoalNode(boolean goalNode) {
        this.goalNode = goalNode;
    }

    /**
     * Liikuttaa maalia, käyttää apuna findGoalNode- ja setNewGoalNode-metodeita.
     * @param nodeMap kartta, jota käydään läpi
     */
    public void moveGoalNode(Node[][] nodeMap) {
        Node currentGoalNode = findGoalNode(nodeMap);
        if (currentGoalNode == null) {
            System.out.print("No goal node set! Set one before moving it!");
        } else {
            setNewGoalNode(currentGoalNode, nodeMap);
        }

    }

    /**
     * Etsii nodeMapista noden joka on maali
     * @param nodeMap kartta, josta etsitään maali
     * @return palauttaa maaliNoden
     */
    public Node findGoalNode(Node[][] nodeMap) {
        Node foundGoal;
        for (int i = 0; i < nodeMap.length; i++) {
            for (int j = 0; j < nodeMap[0].length; j++) {
                if (nodeMap[i][j].isGoalNode()) {
                    foundGoal = nodeMap[i][j];
                    return foundGoal;
                }
            }
        }
        return null;
    }

    /**
     * Asettaa maalin uuteen nodeen. Kokeilee maalin asettamista jokaiseen suuntaan
     * kunnes löytyy node jonne maali voi siirtyä
     * @param oldGoal node jossa maali ennen oli
     * @param nodeMap kartta jota käydään läpi
     */
    private void setNewGoalNode(Node oldGoal, Node[][] nodeMap) {
        oldGoal.setGoalNode(false);
        if (oldGoal.getX() + 1 < nodeMap.length) {
            nodeMap[oldGoal.getX() + 1][oldGoal.getY()].setGoalNode(true);
            return;
        }
        if (oldGoal.getY() + 1 < nodeMap[0].length) {
            nodeMap[oldGoal.getX()][oldGoal.getY() + 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getX() + 1 < nodeMap.length && oldGoal.getY() >= 0) {
            nodeMap[oldGoal.getX() + 1][oldGoal.getY() - 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getX() + 1 < nodeMap.length && oldGoal.getY() + 1 < nodeMap[0].length) {
            nodeMap[oldGoal.getX() + 1][oldGoal.getY() + 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getY() - 1 >= 0) {
            nodeMap[oldGoal.getX()][oldGoal.getY() - 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getX() - 1 >=  0 && oldGoal.getY() + 1 < nodeMap[0].length) {
            nodeMap[oldGoal.getX() - 1][oldGoal.getY() + 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getX() - 1 >= 0 && oldGoal.getY() - 1 >= 0) {
            nodeMap[oldGoal.getX() - 1][oldGoal.getY() - 1].setGoalNode(true);
            return;
        }
        if (oldGoal.getX() -1  >= 0) {
            nodeMap[oldGoal.getX() - 1][oldGoal.getY()].setGoalNode(true);
        }
    }

    /**
     * Laskee nodemapista etäisyyden nykyisestä nodesta maalinodeen.
     * Etäisyys on itseisarvo
     * @param nodeMap kartta josta etäisyys lasketaan
     * @param currentNode nykyinen node josta etäisyys lasketaan
     * @return 
     */
    public int calculateDistanceToGoal(Node currentNode, Node[][] nodeMap) {
        Node goal = findGoalNode(nodeMap);
        int distance = Math.abs(goal.getX() - currentNode.getX())  + Math.abs(goal.getY() - currentNode.getY() );
        return distance;
    }
}
