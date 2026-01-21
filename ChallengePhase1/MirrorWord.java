package ChallengePhase1;

import java.util.HashMap;
import java.util.Map;

public class MirrorWord {
    public static boolean isMirrorWord(String word , Map<Character,Character> mirrorPairs){
        int length = word.length();
        return checkMirrorWord(word , mirrorPairs , 0 , length-1);
    }
    private static boolean checkMirrorWord(String word , Map<Character,Character> mirrorPairs , int left , int right){
        // Base case
        if(left>right) return true;
        // Check current pointers
        if(!mirrorPairs.containsKey(word.charAt(left)) || mirrorPairs.get(word.charAt(left)) != word.charAt(right)) return false;
        // Recursive call
        return checkMirrorWord(word, mirrorPairs, left+1, right-1);
    }

    public static void main(String[] args) {
        Map<Character,Character> mirrorPairs = new HashMap<>();
        mirrorPairs.put('b', 'd');
        mirrorPairs.put('d', 'b');
        mirrorPairs.put('p', 'q');
        mirrorPairs.put('q', 'p');
        mirrorPairs.put('s', 's');
        mirrorPairs.put('x', 'x');
        mirrorPairs.put('z', 'z');
        mirrorPairs.put('o', 'o');

        System.out.println(isMirrorWord("oofoo" , mirrorPairs));

    }
}
