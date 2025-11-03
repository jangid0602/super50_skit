
/*
 * @filename  = PairSum Class 
 * @description -  find pairsum equal to target
 * @author - Tanu Shree Jangid 
 */

import java.io.*;
public class PairSum{

    public static boolean findpair(int[] nums , int k ){
        for(int i =0  ; i<nums.length ; i++){
            for(int j = i +1 ; j<nums.length; j++){
                if(nums[i] + nums[j] == k ){
                        return true ;
                }
            }
        }
        return  false;
    }

    public static void main(String[] args){

    Console conn = System.console();
    System.out.println("enter the size ");
    int size = Integer.parseInt(conn.readLine());

    int nums[] = new int[size];
    
    System.out.println("enter the values");
    for(int i = 0 ;i <nums.length; i++ ){
    nums[i] = Integer.parseInt(conn.readLine());
    }

    System.out.println("enter the target ");
    int k = Integer.parseInt(conn.readLine());
      
    boolean found = findpair(nums, k);

    if(found)
    System.out.println(true);
    else
    System.out.println(false);

    }
}