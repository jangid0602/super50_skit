import java.util.ArrayList;
import java.util.List;

public class Encrypted_Palindrome {
    public boolean check_Palindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
        }
        return true;
    }

    public boolean encrypt_message(String s){
        Character[] vowels = new Character[] {'a', 'e', 'i', 'o', 'u'};
        int size=s.length();
        for(int i=0;i<size;i++){
            
        }
    }
}
