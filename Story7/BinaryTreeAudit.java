import java.util.Scanner;
/*
discription: This program selects departments in a binary tree (no two with direct parent-child) to maximize total efficiency.
author: Aman Jeet Singh
*/

public class BinaryTreeAudit {

    static int n;
    static Integer[] eff;
    static long[] include;
    static long[] exclude;

    static void dfs(int node) {
        if (node >= n || eff[node] == null) return;
        int left = 2 * node + 1;
        int right = 2 * node + 2;
        dfs(left);
        dfs(right);
        long incChild = 0;
        long excChild = 0;
        if (left < n && eff[left] != null) {
            incChild += exclude[left];
            excChild += Math.max(include[left], exclude[left]);
        }
        if (right < n && eff[right] != null) {
            incChild += exclude[right];
            excChild += Math.max(include[right], exclude[right]);
        }
        include[node] = eff[node] + incChild;
        exclude[node] = excChild;
    }

    static long maxEfficiency(Integer[] values) {
        n = values.length;
        eff = values;
        include = new long[n];
        exclude = new long[n];
        for (int i = 0; i < n; i++) {
            if (eff[i] != null) {
                include[i] = eff[i];
                exclude[i] = 0;
            }
        }
        dfs(0);
        return Math.max(include[0], exclude[0]);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of nodes (include nulls as -1 in list): ");
        int size = scan.nextInt();
        Integer[] values = new Integer[size];
        System.out.print("Enter node values (space separated, -1 for null): ");
        for (int i = 0; i < size; i++) {
            int v = scan.nextInt();
            values[i] = (v == -1) ? null : v;
        }

        System.out.println();
        System.out.print("Tree (level order): ");
        for (int i = 0; i < size; i++) {
            System.out.print(values[i] == null ? "null" : values[i]);
            if (i < size - 1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("Maximum total efficiency: " + maxEfficiency(values));
        scan.close();
    }
}
