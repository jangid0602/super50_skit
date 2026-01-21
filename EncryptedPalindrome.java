/**
 * Filename - Encryptedpalindrome.java
 * Description - Find longest stable path
 * Author - Nancy Jain
 * Date - 21/01/2026
 */

public class EncryptedPalindrome {
    public static Boolean isPalindrome(String word){
        if(word == null) return true;
        char[] chars = word.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            if(chars[i] == 'a') chars[i] = 'e';
            else if(chars[i] == 'e') chars[i] = 'i';
            else if(chars[i] == 'i') chars[i] = 'o';
            else if(chars[i] == 'o') chars[i] = 'u';
            else if(chars[i] == 'u') chars[i] = 'a';
            else continue;
        }
        int start = 0;
        int end = word.length()-1;
        while(start <= end){
            if(word.charAt(end) != word.charAt(start)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}