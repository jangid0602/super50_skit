class Node {
    int val;
    Node right;
    Node down;

    Node(int v) {
        val = v;
        right = down = null;
    }
}

public class TwoDLinkedList {

    public static Node build(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        Node[][] grid = new Node[rows][cols];

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = new Node(matrix[r][c]);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (c + 1 < cols)
                    grid[r][c].right = grid[r][c + 1];

                if (r + 1 < rows)
                    grid[r][c].down = grid[r + 1][c];
            }
        }
        return grid[0][0];
    }

    public static Node transpose(Node head) {
        if (head == null) return null;
        
        // To transpose, we need to swap right and down pointers for all nodes
        // But we must traverse using original structure before swapping
        // Solution: traverse row by row, storing next row start before modifying pointers
        
        Node rowStart = head;
        while (rowStart != null) {
            // Store the start of next row before we modify pointers
            Node nextRowStart = rowStart.down;
            
            Node current = rowStart;
            while (current != null) {
                // Store original right before swapping
                Node originalRight = current.right;
                
                // Swap right and down pointers
                Node temp = current.right;
                current.right = current.down;
                current.down = temp;
                
                // Move to next node in row using stored original right
                current = originalRight;
            }
            
            // Move to next row using stored next row start
            rowStart = nextRowStart;
        }
        
        return head;
    }

    public static void print(Node head) {

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
}
