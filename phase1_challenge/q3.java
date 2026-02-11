import java.util.*;
public class q3 {
    public static String scrubber(String s){
        if(s.length()==0)return "No string in input";
        String res = "";
        int i=1;
        while(i<s.length()){
            if(Math.abs(s.charAt(i)-s.charAt(i-1))==32){
                i+=2;
            }
            else{
                res+=s.charAt(i-1);
                i++;
            }
        }
        if(Math.abs(s.charAt(s.length()-1)-s.charAt(s.length()-2))!=32){
            res+=s.charAt(s.length()-1);
        }
        return res;
    }
    public static void main(String[] args) {
        String ans = scrubber("sSttaA");
        System.out.println(ans);
    }
}
