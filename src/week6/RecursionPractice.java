package week6;

public class RecursionPractice {

    public static int GCD(int m, int n) {
        if (n == 0)
            return m;
        return GCD(n, m % n);
    }

    public static int power(int n, int e) {
        if (e == 1)
            return n;
        return n * power(n, e - 1);
    }

    public static String reverseString(String s) {
        if (s.length() == 1)
            return s;
        else
            return(reverseString(s.substring(1)) + s.charAt(0));
    }

    public static void main(String... args) {
        System.out.println(GCD(15, 10) + "");
        System.out.println(power(2, 5));
        System.out.println(reverseString("Hello!"));
    }
}
