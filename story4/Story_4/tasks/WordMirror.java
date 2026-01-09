package tasks;
/**
 * Filename- WordMirror.java
 * Description- A linguist wants to check if an ancient word is a palindrome (reads the 
same backward). Write a recursive function that compares the first and 
last characters and then calls itself on the remaining "inner" string. 
 * Author - Nancy Jain
 * Date - 07/01/2026
 */ 

public class WordMirror {
    public static boolean palindrome(String word){
        return check(0,word.length() - 1,word);
    }
    public static boolean check(int left ,int right , String word){
        //half traversal is done 
        if(left >= right) return true;
        // if character dosen't match
        if(word.charAt(left) != word.charAt(right)) return false;
        //recursive function to check other indices 
        return check(left+1,right-1,word);
    }
}
