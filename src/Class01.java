import java.util.Arrays;

public class Class01 {

    /* 01
    Write a Java program that loops through the numbers 1 to 10 (inclusive).
    If the loop iteration number is odd the program should print out “Oh my,
    that’s odd!” and if it’s even, the program should print out “Don’t even go
    there!”
     */
    public static void evenOdd() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1)
                System.out.println("Oh my,that’s odd!");
            else
                System.out.println("Don’t even go there!");
        }
    }

    /* 02
    Write a Java program that includes a method called arrayDoubler.
    arrayDoubler should take an array of floating point numbers as an
    argument and should change the values in that array to twice the current
    values in the array.
     */
    public static void doubleArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    /* 03
    In your main method, declare two int variables, assign them values, and
    print out the values. Call the swap() function with these two variables as
    their arguments. Print out the values of the variables again. What
    observations can you make about the behavior?

    [Java creates copies of primitive type arguments, so outside values are not changed.]
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /* 04
    In your main method, create an array of integers of size 2, populate the
    array with some values, print out the values stored in the array. Call the
    swapAr() function using this array, index 0, and index 1 as the arguments.
    Print out the values in the array again. What observations can you make
    about the behavior?

    [Java uses reference to object passed as parameter, and functions can change values of the object.]
     */
    public static void swapAr(int[] ar, int ixa, int ixb){
        int temp = ar[ixa];
        ar[ixa] = ar[ixb];
        ar[ixb] = temp;
    }

    /* 05
    LeetCode #1480 Running Sum of 1d Array
    Given an array nums. We define a running sum of an array as runningSum[i] =
    sum(nums[0]…nums[i]). Return the running sum of nums.
    Example 1:
        Input: nums = [1,2,3,4]
        Output: [1,3,6,10]
        Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    Example 2:
        Input: nums = [1,1,1,1,1]
        Output: [1,2,3,4,5]
        Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
    Example 3:
        Input: nums = [3,1,2,10,1]
        Output: [3,4,6,16,17]
    Constraints:
        • 1 <= nums.length <= 1000
        • -10^6 <= nums[i] <= 10^6
     */
    public static void runningSum(int[] arr) {
        if (arr.length > 1)
            for (int i = 1; i < arr.length; i++) {
                arr[i] =  arr[i-1] + arr[i];
            }
    }

    public static void main(String[] args) {

        /* Test evenOdd() */
        Class01.evenOdd();

        /* Test doubleArray() */
        double[] arr = {2.5, 3.3, 120.0};
        Class01.doubleArray(arr);
        System.out.println(Arrays.toString(arr));

        /* Test swap() */
        int a = 10;
        int b = 20;
        Class01.swap(a, b);
        System.out.println(a);
        System.out.println(b);

        /* Test swapAr */
        int[] intArr = {1, 2};
        System.out.println(Arrays.toString(intArr));
        Class01.swapAr(intArr, 0, 1);
        System.out.println(Arrays.toString(intArr));

        /* Test runningSum() */
        int[] rS1 = {1,2,3,4};
        Class01.runningSum(rS1);
        System.out.println(Arrays.toString(rS1));
        int[] rS2 = {1,1,1,1,1};
        Class01.runningSum(rS2);
        System.out.println(Arrays.toString(rS2));
        int[] rS3 = {3, 1, 2, 10, 1};
        Class01.runningSum(rS3);
        System.out.println(Arrays.toString(rS3));
    }
}
