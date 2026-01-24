import java.util.*;

public class q3 {
    
    static boolean encryptedPalindRome(String str,HashMap<Character,Character> map)
    {
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);

            if(map.containsKey(ch))
            {
               sb.append(map.get(ch));
            }
            else
            {
                sb.append(ch);
            }
        }

        //palindrome check
        int i =0,j =str.length() - 1;

        while(i<j)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

     public static void main(String[] args) {
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put('a','e');
        map.put('e','i');
        map.put('i','o');
        map.put('o','u');
        map.put('u','a');
        
        String str = "vutuv";
        System.out.println(encryptedPalindRome(str, map));

    }
}
