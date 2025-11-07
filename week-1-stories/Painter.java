

/*
 * @filename - Painter  Class 
 * @description -  Mininum time to paint the walls  
 * @author - Tanu Shree Jangid 
 */

 import java.io.*;
 import java.util.Arrays;
 public class Painter{

    public static int miniwalls(int[] time ){
        Arrays.sort(time);
        int sum = 0 ;
        for(int i = 0 ; i<= time.length - 2 ; i++){
         sum  = sum + time[i];
        }
        return sum ;

    }
    public static void main(String[] args){
        Console conn = System.console();
        System.out.println("enter the size of array ");
        int size = Integer.parseInt(conn.readLine());

        int time[] = new int[size];

        System.out.println("enter the values");
        for(int i = 0 ; i<time.length; i++)
        {
            time[i] = Integer.parseInt(conn.readLine());

        }
        int result = miniwalls(time);
        System.out.println(result);

    }
 }