package week3;

public class NodeTest {

//    public void insertLast(IntNode node)

    public static void main(String[] args) {
        IntNode head = new IntNode(42);
        System.out.println(head.getData());

        IntNode aNode = new IntNode(81);
        aNode.setNext(head);
        head = aNode;
        // head = new IntNode(81, head); // in one line
        System.out.println(head.getData());
        System.out.println(head.getNext().getData());
        // insert in the middle
        head.setNext(new IntNode(39, head.getNext()));


    }
}
