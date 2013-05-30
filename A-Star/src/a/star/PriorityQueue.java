package a.star;

/**
 * Itse tehty prioriteettijono, josta poimitaan aina node jonka arvo on 
 * pienin. Eri operaatiot ovat noden lisääminen prioriteettijonoon, 
 * noden jonka arvo on pienin palautus, noden jonka arvo on pienin poisto ja palautus
 * @author Miika
 */
public class PriorityQueue {
    
    private int size;
    private int currentIndex = 0;
    private Node[] queue;
    
    /**
     * Konstruktori, joka tekee uuden prioriteettijonon annetun koon mukaan
     * @param size minkä kokoinen prioriteettijono tehdään
     */
    public PriorityQueue(int size) {
        this.size = size;
        this.queue = new Node[size];
    }
    
    /**
     * Lisää noden prioriteettijonoon oikeaan paikkaan
     * @param node lisättävä node
     */
    public void insert(Node node) {
        if(currentIndex + 1 >= this.queue.length) {
            doubleQueue();
        }
        
        
    }
    
    /**
     * Palauttaa prioriteettijonosta noden, jonka arvo on pienin
     */
    public Node returnMin() {
        if(this.queue[0] == null) {
            System.out.println("Queue is empty!");
            return null;
        }
        Node minNode = this.queue[0];
        return minNode;
    }
    
    /**
     * Palauttaa ja poistaa prioriteettijonosta noden, jonka arvo on pienin
     */
    public Node extractMin() {
        if(this.queue[0] == null) {
            System.out.println("Queue is empty!");
            return null;
        }
        Node minNode = this.queue[0];
        currentIndex--;
        this.queue[0] = this.queue[currentIndex];
        this.queue[currentIndex] = null;
        arrangeQueue();
        return minNode;
    }
    
    public void arrangeQueue() {
        
    }
    
    private void doubleQueue() {
        Node[] newQueue;
        newQueue = new Node[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            newQueue[i] = this.queue[i];
        }
        this.queue = newQueue;
    }
    
}
