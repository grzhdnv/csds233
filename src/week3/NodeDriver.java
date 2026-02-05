package week3;

/**
 * A class to manipulate IntNode list
 * @author Mikhail Grazhdanov
 */
public class NodeDriver {

    /**
     * Insert node at the end of the list
     * @param head first node of the list
     * @param item data value to insert
     * @return head node
     */
    public static IntNode insertNode(IntNode head, int item) {

        IntNode pos = head;

        while (pos != null && pos.getNext() != null) {
            pos = pos.getNext();
        }

        if (pos != null)
            pos.setNext(new IntNode(item));
        else
            head = new IntNode(item);

        return head;
    }

    /**
     * Prints values of a linked list
     * @param head first node
     */
    public static void printList(IntNode head) {
//        if (head != null) {
//                System.out.println(head.getData());
//            while (head.getNext() != null) {
//                System.out.println(head.getNext().getData());
//                head = head.getNext();
//            }
//        }

        IntNode current = head;
        if (current != null) {
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        } else
            System.out.println("The list is empty");
    }

    public static void main(String[] args) {

        IntNode list = NodeDriver.insertNode(
                NodeDriver.insertNode(
                        NodeDriver.insertNode(
                                NodeDriver.insertNode(null, 25), 37), 42), 15);

        NodeDriver.printList(list);

    }
}
