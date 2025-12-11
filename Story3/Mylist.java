import java.util.Scanner;

/**
 * @filename - Mylist.java
 * @description - Entry point of my code
 * @author - Anushka Kumawat
 */

class Node {
    int data;
    Node next;
    Node below;

    Node(int data) {
        this.data = data;
        next = null;
        below = null;
    }
}

class LinkedList2D {
    Node head;

    void insert(int r, int c, int value) {
        Node newNode = new Node(value);

        if (r == 0 && c == 0) {
            head = newNode;
            return;
        }
        if (r > 0) {
            Node up = head;

            for (int i = 0; i < r - 1; i++)
                up = up.below;

            for (int j = 0; j < c; j++)
                up = up.next;

            up.below = newNode;
        }

        if (c > 0) {
            Node left = head;

            for (int i = 0; i < r; i++)
                left = left.below;

            for (int j = 0; j < c - 1; j++)
                left = left.next;

            left.next = newNode;
        }
    }

    void show() {
        Node rowPtr = head;

        while (rowPtr != null) {
            Node colPtr = rowPtr;

            while (colPtr != null) {
                System.out.print(colPtr.data);
                if (colPtr.next != null)
                    System.out.print(" -> ");
                colPtr = colPtr.next;
            }
            System.out.println();

            colPtr = rowPtr;
            boolean hasBelow = false;

            while (colPtr != null) {
                if (colPtr.below != null) {
                    System.out.print("|    ");
                    hasBelow = true;
                } else {
                    System.out.print("     ");
                }
                colPtr = colPtr.next;
            }

            if (hasBelow)
                System.out.println();

            rowPtr = rowPtr.below;
        }
    }

    Node transpose(Node head) {
        if (head == null)
            return null;

        int rows = 0, cols = 0;

        Node rowPtr = head;
        while (rowPtr != null) {
            rows++;
            rowPtr = rowPtr.below;
        }

        Node colPtr = head;
        while (colPtr != null) {
            cols++;
            colPtr = colPtr.next;
        }

        Node[][] matrix = new Node[cols][rows];

        rowPtr = head;
        int r = 0;
        while (rowPtr != null) {
            colPtr = rowPtr;
            int c = 0;
            while (colPtr != null) {
                matrix[c][r] = new Node(colPtr.data);
                colPtr = colPtr.next;
                c++;
            }
            rowPtr = rowPtr.below;
            r++;
        }

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                if (j + 1 < rows)
                    matrix[i][j].next = matrix[i][j + 1];

                if (i + 1 < cols)
                    matrix[i][j].below = matrix[i + 1][j];
            }
        }

        return matrix[0][0];
    }

}

public class Mylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        LinkedList2D list = new LinkedList2D();

        System.out.println("Enter elements row-wise:");

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int value = sc.nextInt();
                list.insert(r, c, value);
            }
        }

        System.out.println("\n2D Linked List:");
        list.show();
        list.head = list.transpose(list.head);
        System.out.println("\n2D Linked List:");
        list.show();
    }
}
