package ChallengePhase1;

public class EncryptedPalindrome {
    public static boolean isEncryptedPalindrome(String word){
        int length = word.length();
        if(length==1) return true;
        int left = 0;
        int right = length-1;
        while(left<right){
            char leftCharacter = word.charAt(left);
            char rightCharacter = word.charAt(right);
            if(leftCharacter!=rightCharacter) return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isEncryptedPalindrome("vutuv"));
    }
}
