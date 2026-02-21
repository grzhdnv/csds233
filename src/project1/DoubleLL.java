package project1;

import java.util.Iterator;

/**
 * Class implementing a doubly linked list
 * @param <T> Generic for data type
 * @author Mikhail Grazhdanov
 */
public class DoubleLL<T> implements Iterable<T> {

    // Fields to store pointers and track list length
    private DLNode<T> head;
    private DLNode<T> tail;
    private DLNode<T> current;
    private int length;

    // --- constructors --- //

    /**
     * Initialize an empty list
     */
    public DoubleLL() {
        head = tail = current = null;
        length = 0;
    }

    /**
     * Initialize a list with a node
     * @param node Node
     */
    public DoubleLL(DLNode<T> node) {
        head = tail = current = node;
        length = 1;
    }

    // --- getters and setters and modifiers for class fields--- //

    public void setHead(DLNode<T> head) {
        this.head = head;
    }

    public DLNode<T> getHead() {
        return head;
    }

    public void setTail(DLNode<T> tail) {
        this.tail = tail;
    }

    public DLNode<T> getTail() {
        return tail;
    }

    public void setCurrent(DLNode<T> node) {
        current = node;
    }

    public DLNode<T> getCurrent() {
        return current;
    }

    public void moveForward() {
        if (getCurrent().hasNext())
            setCurrent(getCurrent().getNext());
    }

    public void moveBack() {
        if (getCurrent().hasPrevious())
            setCurrent(getCurrent().getPrevious());
    }

    public int getLength() {
        return length;
    }

    /**
     * Update length of the list
     * @param i Increment, expected 1 or -1
     */
    public void changeLength(int i) {
        length += i;
    }

    // --- adding and removing nodes --- //

    /**
     * Add node to the end of the list
     * @param node Node to add
     */
    public void append(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            getTail().bind(node);
            setTail(node);
            changeLength(1);
        }
    }

    /**
     * Add node to the start of the list
     * @param node Node to add
     */
    public void prepend(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            node.bind(getHead());
            setHead(node);
            changeLength(1);
        }
    }

    /**
     * Insert node after the current node
     * @param node Node to insert
     */
    public void insert(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            if (getCurrent().getNext() != null)
                node.bind(getCurrent().getNext());
            getCurrent().bind(node);
            changeLength(1);
        }
    }

    /**
     * Insert a copy of a current node to the end of the list
     */
    public void repeatToEnd() {
        if (getLength() == 0)
            System.out.println("Error! Empty list!");
        else
            append(getCurrent());
    }


    /**
     * Remove current node
     */
    public void remove() {
        removeNode(getCurrent());
    }

    /**
     * Remove node at given position
     * @param position Position of node to remove
     */
    public void removeAt(int position) {
        DLNode<T> toRemove = getHead();
        int i = 1;
        while (i < position) {
            toRemove = toRemove.getNext();
            i++;
        }
        removeNode(toRemove);
        changeLength(-1);
    }

    // --- Helper Functions --- //

    /**
     * Utility function, add node when list is empty
     * @param node Node to add
     */
    private void addToEmpty(DLNode<T> node) {
        setHead(node);
        setTail(node);
        setCurrent(node);
        changeLength(1);
    }

    /**
     * Utility function, handle removal logic
     * @param nodeToRemove Node to remove
     */
    private void removeNode(DLNode<T> nodeToRemove) {
        if (!nodeToRemove.hasPrevious() && !nodeToRemove.hasNext()) {
            setHead(null);
            setTail(null);
            setCurrent(null);
        } else if (!nodeToRemove.hasPrevious()) {
            setHead(nodeToRemove.getNext());
            nodeToRemove.getNext().setPrevious(null);
            if (getCurrent().equals(nodeToRemove))
                setCurrent(nodeToRemove.getNext());
        } else if (!nodeToRemove.hasNext()) {
            setTail(nodeToRemove.getPrevious());
            nodeToRemove.getPrevious().setNext(null);
            if (getCurrent().equals(nodeToRemove))
                setCurrent(nodeToRemove.getPrevious());
        } else {
            nodeToRemove.getPrevious().bind(nodeToRemove.getNext());
            if (getCurrent().equals(nodeToRemove))
                setCurrent(nodeToRemove.getPrevious());
        }
        changeLength(-1);
    }


    // --- FOR IN loop functionality --- //

    public Iterator<T> iterator() {
        return new DoubleLLIterator();
    }

    private class DoubleLLIterator implements Iterator<T> {
        private DLNode<T> cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T data = cur.getData();
            cur = cur.getNext();
            return data;
        }
    }


    /**
     * Utility (test) function, prints state of the list
     */
    public void printState() {
        if (getLength() > 0) {
            System.out.println("Head: " + getHead().getData());
            System.out.println("Tail: " + getTail().getData());
            System.out.println("Current: " + getCurrent().getData());
            System.out.println("Length: " + getLength());
            System.out.print("List nodes: ");
            for (T item : this) {
                System.out.print(item + " ");
            }
        }
        else
            System.out.println("Empty structure");
        System.out.println("\n");
    }

    /**
     * Print list data with indexes (base 1).
     */
    public void printWithIndex() {
        if (getLength() > 0) {
            DLNode<T> current = getHead();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < getLength(); i++) {
                if (current.equals(getCurrent())) {
                    sb.append(i+1).append(" * ").append(current.getData()).append(" * | ");
                } else {
                    sb.append(i+1).append(" ").append(current.getData()).append(" | ");
                }
                current = current.getNext();
            }
            System.out.println(sb);
        }
        else
            System.out.println("No data.");
    }

    /**
     * Create string representation of list data
     * @return String representation of list data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T data : this) {
            sb.append(data).append(" | ");
        }
        return sb.toString();
    }

    /**
     * Create string representation of list data starting from current node
     * @return String representation of list data starting from current node
     */
    public String toStringFromCurrent() {
        StringBuilder sb = new StringBuilder();
        DLNode<T> cur = getCurrent();
        while (cur.hasNext()) {
            sb.append(cur.getData()).append(" | ");
            cur = cur.getNext();
        }
        return sb.toString();
    }
}
