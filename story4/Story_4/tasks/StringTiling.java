/**
 * Filename- StringTiling.java
 * Description- Given a string, write a recursive function to "compress" it by counting 
consecutive characters. For example, "AAABBC" becomes "3A2B1C". 
 * Author - Nancy Jain
 * Date - 08/01/2026
 */

package tasks;

public class StringTiling {
    public static String compress(String s){
        if(s==null || s.length() == 0) return "";
        return helper(s,0);
    }
    
    private static String helper(String s , int index){
        if(index >= s.length()) return "";
        char current = s.charAt(index);
        int count = 1;
        while(index + count < s.length() && s.charAt(index + count) == current){
            count++;
        }
        return count + "" + current + helper(s, index + count);
    }
}
