/**
 * @Filename-LeakyBucket.java
 * @Description-Implement a LeakyBucket class that simulates a network buffer
 * @Author-Aditya Virmani
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LeakyBucket {
    private int capacity;
    private int size;
    private Node front;
    private Node rear;

    public LeakyBucket(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (size == capacity) {
            System.out.println("Dropped: " + front.data);
            front = front.next;
            size--;
        }
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int[] process(int k) {
        int n = Math.min(k, size);
        int[] processed = new int[n];

        for (int i = 0; i < n; i++) {
            processed[i] = front.data;
            front = front.next;
            size--;
        }
        if (front == null)
            rear = null;

        return processed;
    }

    public void printQueue() {
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeakyBucket bucket = new LeakyBucket(3); // capacity 3

        bucket.enqueue(10);
        bucket.enqueue(20);
        bucket.enqueue(30);
        bucket.printQueue(); // Queue: 10 20 30

        bucket.enqueue(40); // 10 will be dropped
        bucket.printQueue(); // Queue: 20 30 40

        int[] processed = bucket.process(2); // process 2 items
        System.out.print("Processed: ");
        for (int x : processed)
            System.out.print(x + " ");
        System.out.println();

        bucket.printQueue(); // Queue: 40
    }
}
