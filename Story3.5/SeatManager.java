import java.util.*;
/**
 * @Filename-DigitalLibrary.java
 * @Description-Design a concert ticket system 
 * @Author-Anushka Kumawat
 **/

class Solve {

    String concert(String[][] arr) {
        Set<String> bookedSeats = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            String customer = arr[i][0];
            String seat = arr[i][1];

            if (bookedSeats.contains(seat)) {
                return customer;
            }

            bookedSeats.add(seat);
        }

        return "-1";
    }
}

public class SeatManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of requests: ");
        int n = sc.nextInt();

        String[][] arr = new String[n][2];

        System.out.println("Enter CustomerID and SeatNumber:");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }

        Solve s = new Solve();
        String result = s.concert(arr);

        System.out.println("Output: " + result);
    }
}
