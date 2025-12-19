import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Operations {
    int arr[] = new int[100];
    int size = 0;
    void insert(int size){
        Scanner sc = new Scanner(System.in);
        this.size = size;
        for(int i = 0; i < size; i++){
            System.out.println("Enter " + (i + 1) + "th element in array:-");
            arr[i] = Integer.parseInt(sc.next());
        }
    }

    int getMinimumDeadline(){
        if(size < 2){
            return Math.min(arr[0], arr[1]);
        }
        int maximum = arr[0];
        for (int i = 1; i < size; i++) {
            maximum = Math.max(maximum, arr[i]);
        }
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] < maximum && arr[i] > answer) {
                answer = arr[i];
            }
        }
        return answer == Integer.MIN_VALUE ? arr[0] : answer;
    }

    String[] assignLabels(){
        String result[] = new String[size];
        for(int i = 0; i < size; i++){
            if(arr[i] % 15 == 0){
                result[i] = "Hazardous";
                continue;
            }
            else if(arr[i] % 3 == 0){
                result[i] = "Heavy";
                continue;
            }
            else if(arr[i] % 5 == 0){
                result[i] = "Fragile";
                continue;
            }
            else{
                result[i] = String.valueOf(arr[i]);
            }
        }
        return result;
    }

    char getSpyCharacter(String original, String scrambled){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < original.length(); i++){
            char c = original.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < scrambled.length(); i++){
            char c = scrambled.charAt(i);
            if(!map.containsKey(c))return c;
            else {
                map.put(c, map.get(c) - 1);
            }
        }

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            if(e.getValue() != 0){
                return e.getKey();
            }
        }
        return 'a';
    }

    int getCustomerId(int[][] seat){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < seat.length; i++){
            if(!set.contains(seat[i][1])){
                set.add(seat[i][1]);
            }
            else{
                return seat[i][0];
            }
        }
        return -1;
    }

    int getRecordDays(){
        int count = 1;
        int max = arr[0];
        for(int i = 1; i < size; i++){
            if(arr[i] > max){
                count++;
                max = arr[i];
            }
        }
        return count;
    }
}
