
/*
 * @filename = Traveler Class 
 * @description - calculating max cities to trael without becoming energy neagtive 
 * @author - Tanu Shree Jangid 
 */

import java.io.*;

public class Traveler{

    public static int solve(int[] nums){
        int count = 0 ; 
        int initialenergy = 10 ;

        for(int i = 0 ; i< nums.length; i++){
           initialenergy = initialenergy - nums[i];
           
            
             if(initialenergy <=0){
                return  count ;
            }
            count++;
        }
        return count ;
    }




public static void main(String[] args){

    Console conn = System.console();
    System.out.println("enter the size ");
    int size = Integer.parseInt(conn.readLine());

    int nums[] = new int[size];
    System.out.println("enter the values ");
    for(int i = 0 ; i< nums.length ;i++){
        nums[i] = Integer.parseInt(conn.readLine());
    }

     int result = solve(nums);
     System.out.println(" result is " + result);
}
}