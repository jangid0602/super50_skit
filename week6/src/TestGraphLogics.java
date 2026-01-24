import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for all Week 6 graph and heap problems.
 *
 * @author Bhavya Jain
 * @date 21 Jan 2026
 */
class TestGraphLogics {

    private GraphLogics logic;

    @Nested
    class CheapestFlightTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int n = 4;
            int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 3, 100}, {0, 3, 500}};
            int src = 0, dst = 3, k = 1;
            int result = logic.findCheapestPrice(n, flights, src, dst, k);
            assertEquals(500, result);
        }

        @Test
        void testCase2() {
            int n = 3;
            int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
            int src = 0, dst = 2, k = 1;
            int result = logic.findCheapestPrice(n, flights, src, dst, k);
            assertEquals(200, result);
        }

        @Test
        void testCase3() {
            int n = 3;
            int[][] flights = {{0, 1, 100}};
            int src = 0, dst = 2, k = 1;
            int result = logic.findCheapestPrice(n, flights, src, dst, k);
            assertEquals(-1, result);
        }
    }

    @Nested
    class SafestPathTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int n = 3;
            int[][] edges = {{0, 1, 3}, {1, 2, 4}, {0, 2, 5}};
            int start = 0, end = 2;
            int result = logic.findSafestPath(n, edges, start, end);
            assertEquals(4, result);
        }

        @Test
        void testCase2() {
            int n = 2;
            int[][] edges = {{0, 1, 10}};
            int start = 0, end = 1;
            int result = logic.findSafestPath(n, edges, start, end);
            assertEquals(10, result);
        }

        @Test
        void testCase3() {
            int n = 3;
            int[][] edges = {{0, 1, 2}};
            int start = 0, end = 2;
            int result = logic.findSafestPath(n, edges, start, end);
            assertEquals(-1, result);
        }
    }

    @Nested
    class DijkstraMatrixTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int[][] matrix = {{0, 1, 4}, {1, 0, 2}, {4, 2, 0}};
            int src = 0;
            int[] result = logic.dijkstraAdjMatrix(matrix, src);
            assertArrayEquals(new int[]{0, 1, 3}, result);
        }

        @Test
        void testCase2() {
            int[][] matrix = {{0, 0}, {0, 0}};
            int src = 0;
            int[] result = logic.dijkstraAdjMatrix(matrix, src);
            assertEquals(0, result[0]);
            assertEquals(Integer.MAX_VALUE, result[1]);
        }

        @Test
        void testCase3() {
            int[][] matrix = {{0}};
            int src = 0;
            int[] result = logic.dijkstraAdjMatrix(matrix, src);
            assertArrayEquals(new int[]{0}, result);
        }
    }

    @Nested
    class KNearestServersTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int n = 3;
            int[][] edges = {{0, 1, 2}, {0, 2, 4}, {1, 2, 1}};
            int s = 0, k = 2;
            List<Integer> result = logic.kNearestServers(n, edges, s, k);
            assertEquals(List.of(0, 1), result);
        }

        @Test
        void testCase2() {
            int n = 2;
            int[][] edges = {{0, 1, 10}};
            int s = 0, k = 1;
            List<Integer> result = logic.kNearestServers(n, edges, s, k);
            assertEquals(List.of(0), result);
        }

        @Test
        void testCase3() {
            int n = 1;
            int[][] edges = {};
            int s = 0, k = 3;
            List<Integer> result = logic.kNearestServers(n, edges, s, k);
            assertEquals(List.of(0), result);
        }
    }

    @Nested
    class CycleDetectionBFSTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int n = 3;
            int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
            boolean result = logic.hasCycleBFS(n, edges);
            assertTrue(result);
        }

        @Test
        void testCase2() {
            int n = 3;
            int[][] edges = {{0, 1}, {1, 2}};
            boolean result = logic.hasCycleBFS(n, edges);
            assertFalse(result);
        }

        @Test
        void testCase3() {
            int n = 3;
            int[][] edges = {};
            boolean result = logic.hasCycleBFS(n, edges);
            assertFalse(result);
        }
    }

    @Nested
    class MaxAverageWeightTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int n = 3;
            int[][] edges = {{0, 1, 5}, {1, 2, 3}};
            int src = 0, dst = 2;
            double result = logic.maxAverageWeight(edges, src, dst);
            assertEquals(4.0, result, 0.001);
        }

        @Test
        void testCase2() {
            int n = 2;
            int[][] edges = {{0, 1, 10}};
            int src = 0, dst = 1;
            double result = logic.maxAverageWeight(edges, src, dst);
            assertEquals(10.0, result, 0.001);
        }

        @Test
        void testCase3() {
            int n = 3;
            int[][] edges = {{0, 1, 2}};
            int src = 0, dst = 2;
            double result = logic.maxAverageWeight(edges, src, dst);
            assertEquals(-1.0, result, 0.001);
        }
    }

    @Nested
    class MinCostPathTests {

        @BeforeEach
        void setUp() {
            logic = new GraphLogics();
        }

        @Test
        void testCase1() {
            int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
            int result = logic.minCostPath(grid);
            assertEquals(7, result);
        }

        @Test
        void testCase2() {
            int[][] grid = {{1, 2}, {1, 1}};
            int result = logic.minCostPath(grid);
            assertEquals(3, result);
        }

        @Test
        void testCase3() {
            int[][] grid = {{5}};
            int result = logic.minCostPath(grid);
            assertEquals(5, result);
        }
    }
}
