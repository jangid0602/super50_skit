import java.util.Scanner;

/**
 * @Filename-Transpose2DLinkedList.java
 * @Description-This transposes the 2D linked list.
 * @Author-Aditya Virmani
 */
class Node {
    int val;
    Node right;
    Node down;

    Node(int val) {
        this.val = val;
        this.right = null;
        this.down = null;
    }
}

public class Transpose2DLinkedList {
    public static Node transpose(Node head) {
        if (head == null)
            return null;

        Node row = head;
        while (row != null) {
            Node col = row;
            while (col != null) {
                // Swap
                Node temp = col.right;
                col.right = col.down;
                col.down = temp;

                col = col.right;
            }
            row = row.down;
        }

        return head;
    }

    public static void print2DList(Node head) {
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

    public static Node create2DList(int[][] arr) {
        if (arr.length == 0)
            return null;

        int rows = arr.length;
        int cols = arr[0].length;

        Node[][] nodes = new Node[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodes[i][j] = new Node(arr[i][j]);
            }
        }

        // Link nodes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols)
                    nodes[i][j].right = nodes[i][j + 1];
                if (i + 1 < rows)
                    nodes[i][j].down = nodes[i + 1][j];
            }
        }

        return nodes[0][0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        int[][] arr = new int[row][col];
        System.out.println("Enter elements row-wise:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        Node head = create2DList(arr);

        System.out.println("\nOriginal 2D Linked List:");
        print2DList(head);

        head = transpose(head);

        System.out.println("\nTransposed 2D Linked List:");
        print2DList(head);
    }
}
        