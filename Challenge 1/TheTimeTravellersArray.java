import java.util.Scanner;

public class TheTimeTravellersArray {
    public static void main(String[] args) {
        Scanner scannerobj = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int size = scannerobj.nextInt();
        int[] inputArray = new int[size];
        for (int i = 0; i < size; i++) {
            inputArray[i] = scannerobj.nextInt();
        }
        System.out.println("Enter Target");
        int target = scannerobj.nextInt();
        System.out.println(solver(inputArray, target));
    }

    public static int solver(int[] inputArray, int target) {
int count=0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i]==target)
                count++;
            for (int j = i + 1; j < inputArray.length; j++) {

                if (inputArray[i] + inputArray[j] == target) {
                    count++;

                }
            }
        }
        return count;
    }
}