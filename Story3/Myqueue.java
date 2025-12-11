import java.util.ArrayList;
import java.util.Scanner;

/**
 * @filename - Myqueue.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class LeakyBucket {
    public int capacity;
    ArrayList<Integer> list = new ArrayList<>();

    LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>(capacity);
    }

    void enqueue(int item) {
        if (list.size() == capacity) {
            list.remove(0);
        }
        list.add(item);
    }

    void process(int k) {
        int i = 0;
        while (i < k && list.size() > 0) {
            System.out.println("Processed: " + list.get(0));
            list.remove(0);
            i++;
        }
    }

}

public class Myqueue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LeakyBucket bucket = null;

        System.out.println("\n--- MENU ---");
        System.out.println("1 → Create LeakyBucket(capacity)");
        System.out.println("2 → enqueue(item)");
        System.out.println("3 → process(k)");
        System.out.println("4 → exit");
        System.out.println("------------------");

        while (true) { // infinite menu until exit
            System.out.print("\nEnter operation number: ");
            int op = sc.nextInt();

            switch (op) {

                case 1:
                    System.out.print("Enter capacity: ");
                    int cap = sc.nextInt();
                    bucket = new LeakyBucket(cap);

                    break;

                case 2:
                    if (bucket == null) {
                        System.out.println("Bucket not created yet!");
                        break;
                    }
                    System.out.print("Enter item: ");
                    int item = sc.nextInt();
                    bucket.enqueue(item);

                    break;

                case 3:
                    if (bucket == null) {
                        System.out.println("Bucket not created yet!");
                        break;
                    }
                    System.out.print("Enter k: ");
                    int k = sc.nextInt();
                    bucket.process(k);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close();
                    return; // EXIT the program

                default:
                    System.out.println("Invalid operation number!");
            }
        }
    }
}
