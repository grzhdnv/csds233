package project1;

import org.jfugue.player.Player;

public class Musikr {

    public static void test() {

    }

    public static void main(String... args) {
        DoubleLL<String> l = new DoubleLL<>(new DLNode<>("First"));
        l.printState();
        l.append(new DLNode<>("Second"));
        l.printState();
        l.append(new DLNode<>("Third"));
        l.printState();
        l.moveForward();
        l.printState();
        l.remove();
        l.printState();
    }
}
