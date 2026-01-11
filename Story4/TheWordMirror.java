/**
 * Filename- WordMirror.java
 * Description- A linguist wants to check if an ancient word is a palindrome (reads the
 same backward). Write a recursive function that compares the first and
 last characters and then calls itself on the remaining "inner" string.
 * Author - Mayank Rathore

 */
public class TheWordMirror {
    public static boolean isPalindrome(String word,int start,int end){

        if(start>=end)
        {
            return true;
        }
        if(word.charAt(start)!=word.charAt(end))
        {
            return false;
        }
        return isPalindrome(word,start+1,end-1);
    }
    public static void main(String[] args)
    {
        Input input=new Input();
        String word;
        System.out.println("enter a word to check");
        word=input.inputWord();
        boolean result;
        result=isPalindrome(word,0,word.length()-1);
        System.out.println(result);


    }


}
