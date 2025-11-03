/*
 * @filename  = SingleNumber 
 * @description - calculating  Unique number 
 * @author - Tanu Shree Jangid 
 */


import java.util.*;

public class SingleNumber {

 
    public static int solve(int[] arr) {
        int xor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ arr[i];
        }
        return xor1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size:");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the values:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int result = solve(arr);

        System.out.println("The single number is: " + result);
    }
}
