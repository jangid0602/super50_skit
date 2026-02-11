/*
 * @filename:Oxyzen
 * @description:this program will check the pair are react and disapper
 * author :Navalkhurana 
 */
import java.util.*;
public class OxyzenTankMain {
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("enter the string which you want to check react pair exist or not");
    String input=sc.nextLine();
    if(!input.matches("[a-zA-Z]+")){
      System.out.println("please enter valid string");
      return ;
    }
    Oxyzen oxyzen=new Oxyzen(input);
    String result=oxyzen.check();
    System.out.println("string after result is"+result);
  }
}
