package project1;

import java.util.Iterator;

public class DoubleLL<T> implements Iterable<T>{

    private DLNode<T> head;
    private DLNode<T> tail;
    private DLNode<T> current;
    int length;

    // --- constructors --- //

    public DoubleLL() {
        head = tail = current = null;
        length = 0;
    }

    public DoubleLL(DLNode<T> node) {
        head = tail = current = node;
        length = 1;
    }

    // --- getters and setters --- //

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

    public void changeLength(int i) {
        length += i;
    }

    // --- adding and removing nodes --- //

    private void addToEmpty(DLNode<T> node) {
        setHead(node);
        setTail(node);
        setCurrent(node);
        changeLength(1);
    }

    public void append(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            getTail().bind(node);
            setTail(node);
            changeLength(1);
        }
    }

    public void prepend(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            node.bind(getHead());
            setHead(node);
            changeLength(1);
        }
    }

    public void insert(DLNode<T> node) {
        if (getLength() == 0) {
            addToEmpty(node);
        } else {
            node.bind(getCurrent().getNext());
            getCurrent().bind(node);
            changeLength(1);
        }
    }

    public void repeatTail() {
        if (getLength() == 0)
            System.out.println("Error! Empty list!");
        append(getTail());
    }

    // removes given node
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

    // removes current node
    public void remove() {
        removeNode(getCurrent());
    }

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

    public void printState() {
        System.out.println("Head: " + getHead().getData());
        System.out.println("Tail: " + getTail().getData());
        System.out.println("Current: " + getCurrent().getData());
        System.out.println("Length: " + getLength());
        System.out.print("List nodes: ");
        for (T item : this) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
