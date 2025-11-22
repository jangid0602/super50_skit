import java.util.Scanner;

class Node {
    int val;
    Node right;
    Node down;

    Node(int val) {
        this.val = val;
        right = null;
        down = null;
    }
}

public class Transpose2DList {

    public Node transpose(Node head) {

        if (head == null)
            return null;

        Node row = head;

        while (row != null) {
            Node col = row;

            while (col != null) {
                Node temp = col.right;
                col.right = col.down;
                col.down = temp;

                col = col.right;
            }

            row = row.down;
        }

        return head;
    }

    public static Node build2DList(int rows, int cols, Scanner sc) {

        Node[][] grid = new Node[rows][cols];

        System.out.println("Enter " + rows * cols + " values row-wise:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Value at [" + i + "][" + j + "]: ");
                grid[i][j] = new Node(sc.nextInt());
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                grid[i][j].right = grid[i][j + 1];
            }
        }

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j].down = grid[i + 1][j];
            }
        }

        return grid[0][0];
    }
    public static void print2D(Node head) {
        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                System.out.print(col.val + " ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Transpose2DList obj = new Transpose2DList();
        Node head = null;

        while (true) {

            System.out.println("\n==== MENU ====");
            System.out.println("1. Create 2D Linked List");
            System.out.println("2. Print 2D Linked List");
            System.out.println("3. Transpose 2D Linked List");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Enter number of rows: ");
                    int r = sc.nextInt();

                    System.out.print("Enter number of columns: ");
                    int c = sc.nextInt();

                    head = build2DList(r, c, sc);
                    System.out.println("2D Linked List Created Successfully!");
                    break;

                case 2:
                    if (head == null) {
                        System.out.println("List is empty. Create it first.");
                    } else {
                        System.out.println("2D Linked List:");
                        print2D(head);
                    }
                    break;

                case 3:
                    if (head == null) {
                        System.out.println("List is empty. Create it first.");
                    } else {
                        head = obj.transpose(head);
                        System.out.println("Transpose Completed!");
                    }
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
