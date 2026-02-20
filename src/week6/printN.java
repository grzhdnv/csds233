package week6;

// test of recursive function
public class printN {

    public static void printNumbers(int count, int n) {
        if (count < n) {
            printNumbers(count + 1, n);
            System.out.println(count + " ");
        }
    }

    public static void main(String... args) {
        printNumbers(4, 7);
    }
}
