
/*
 * @filename  = Sum Class 
 * @description - the sum that stands out .
 * @author - Tanu Shree Jangid 
 */

import java.io.*;
import java.util.Arrays;
 public class Sum{

    public static void main(String[] args){
        Console conn = System.console();
        System.out.println("enter the size ");
        int size = Integer.parseInt(conn.readLine());

        int nums[] = new int[size];
        System.out.println("Enter  the values ");
        for(int i = 0 ; i< nums.length; i++){
            nums[i] = Integer.parseInt(conn.readLine());

        }
         
        int prefix[] = new int[size];
        int suffix[] = new int[size];
        
        // calcualting prefix sum of array 
        prefix[0] = 0;
        for(int i = 1 ; i< prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        // calculating suffix sum of array 

        suffix[size-1] = 0;
        for(int i = size-2 ; i>= 0 ; i--){
            suffix[i] = suffix[i+1] + nums[i+1];
        }

        System.out.println("prefix sum is " + Arrays.toString(prefix));
         System.out.println("suffix  sum is " + Arrays.toString(suffix));

        int index = -1 ; 
        for(int i = 0 ; i< size ; i++)
        {
            if(prefix[i] == suffix[i]){
            index = i ;
            break;
            }
        }
        System.out.println(index);
    }
 }

