
/*
 * @filename = FlipNumber Class 
 * @description - count the flip zeroes or ones 
 * @author - Tanu Shree Jangid 
 */

 import java.io.*;
 public class  FlipNumber{

    public static int solve(int[] nums){
          int count =   0 ;
        for(int i =0 ; i<nums.length; i++){
          if(nums[i] == 0 ){
                nums[i] = 1; 
                count ++;
            }
            
        }
          return count ;
    }

    public static void main(String[] args){
        Console conn = System.console();
        System.out.println("enter the size ");
        int size = Integer.parseInt(conn.readLine());

        int nums[] = new int[size];
        System.out.println("enter the values ");
        for(int i =0 ; i<nums.length; i++){
            nums[i] = Integer.parseInt(conn.readLine());
        }
        
      int result = solve(nums);

      System.out.println( " total count to filp is " +result);
    }
}

