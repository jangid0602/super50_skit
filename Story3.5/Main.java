import java.util.Scanner;

/**
 * @Filename-DigitalLibrary.java
 * @Description-Entry point of my code 
 * @Author-Anushka Kumawat
 **/

class Solve {
    int[] arr;

    Solve(int[] arr) {
        this.arr = arr;
    }

    int cosmicCourier() {
        int f_max = Integer.MIN_VALUE;
        int s_max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > f_max) {
                s_max = f_max;
                f_max = arr[i];
            } else if (arr[i] > s_max && arr[i] != f_max) {
                s_max = arr[i];
            }
        }
        return s_max;
    }

    void factoryRobot() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 15 == 0) {
                System.out.print("Hazardous ");
            } else if (arr[i] % 3 == 0) {
                System.out.print("Heavy ");
            } else if (arr[i] % 5 == 0) {
                System.out.print("Fragile ");
            } else {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    int weatherStation() {
        int maxi = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
                if (arr[i] == maxi) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Solve s = new Solve(arr);

        System.out.println("\nChoose operation:");
        System.out.println("1. Cosmic Courier (Second Maximum)");
        System.out.println("2. Factory Robot");
        System.out.println("3. Weather Station (Max Count)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Output: " + s.cosmicCourier());
                break;

            case 2:
                s.factoryRobot();
                break;

            case 3:
                System.out.println("Count: " + s.weatherStation());
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
