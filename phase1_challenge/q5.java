import java.util.*;
public class q5 {
    public static boolean mirror(String s){
        int i =0;
        int j=s.length()-1;
        while(i<=j){
            if(i==j){
               if(s.charAt(i)=='o'){
                   return true;
               }
               else return false;
            }
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else {
                if((s.charAt(i)=='b' && s.charAt(j)=='d') || (s.charAt(i)=='d' && s.charAt(j)=='b') || (s.charAt(i)=='b' && s.charAt(j)=='d') || (s.charAt(i)=='d' && s.charAt(j)=='b') || (s.charAt(i)=='p' && s.charAt(j)=='q') || (s.charAt(i)=='q' && s.charAt(j)=='p')){
                    i++;
                    j--;
                }
                else return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans = mirror("qp");
        System.out.println(ans);
    }
}
