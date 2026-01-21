/**
 * Filename - MirrorWord.java
 * Description - Find if the word can be reversed.
 * Author - Nancy Jain
 * Date - 21/01/2026
 */

public class MirrorWord {
    public static boolean Mirror(String word){
        return Reverse(word , 0 , word.length()-1);
    }
    public static boolean Reverse(String word , int start , int end){
        if(word.charAt(end) != word.charAt(start)) return false;
        if(start >= end) return true;
        if(word.charAt(start) == 'b' && word.charAt(end) == 'd' || word.charAt(start) == 'p' && word.charAt(end) == 'q' || word.charAt(start) == 's' && word.charAt(end) == 's' || word.charAt(start) == 'x' && word.charAt(end) == 'x' || word.charAt(start) == 'z' && word.charAt(end) == 'z' ||word.charAt(start) == 'o' && word.charAt(end) == 'o'){
            return Reverse(word , start++ , end--);
        }
        return false;
    }
}
