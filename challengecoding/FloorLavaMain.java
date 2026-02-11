/*
 * @filename:FloorLava
 * @description:this program will give the maximum Stable path
 * author :Navalkhurana 
 */
import java.util.*;
public class FloorLavaMain {
  public static void main(String args[]){
    try {
      ArrayList<Integer>array=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    System.out.println("Enter the lenght of array which you want to check");
    int n=scanner.nextInt();
    System.out.println("Eneter the array in ascending order");
    for(int i=0;i<n;i++){
      int ele=scanner.nextInt();
      array.add(ele);
    }
    System.out.println("enter the value of k");
    int k=scanner.nextInt();
    FloorLava floorLava=new FloorLava(array, k);
    int ans=floorLava.maximumLenght();
    System.out.println("the maximum length of subarray is"+ans);

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("please give right output");
    }
   
  }
}
