package Oneup.Phase1Test;

import java.util.Scanner;

public class TheMirrorWord {
    public static boolean pallindrome(int index,String s){
        if(index==s.length()/2) return true;
        if( s.charAt(index)!=s.charAt(s.length()-index-1) ) return false;

        pallindrome(index+1, s);
        return true;
        
        
        
    }
    public static void main(String[] args) {
        String s="CAR";
        Scanner sc = new Scanner(System.in);
       System.out.println( pallindrome(0,s));


   

    }
    
}
