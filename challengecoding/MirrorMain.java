/*
 * @filename:Mirror
 * @description:this program will check the miror image
 * author :Nava 
 */
import java.util.*;
public class MirrorMain {

public static void main(String args []){
Scanner sc=new Scanner(System.in);
System.out.println("enter the string which you want to check mirror image");
String s=sc.nextLine();
Mirorr miroor=new Mirorr(s);
boolean ans=miroor.check(0,s.length()-1);
if(ans==true)System.out.println("yes this given input is mirror word");
else System.out.println("No this word is not a mirror word");  
}
}