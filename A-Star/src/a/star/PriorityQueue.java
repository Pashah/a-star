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
        if(nodesInQueue() + 1 >= this.queue.length) {
            doubleQueue();
        }
        this.queue[this.currentIndex] = node;
        heapify(this.currentIndex);
        this.currentIndex++;
    }
    
    /**
     * Apumetodi, joka palauttaa priorityQueuen nodejen lukumäärän
     * @return Nodejen lukumäärä
     */
    public int nodesInQueue() {
        return this.currentIndex;
    }
    
    /**
     * Palauttaa priorityQueuen sizen
     * @return priorityQueuen koko
     */
    public int getSize() {
        return this.size;
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
        this.currentIndex--;
        this.queue[0] = this.queue[this.currentIndex];
        this.queue[this.currentIndex] = null;
        heapifyDown(0);
        return minNode;
    }
    
    /**
     * Vertaa nodea joka on indexissä sen vanhempaan ja jos nykyisen noden arvo on pienempi
     * niin siirtää nykyistä nodea ylöspäin "keossa"
     * @param index nykyisen noden index, jota verrataan
     */
    public void heapify(int index) {
        if(index < 0)
            return;
        int parent =(index - 1) / 2;
        if(parent < 0)
            return;
        if(this.queue[index].getArvo() < this.queue[parent].getArvo()) {
            Node temp = this.queue[index];
            this.queue[index] = this.queue[parent];
            this.queue[parent] = temp;
            heapify(parent);
        }
    }
    
    /**
     * Vertaa nodea, joka on paikassa index, sen lapsiin ja siirtää nodea jonossa
     * alaspäin jos lapset ovat pienempiä kuin itse node
     * @param index 
     */
    public void heapifyDown(int index) {
        if(index > this.currentIndex / 2 - 1)
            return;
        int childIndex = getChildIndex(index);
        Node currentNode = this.queue[index];
        if(childIndex == 0)
            return;
        if(this.queue[childIndex].getArvo() < currentNode.getArvo()) {
            Node temp = this.queue[childIndex];
            this.queue[childIndex] = currentNode;
            this.queue[index] = temp;
            heapifyDown(childIndex);
        } 
    }
    
    /**
     * Palauttaa lapsisolmun indexin. Palauttaa 0, jos lapsisolmuja ei ole.
     * Palauttaa pienimmän lapsisolmuista.
     * @param currentIndex nykyisen noden index
     * @return pienimmän lapsisolmun index
     */
    private int getChildIndex(int currentIndex) {
        int leftChild = 2 * currentIndex + 1;
        int rightChild = leftChild + 1;
        if(this.queue[rightChild] == null && this.queue[leftChild] == null)
            return 0;
        if(this.queue[rightChild] != null && this.queue[leftChild] == null) 
            return rightChild;
        if(this.queue[rightChild] == null && this.queue[leftChild] != null) 
            return leftChild;
        if(this.queue[rightChild].getArvo() < this.queue[leftChild].getArvo())
            return rightChild;
        return leftChild;
    }
    
    /**
     * Tuplaa prioriteettijonon koon
     */
    private void doubleQueue() {
        Node[] newQueue;
        newQueue = new Node[this.size * 2];
        for (int i = 0; i < this.size; i++) {
            newQueue[i] = this.queue[i];
        }
        this.size = this.size * 2;
        this.queue = newQueue;
    }
    
}
