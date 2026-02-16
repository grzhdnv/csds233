package project1;

import week3.IntNode;

public class DLNode<T> {

    private T data;
    private DLNode<T> next;
    private DLNode<T> previous;

    public DLNode(T data) {
        this.data = data;
        this.previous = null;
        next = null;
    }

    public DLNode(T data, DLNode<T> next) {
        this.data = data;
        this.previous = null;
        this.next = next;
    }

    public DLNode(DLNode<T> previous, T data) {
        this.data = data;
        this.previous = previous;
        this.next = null;
    }

    public DLNode(DLNode<T> previous, T data, DLNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

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

    public boolean hasNext() {
        return getNext() != null;
    }

    public boolean hasPrevious() {
        return getPrevious() != null;
    }

    public void bind(DLNode<T> next) {
        this.setNext(next);
        next.setPrevious(this);
    }

}
