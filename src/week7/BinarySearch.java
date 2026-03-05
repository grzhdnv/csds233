package week7;

public class BinarySearch {
    public static int binSearch(int[] ar, int sVal, int low, int high) {

        if (high < low)
            return -1;

        int mid = (low + high) / 2;
        if (sVal == ar[mid])
            return mid;
        else if (sVal < ar[mid])
            return binSearch(ar, sVal, low, mid-1);
        else
            return binSearch(ar, sVal, mid+1, high);
    }

    public static void main(String... args) {
        System.out.println(binSearch(new int[]{1, 3, 5, 6, 8, 9,}, 7, 0, 5));
    }
}
