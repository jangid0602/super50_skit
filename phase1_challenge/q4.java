import java.util.*;
public class q4 {
    public static boolean palindrome(String s){
        int i =0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans = palindrome("ace");
        System.out.println(ans);
    }
}
