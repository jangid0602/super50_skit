/*
 * @filename:MissingPageNo
 * @description:this program will give the arraylist of string of missing Number
 * author :Navalkhurana 
 */
import java.util.*;
public class MissingPageNoMain {
  public static void main(String args[]){
    ArrayList<Integer>array=new ArrayList<>();
   Scanner scanner=new Scanner(System.in);
   System.out.println("enter the size of array");
   int n=scanner.nextInt();
   System.out.println("enter the element of array");
   for(int i=0;i<n;i++){
    int ele=scanner.nextInt();
    array.add(ele);
   }
   
  }
}
