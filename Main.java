import java.util.HashSet;

public class Main {
    public String getShiftedString(String s, int k){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z')){
                if(character >= 'A' && character <= 'Z'){
                   int asciiValue = character + k;
                    if(asciiValue >= 91){
                        asciiValue = 65 + (asciiValue - 65) - 26;
                    }
                    result += (char)asciiValue;

                }
                else{
                    int asciiValue = character + k;
                    if(asciiValue >= 123){
                        asciiValue = 97 + (asciiValue - 97) - 26;
                    }
                    result += (char)asciiValue;
                }
            }
            else{
                result += character;
                continue;
            }
        }
        return result;
    }

    public int getSubarrayCount(int[] array, int target){
        int count = 0;
        int sum = 0;
        int prev = 0;
        for(int i = 0; i < array.length;i++){
            if(sum == target){
                count++;
                continue;
            }
            if(sum > target){
                sum -= array[prev];
                if(sum == target)count++;
                prev++;
                continue;
            }
            sum += array[i];
        }
        return count;
    }
    public static void main(String[] args) {
        Main a = new Main();
        String res = a.getShiftedString("Abxx z",2);
        int array[] = {1,2,2,3,-2,5};
        int count = a.getSubarrayCount(array,5);
        System.out.println(count);
    }
}
