package a.star;

/**
 * Keko
 *
 * @author Miika
 */
public class Heap {

    private int koko;
    private Node[] keko;

    public Heap() {
        this.koko = 0;
    }

    private int leftchild(int paikka) {
        return 2 * paikka;
    }

    private int rightchild(int paikka) {
        return 2 * paikka + 1;
    }

    private int parent(int paikka) {
        return paikka / 2;
    }

    private boolean isleaf(int paikka) {
        return ((paikka > (this.koko / 2)) && (paikka <= this.koko));
    }
    
    /**
     * Vaihtaa kahden noden paikkaa päittäin
     * @param paikka1 ekan noden paikka
     * @param paikka2 tokan noden paikka
     */
    private void swap(int paikka1, int paikka2) {
        Node temp;
        
        temp = keko[paikka1];
        keko[paikka1] = keko[paikka2];
        keko[paikka2] = temp;
    }
    
    //TODO: heapify, remove max/min, find max/min
}
