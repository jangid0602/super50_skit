import java.util.*;
public class Encrypt {
    private static Map<Character,Character>togg = new HashMap<>();
    static Boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static Boolean solve(String s){
        String ans = "";

        for(char ch : s.toCharArray()){
            if(togg.containsKey(ch)){
                ans+=togg.get(ch);
                continue;
            }
            ans+=ch;
        }

        return isPalindrome(ans);

    }

    public static void main(String[] args) {
        togg.put('a','e');
        togg.put('e','i');
        togg.put('i','o');
        togg.put('o','u');
        togg.put('u','a');
        String s = "uvtvu";
        System.out.println(solve(s));
    }

}
