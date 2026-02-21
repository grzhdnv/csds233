package project1;

/**
 * Class implementing a doubly linked node
 * @param <T> Generic for data type
 * @author Mikhail Grazhdanov
 */
public class DLNode<T> {

    // Fields to store data and pointers
    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;

    // --- Constructors --- //

    /**
     * Initialize node with data
     * @param data Data for the node
     */
    public DLNode(T data) {
        this.data = data;
        this.previous = null;
        next = null;
    }

    /**
     * Initialize node with data and next node
     * @param data Data for the node
     * @param next Next node
     */
    public DLNode(T data, DLNode<T> next) {
        this.data = data;
        this.previous = null;
        this.next = next;
    }

    /**
     * Initialize node with data and previous node
     * @param previous Previous node
     * @param data Data for the node
     */
    public DLNode(DLNode<T> previous, T data) {
        this.data = data;
        this.previous = previous;
        this.next = null;
    }

    /**
     * Initialize node with data, next and previous node
     * @param next Next node
     * @param data Data for the node
     * @param previous Previous node
     */
    public DLNode(DLNode<T> previous, T data, DLNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    // --- getters and setters --- //

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(DLNode<T> next) {
        this.next = next;
    }

    public DLNode<T> getNext() {
        return next;
    }

    public void setPrevious(DLNode<T> previous) {
        this.previous = previous;
    }

    public DLNode<T> getPrevious() {
        return previous;
    }


    /**
     * Check if node has next node
     * @return true if next node exists, otherwise false
     */
    public boolean hasNext() {
        return getNext() != null;
    }

    /**
     * Check if node has previous node
     * @return true if previous node exists, otherwise false
     */
    public boolean hasPrevious() {
        return getPrevious() != null;
    }

    /**
     * Links two nodes
     * @param next Node to be linked to, goes after "this" node
     */
    public void bind(DLNode<T> next) {
        this.setNext(next);
        next.setPrevious(this);
    }

}
