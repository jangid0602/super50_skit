/*
 * Filename  - build2DList.java
 * Description - You are given the head of a 2D Linked List. Each Node contains a value,
 * a right pointer (next column), and a down pointer (next row). The structure forms a grid
 * similar to a matrix. Right pointers connect nodes horizontally, and down pointers connect
 * vertically. The last node in each row/column points to null.
 * Author - Nancy Jain
 */

import java.util.*;

class Node {
    int value;
    Node right;
    Node down;

    Node(int value) {
        this.value = value;
        this.right = null;
        this.down = null;
    }
}

public class Task3 {
    public static int readInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.print("Invalid input! Enter an integer: ");
                sc.next();
            }
        }
    }

    public static Node build2DList(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Node[][] grid = new Node[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                grid[i][j] = new Node(matrix[i][j]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (j + 1 < cols)
                    grid[i][j].right = grid[i][j + 1];

                if (i + 1 < rows)
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
                System.out.print(col.value);
                if (col.right != null) System.out.print(" ");
                col = col.right;
            }
            System.out.println();
            row = row.down;
        }
    }

    public static void transpose(Node head) {

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
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        do {
            System.out.println("\n====== 2D LINKED LIST TRANSPOSE ======\n");
            System.out.println("Enter number of rows: ");
            int rows = readInt(sc);
            System.out.println("Enter number of columns: ");
            int cols = readInt(sc);
            int[][] matrix = new int[rows][cols];
            System.out.println("\nEnter matrix values:");

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Value[" + i + "][" + j + "]: ");
                    matrix[i][j] = readInt(sc);
                }
            }

            Node head = build2DList(matrix);
            System.out.println("\nOriginal 2D Linked List:");
            print2D(head);
            transpose(head);
            System.out.println("\nAfter Transpose:");
            print2D(head);

            System.out.println("\nDo you want to continue?");
            System.out.println("1. Yes");
            System.out.println("2. No (Exit)");
            System.out.println("Enter your choice: ");
            int choice = readInt(sc);
            if (choice == 2) {
                System.out.println("Exiting program! Goodbye!");
                running = false;
            }
        } while (running);
    }
}
