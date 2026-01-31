/**
 * Filename - LeakyBucket.java
 * Description - Implement a LeakyBucket class simulating a network buffer.
 * Author - Nancy Jain
 */

import java.util.*;

class LeakyBucket {
    private int capacity;        
    private Queue<Integer> queue; 

    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public void enqueue(int item) {
        if (queue.size() == capacity) {
            System.out.println("Bucket full! Dropping front item: " + queue.poll());
        }
        queue.offer(item);
        System.out.println("Enqueued: " + item);
    }

    public List<Integer> process(int k) {
        List<Integer> processed = new ArrayList<>();

        for (int i = 0; i < k && !queue.isEmpty(); i++) {
            processed.add(queue.poll());
        }
        return processed;
    }
}

public class Main {
    public static int readInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.print("Invalid input! Enter again: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter bucket capacity: ");
        int cap = readInt(sc);
        LeakyBucket bucket = new LeakyBucket(cap);

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Enqueue Item");
            System.out.println("2. Process Items");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = readInt(sc);

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int item = readInt(sc);
                    bucket.enqueue(item);
                    break;

                case 2:
                    System.out.print("How many items to process? ");
                    int k = readInt(sc);
                    List<Integer> processed = bucket.process(k);
                    System.out.println("Processed Items: " + processed);
                    break;

                case 3:
                    System.out.print("Are you sure you want to exit? (1-Yes / 2-No): ");
                    int c2 = readInt(sc);
                    if (c2 == 1) {
                        System.out.println("Exiting program!");
                        return;
                    }
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
