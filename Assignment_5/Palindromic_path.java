package Assignment_5;

import java.util.*;

public class Palindromic_path {

    // Adjacency list representation of the tree
    List<List<Integer>> adj = new ArrayList<>();

    // value[i] stores the character at node i (1-based indexing)
    char[] value;

    // Final count of valid palindromic-rearrangeable paths
    long result = 0;

    // freq[mask] = number of times this parity mask appeared on current DFS path
    Map<Integer, Integer> freq = new HashMap<>();

    public Palindromic_path() {
        Scanner sc = new Scanner(System.in);

        int nodes = sc.nextInt();

        value = new char[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            value[i] = sc.next().charAt(0);
        }

        // Tree nodes are accessed from 1 to n
        for (int i = 0; i <= nodes; i++) {
            adj.add(new ArrayList<>());
        }

        // Tree has exactly (nodes - 1) undirected edges
        for (int i = 0; i < nodes - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Represents empty path before starting DFS
        freq.put(0, 1);
    }

    void dfs(int node, int parent, int mask) {

        // Toggle the bit corresponding to current node's character
        mask ^= (1 << (value[node] - 'a'));

        // Count paths ending here with all even frequencies
        result += freq.getOrDefault(mask, 0);

        // Count paths with exactly one odd-frequency character
        for (int i = 0; i < 26; i++) {
            result += freq.getOrDefault(mask ^ (1 << i), 0);
        }

        // Add current mask to prefix frequency map
        freq.put(mask, freq.getOrDefault(mask, 0) + 1);

        // DFS traversal while preventing upward movement
        for (int next : adj.get(node)) {
            if (next != parent) {
                dfs(next, node, mask);
            }
        }

        // Backtrack to restore state for other DFS branches
        freq.put(mask, freq.get(mask) - 1);
    }

    // Initiates DFS from the root and returns total valid paths
    public long getPossiblePathCount() {
        dfs(1, 0, 0);
        return result;
    }
}
