package week8;

public class BSTNode<K extends Comparable<K>, T>{
    private K key;
    private T value;
    private BSTNode<K,T> left;
    private BSTNode<K,T> right;
    public BSTNode(K key, T value) {
        this.key = key;
        this.value = value;
    }
    public BSTNode<K,T> getLeft() {return left;}
    public void setLeft(BSTNode<K,T> left) {this.left = left;}
    public BSTNode<K,T> getRight() {return right;}
    public void setRight(BSTNode<K,T> right) {this.right = right;}
    public K getKey() {return key;}
    public void setKey(K key) {this.key = key;}
    public T getValue() {return value;}
    public void setValue(T value) {this.value = value;}

    public  BSTNode<K,T> search(BSTNode<K,T> r, K toFind){
        if (r == null)
            return null;
        if (toFind.compareTo(r.getKey()) == 0)
            return r;
        else if (toFind.compareTo(r.getKey()) < 0)
            return search(r.getLeft(), toFind);
        else
            return search(r.getRight(), toFind);
    }

    public  void insert(BSTNode<K,T> r, K k, T v){

    }

}
