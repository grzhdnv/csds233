package week8;

public class BTreeTest {
    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<>("love");
        root.setLeft(new BinaryTreeNode<>("I"));
        root.setRight(new BinaryTreeNode<>("data structures"));


        System.out.println(root.getLeft().getElement());
        System.out.println(root.getRight().getElement());
        System.out.println(root.getElement());

    }
}
