package week8;

public class BinaryTreeNode<T> {
    private T element;

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T initElement, BinaryTreeNode<T> initLeft, BinaryTreeNode<T> initRight) {
        element = initElement;
        left = initLeft;
        right = initRight;
    }
    public BinaryTreeNode(T initElement) {
        element = initElement;
        left = null;
        right = null;
    }
    public BinaryTreeNode(){
        left = right = null;
    }

    public void setElement(T element ) {
        this.element = element;
    }

    public T getElement() {
        return this.element;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    //Returns the height of the binary tree rooted at "root"
    //Post-order traversal
    public static <T> int getHeight(BinaryTreeNode<T> root){

        if (root == null)
            return 0;
        int lh = getHeight(root.getLeft());
        int rh = getHeight(root.getRight());
        if (lh > rh)
            return lh + 1;
        else
            return rh + 1;
    }



    // FILL IN THE FOLLOWING FUNCTIONS

    //Returns the number of nodes in the binary tree rooted at "root"
    //Post-order traversal
    public static <T> int getNumNodes(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        return 1 + getNumNodes(root.getLeft()) + getNumNodes(root.getRight());
    }

    //Returns true if this BinaryTreeNode is a leaf node
    public boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }

    //Returns the number of leaf nodes in the tree rooted at "root"
    //Post-order traversal
    public static <T> int getNumLeaves(BinaryTreeNode<T> root) {
        if (root == null)
            return 0;
        if (root.isLeaf())
            return 1;
        return getNumLeaves(root.getLeft()) + getNumLeaves(root.getRight());
    }

}
