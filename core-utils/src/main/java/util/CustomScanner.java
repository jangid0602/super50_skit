package util;

import datastructure.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Optimised Custom Scanner for IO operations
 *
 * @author Bhavya Jain
 * @date 30 Jan 2026
 */
public class CustomScanner extends BufferedReader {

    private StringTokenizer tokenizer;

    public CustomScanner(Reader in) {
        super(in);
    }

    public String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = readLine();
            if (line == null) return null;
            if (line.trim().isEmpty()) continue;
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }


    public int nextInt() throws IOException {
        long val = nextLong();
        if (val < Integer.MIN_VALUE || val > Integer.MAX_VALUE) {
            throw new InputMismatchException("Integer overflow: " + val);
        }
        return (int) val;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        int c = read();
        while (c <= ' ') {
            if (c == -1) throw new IOException("No more input");
            c = read();
        }
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            ret = ret * 10 + (c - '0');
            c = read();
        } while (c > ' ');

        return neg ? -ret : ret;
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public int[] readIntArray(int size) throws IOException {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    public int[][] readIntMatrix(int rows, int cols) throws IOException {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = nextInt();
            }
        }
        return matrix;
    }

    public int[][] readEdges(int edgeCount, int fieldsPerEdge) throws IOException {
        int[][] edges = new int[edgeCount][fieldsPerEdge];
        for (int i = 0; i < edgeCount; i++) {
            for (int j = 0; j < fieldsPerEdge; j++) {
                edges[i][j] = nextInt();
            }
        }
        return edges;
    }

    public Map<Integer, List<Integer>> readAdjGraph(int vertices, int edges) throws IOException {
        Map<Integer, List<Integer>> graph = new HashMap<>(vertices);
        for (int i = 0; i < edges; i++) {
            int u = nextInt();
            int v = nextInt();
            List<Integer> uList = graph.computeIfAbsent(u, k -> new ArrayList<>());
            uList.add(v);

            List<Integer> vList = graph.computeIfAbsent(v, k -> new ArrayList<>());
            vList.add(u);
        }
        return graph;
    }

    public Map<Integer, List<int[]>> readWeightedGraph(int vertices, int edges) throws IOException {
        Map<Integer, List<int[]>> graph = new HashMap<>(vertices);
        for (int i = 0; i < edges; i++) {
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();

            List<int[]> uList = graph.computeIfAbsent(u, k -> new ArrayList<>());
            uList.add(new int[]{v, w});

            List<int[]> vList = graph.computeIfAbsent(v, k -> new ArrayList<>());
            vList.add(new int[]{u, w});
        }
        return graph;
    }
    public TreeNode readTree() throws IOException {
        String rootVal = next();
        if (rootVal == null || rootVal.equals("-1") || rootVal.equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            String leftVal = next();
            if (leftVal == null) break;
            if (!leftVal.equals("-1") && !leftVal.equals("null")) {
                current.left = new TreeNode(Integer.parseInt(leftVal));
                queue.add(current.left);
            }

            String rightVal = next();
            if (rightVal == null) break;
            if (!rightVal.equals("-1") && !rightVal.equals("null")) {
                current.right = new TreeNode(Integer.parseInt(rightVal));
                queue.add(current.right);
            }
        }
        return root;
    }
}