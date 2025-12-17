package Story3;

/*
 * @filename - AverageStack.java
 * @Description - Basic Operations of stack class like push , pop , top .
 * @Author - Tanu Shree Jangid 
 */

import java.util.LinkedList;

 class Transpose2DLinkedList {
    LinkedList<LinkedList<Integer>> transpose(LinkedList<LinkedList<Integer>> matrix) {
        if (matrix.isEmpty())
            return new LinkedList<>();
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        LinkedList<LinkedList<Integer>> transposed = new LinkedList<>();
        for (int i = 0; i < cols; i++)
            transposed.add(new LinkedList<>());
        for (LinkedList<Integer> row : matrix) {
            int c = 0;
            for (int val : row) {
                transposed.get(c).add(val);
                c++;
            }
        }
        return transposed;
    }

    void printMatrix(LinkedList<LinkedList<Integer>> matrix) {
        for (LinkedList<Integer> row : matrix)
            System.out.println(row);
    }
}