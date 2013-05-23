package a.star;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A-Starin logiikka, eli täällä etsitään reitti ja lasketaan sen pituus
 *
 * @author Miika
 */
public class Logic {

    private char[][] map;
    private Comparator<Node> nodeComparator = new NodeComparator();

    /**
     * Konstruktori, joka alustaa Logic-olennon kartalla
     * @param map kartta, jota käytetään
     */
    public Logic(char[][] map) {
        this.map = map;
    }

    /**
     * Etsii reitin kartasta, aloitetaan kartan keskeltä
     *
     * @return palauttaa true jos reitti löytyi ja false jos ei löytynyt
     */
    public boolean findRoute() {
        int size = (this.map.length * this.map[0].length);
        PriorityQueue<Node> queue = new PriorityQueue<>(10, nodeComparator);
        Node[][] nodeMap = createNodeMap();
        Node node = nodeMap[0][0];
        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.remove();
            node.setVisited(true);
            int x = node.getX();
            int y = node.getY();

            //Tarkistetaan ollaanko maalisolmussa, jos ollaan niin palautetaan true
            if (x == 3 && y == 4) {
                return true;
            }

            //Tarkistetaan kaikki mahdolliset suunnat edetä ja lisää ne queueen
            checkUp(x, y, nodeMap, queue);
            checkUpRight(x, y, nodeMap, queue);
            checkUpLeft(x, y, nodeMap, queue);
            checkRight(x, y, nodeMap, queue);
            checkLeft(x, y, nodeMap, queue);
            checkDown(x, y, nodeMap, queue);
            checkDownLeft(x, y, nodeMap, queue);
            checkDownRight(x, y, nodeMap, queue);
        }
        return false;
    }

    /**
     * Rakentaa mapin nodeista jolloin voidaan laskea eri liikkeiden arvot
     *
     * @param map kartta josta uusi nodemappi tehdään
     * @return alustettu nodekartta
     */
    public Node[][] createNodeMap() {
        Node[][] nodeMap = new Node[this.map.length][this.map[0].length];
        for (int i = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[0].length; j++) {
                nodeMap[i][j] = new Node(i, j);  // i = x-koordinaatti ja j = y-koordinaatti
            }
        }
        return nodeMap;
    }

    /**
     * Katsoo nykyisestä nodesta ylöspäin seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi ylöspäin siirtyminen "maksaa" 10 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkUp(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x < this.map.length && x >= 0 && y + 1 < this.map[0].length && y + 1 >= 0) {
            if (this.map[x][y + 1] == '.' && nodeMap[x][y + 1].isVisited() == false) {
                Node upNode = nodeMap[x][y + 1];
                upNode.setArvo(10 + upNode.getDistanceToGoal());
                queue.add(upNode);
            }
        }
    }

    /**
     * Katsoo nykyisestä nodesta ylöspäin viistoon oikealle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi ylöspäin viistoon siirtyminen "maksaa" 14 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkUpRight(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x + 1 < this.map.length && x + 1 >= 0 && y + 1 < this.map[0].length && y + 1 >= 0) {
            if (this.map[x + 1][y + 1] == '.' && nodeMap[x + 1][y + 1].isVisited() == false) {
                Node upRightNode = nodeMap[x + 1][y + 1];
                upRightNode.setArvo(14 + upRightNode.getDistanceToGoal());
                queue.add(upRightNode);
            }
        }
    }

        /**
     * Katsoo nykyisestä nodesta ylöspäin viistoon vasemmalle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi ylöspäin viistoon vasemmalle siirtyminen "maksaa" 14 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkUpLeft(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x - 1 < this.map.length && x - 1 >= 0 && y + 1 < this.map[0].length && y + 1 >= 0) {
            if (this.map[x - 1][y + 1] == '.' && nodeMap[x - 1][y + 1].isVisited() == false) {
                Node upLeftNode = nodeMap[x - 1][y + 1];
                upLeftNode.setArvo(14 + upLeftNode.getDistanceToGoal());
                queue.add(upLeftNode);
            }
        }
    }

   /**
     * Katsoo nykyisestä nodesta oikealle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi oikealle siirtyminen "maksaa" 10 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkRight(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x + 1 < this.map.length && x + 1 >= 0 && y < this.map[0].length && y >= 0) {
            if (this.map[x + 1][y] == '.' && nodeMap[x + 1][y].isVisited() == false) {
                Node rightNode = nodeMap[x + 1][y];
                rightNode.setArvo(10 + rightNode.getDistanceToGoal());
                queue.add(rightNode);
            }
        }
    }
    
    /**
     * Katsoo nykyisestä nodesta vasemmalle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi vasemmalle siirtyminen "maksaa" 10 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkLeft(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x - 1 < this.map.length && x - 1 >= 0 && y < this.map[0].length && y >= 0) {
            if (this.map[x - 1][y] == '.' && nodeMap[x - 1][y].isVisited() == false) {
                Node leftNode = nodeMap[x - 1][y];
                leftNode.setArvo(10 + leftNode.getDistanceToGoal());
                queue.add(leftNode);
            }
        }
    }

        /**
     * Katsoo nykyisestä nodesta alaspäin seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi alaspäin siirtyminen "maksaa" 10 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkDown(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x < this.map.length && x >= 0 && y - 1 < this.map[0].length && y - 1 >= 0) {
            if (this.map[x][y - 1] == '.' && nodeMap[x][y - 1].isVisited() == false) {
                Node downNode = nodeMap[x][y - 1];
                downNode.setArvo(10 + downNode.getDistanceToGoal());
                queue.add(downNode);
            }
        }
    }
    
   /**
     * Katsoo nykyisestä nodesta alaspäin oikealle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi alaspäin oikealle siirtyminen "maksaa" 14 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkDownRight(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x + 1 < this.map.length && x + 1 >= 0 && y - 1 < this.map[0].length && y - 1 >= 0) {
            if (this.map[x + 1][y - 1] == '.' && nodeMap[x + 1][y - 1].isVisited() == false) {
                Node downRightNode = nodeMap[x + 1][y - 1];
                downRightNode.setArvo(14 + downRightNode.getDistanceToGoal());
                queue.add(downRightNode);
            }
        }
    }
  
   /**
     * Katsoo nykyisestä nodesta alaspäin vasemmalle seuraavaan ruutuun ja laskee siitä
     * arvon maalisolmuun. Yksi alaspäin vasemmalle siirtyminen "maksaa" 14 verran
     * @param x missä x-koordinaatissa ollaan tällä hetkellä
     * @param y missä y-koordinaatissa ollaan tällä hetkellä
     * @param nodeMap node kartta, josta otetaan seuraava node
     * @param queue prioriteettijono johon lisätään node
     */
    public void checkDownLeft(int x, int y, Node[][] nodeMap, PriorityQueue<Node> queue) {
        if (x - 1 < this.map.length && x - 1 >= 0 && y - 1 < this.map[0].length && y - 1 >= 0) {
            if (this.map[x - 1][y - 1] == '.' && nodeMap[x - 1][y - 1].isVisited() == false) {
                Node downLeftNode = nodeMap[x - 1][y - 1];
                downLeftNode.setArvo(14 + downLeftNode.getDistanceToGoal());
                queue.add(downLeftNode);
            }
        }
    }
}
