import java.util.Scanner;

class Node {
    String value;
    Node next;

    Node(String value) {
        this.value = value;
        this.next = null;
    }
}

class LeakyBucket {
    private int capacity;
    private int currentSize;
    private Node front;
    private Node rear;

    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.front = null;
        this.rear = null;
    }

    public void enqueue(String item) {
        Node newNode = new Node(item);

        if (currentSize == capacity) {
            front = front.next;
            currentSize--;
            if (front == null) rear = null;
            System.out.println("Buffer full → dropping oldest packet!");
        }

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        currentSize++;
        System.out.println("Packet added: " + item);
    }

    public String[] process(int k) {
        String[] processedItems = new String[Math.min(k, currentSize)];
        int index = 0;

        while (index < k && front != null) {
            processedItems[index++] = front.value;
            front = front.next;
            currentSize--;
        }

        if (front == null) rear = null;

        return processedItems;
    }

    public void displayQueue() {
        Node temp = front;
        System.out.print("Current Buffer: [ ");

        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }

        System.out.println("]");
    }
}


public class Leaky {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter bucket capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        LeakyBucket bucket = new LeakyBucket(capacity);

        while (true) {
            System.out.println("\n----- Leaky Bucket Menu -----");
            System.out.println("1. Enqueue packet");
            System.out.println("2. Process packets");
            System.out.println("3. Display buffer");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {

                case 1:
                    System.out.print("Enter packet value: ");
                    String packet = scanner.nextLine();
                    bucket.enqueue(packet);
                    bucket.displayQueue();
                    break;

                case 2:
                    System.out.print("How many packets to process? ");
                    int k = scanner.nextInt();
                    scanner.nextLine();

                    String[] processed = bucket.process(k);

                    System.out.print("Processed Packets: [ ");
                    for (String p : processed) System.out.print(p + " ");
                    System.out.println("]");

                    bucket.displayQueue();
                    break;

                case 3:
                    bucket.displayQueue();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
