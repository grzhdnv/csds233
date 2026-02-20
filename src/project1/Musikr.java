package project1;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.util.Scanner;

public class Musikr {

    public static DoubleLL<String> composition = new DoubleLL<>();
    public static Scanner scanner = new Scanner(System.in);
    public static int option;
    public static String phrase;

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

    public static void processMainMenuOption(int option) {
        switch (option) {
            case 1:
                System.out.println(Menu.edit);
                option = scanner.nextInt();
                scanner.nextLine();
                processEditOption(option);
                break;
            case 2:
                System.out.println(Menu.navigate);
                break;
            case 3:
                System.out.println(Menu.playback);
                break;
            case 4:
                composition.printState();
                break;
            case 0:
                System.out.println("This was fun! Until next time!");
                System.exit(0);
        }
    }

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
                composition.printData();
                System.out.println("Enter a phrase position to remove:");
                break;
            case 0:
                break;
        }
    }



    public static void main(String... args) {
//        test();

        System.out.println("Let's compose something cool!");

        // Program loop
        while (true) {
            System.out.println("\n");
            composition.printData();
            composition.printState();

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

            // --- Edit menu --- //



            // --- Navigate menu --- //





        }




    }
}