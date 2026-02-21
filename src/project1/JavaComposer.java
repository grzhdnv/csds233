package project1;

import java.util.Scanner;
import org.jfugue.player.Player;

/**
 * Program for music composition with JFugue based on DoubleLL class
 * @author Mikhail Grazhdanov
 */
public class JavaComposer {

    // Fields to store program state
    public static DoubleLL<String> composition = new DoubleLL<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int option;
    public static String phrase;
    public static Player player = new Player();

    public static void test() {
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

    /**
     * Process user input in main menu
     * @param option User option selection, 1-3 or 0 to exit
     */
    public static void processMainMenuOption(int option) {
        switch (option) {
            case 1:
                System.out.println(Menu.edit);
                option = scanner.nextInt();
                scanner.nextLine();
                processEditOption(option);
                break;
            case 2:
                if (composition.getLength() < 2)
                    System.out.println("Navigation is not available. Add more phrases first.");
                else {
                    System.out.println(Menu.navigate);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    processNavigationOption(option);
                }
                break;
            case 3:
                if (composition.getLength() < 1) {
                    System.out.println("Playback is not available. Add more phrases first.");
                }
                else {
                    System.out.println(Menu.playback);
                    option = scanner.nextInt();
                    scanner.nextLine();
                    processPlaybackOption(option);
                }
                break;
            case 4:
                composition.printState();
                break;
            case 0:
                System.out.println("This was fun! Until next time!");
                System.exit(0);
        }
    }

    /**
     * Process user input in edit menu
     * @param option User option selection, 1-7 or 0 to return to main menu
     */
    public static void processEditOption(int option) {
        switch (option) {
            case 1: // add to end
                System.out.println("Enter a phrase to add:");
                phrase = scanner.nextLine();
                composition.append(new DLNode<>(phrase));
                break;
            case 2: // add to start
                System.out.println("Enter a phrase to add:");
                phrase = scanner.nextLine();
                composition.prepend(new DLNode<>(phrase));
                break;
            case 3: // add to current
                System.out.println("Enter a phrase to add:");
                phrase = scanner.nextLine();
                composition.insert(new DLNode<>(phrase));
                break;
            case 4: // repeat to end
                composition.repeatToEnd();
                break;
            case 5: // remove current
                composition.remove();
                break;
            case 6: // remove by position
                System.out.println("Enter a phrase position to remove:");
                int position = scanner.nextInt();
                scanner.nextLine();
                while (position > composition.getLength()) {
                    System.out.println("There are only " + composition.getLength() + " phrases in the composition! Try again:");
                    position = scanner.nextInt();
                    scanner.nextLine();
                }
                composition.removeAt(position);
                break;
            case 7: // rearrange
                composition.printWithIndex();
                System.out.println("Enter a phrase position to remove:");
                break;
            case 0: break;
        }
    }

    /**
     * Process user input in navigation menu
     * @param option User option selection, 1-2 or 0 to return to main menu
     */
    public static void processNavigationOption(int option) {
        switch (option) {
            case 1: // step forward
                if (composition.getCurrent().getNext() == null)
                    System.out.println("**Already at the last phrase!**");
                else
                    composition.moveForward();
                break;
            case 2: // step backward
                if (composition.getCurrent().getPrevious() == null)
                    System.out.println("**Already at the first phrase!**");
                else
                    composition.moveBack();
                break;
            case 0: break;
        }
    }

    /**
     * Process user input in playback menu
     * @param option User option selection, 1-3 or 0 to return to main menu
     */
    public static void processPlaybackOption(int option) {
        switch (option) {
            case 1: // play from beginning
                player.play(composition.toString());
                break;
            case 2: // play from current phrase
                player.play(composition.toStringFromCurrent());
                break;
            case 3: // play specific phrase
                player.play(composition.getCurrent().getData());
                break;
            case 0: break;
        }
    }


    /**
     * Program driver
     * @param args Arguments, not used
     */
    public static void main(String... args) {
//        test();

        System.out.println("Let's compose something cool!");

        // Program loop
        while (true) {
            System.out.println("\n");
            composition.printWithIndex(); // print composition with numbered phrases
//            composition.printState();

            // --- Main menu --- //
            System.out.println(Menu.mainMenu);
            option = scanner.nextInt();
            scanner.nextLine();
            while (option > 4) {
                System.out.println("No such option, try again");
                option = scanner.nextInt();
                scanner.nextLine();
            }
            processMainMenuOption(option);
        }
    }
}