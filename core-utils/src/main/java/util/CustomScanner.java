package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

/**
 * Custom Scanner class for various IO operations
 *
 * @author Bhavya Jain
 * @date 24 Jan 2026
 */
public class CustomScanner extends BufferedReader {
    private StringTokenizer tokenizer;

    public CustomScanner(Reader in) {
        super(in);
    }

    private void ensureTokens() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = readLine();
            if (line == null) {
                throw new IOException("No more input available");
            }
            tokenizer = new StringTokenizer(line);
        }
    }

    public String next() throws IOException {
        ensureTokens();
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        tokenizer = null;
        return readLine();
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
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            int u = nextInt();
            int v = nextInt();
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }
        return graph;
    }

    public Map<Integer, List<int[]>> readWeightedGraph(int vertices, int edges) throws IOException {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            int u = nextInt();
            int v = nextInt();
            int w = nextInt();
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[] { v, w });
            graph.computeIfAbsent(v, x -> new ArrayList<>()).add(new int[] { u, w });
        }
        return graph;
    }
}
