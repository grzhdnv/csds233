package week3;

/**
 * A class to manipulate IntNode list
 * @author Mikhail Grazhdanov
 */
public class NodeDriver {

    /**
     * Insert node at the front of the list
     * @param head first node of the list
     * @param item data value to insert
     * @return new inserted first node
     */
    public static IntNode insertNode(IntNode head, int item) {

        if (head == null) {
            return new IntNode(item);
        }

        return new IntNode(item, head);
    }

    /**
     * Prints values of a linked list
     * @param head first node
     */
    public static void printList(IntNode head) {
        if (head != null) {
                System.out.println(head.getData());
            while (head.getNext() != null) {
                System.out.println(head.getNext().getData());
                head = head.getNext();
            }
        }
    }

    public static void main(String[] args) {

        IntNode list = NodeDriver.insertNode(
                NodeDriver.insertNode(
                        NodeDriver.insertNode(
                                NodeDriver.insertNode(null, 25), 37), 42), 15);

        NodeDriver.printList(list);

    }
}
