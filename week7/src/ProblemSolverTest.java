import datastructure.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a test class for testing the implemented solutions of week 7 stories
 * test case 1: output should be 50
 * test case 5: output should be 130
 *
 * @author Bhavya Jain
 * @date 27 Jan 2026
 */
public class ProblemSolverTest {
    private ProblemSolver solver;

    @Nested
    class StartupRevenueMaxima {
        @BeforeEach
        void setUp() {
            solver = new ProblemSolver();
        }

        @Test
        void testExample1() {
            int actual = solver.getMaximumRevenue(3, new int[]{10, 50, 10});
            int expected = 50;
            assertEquals(expected, actual);
        }

        @Test
        void testExample2() {
            int actual = solver.getMaximumRevenue(7, new int[]{1, 1, 1, 1, 1, 1, 100});
            int expected = 203;
            assertEquals(expected, actual);
        }

        @Test
        void testExample3() {
            int actual = solver.getMaximumRevenue(1, new int[]{500});
            int expected = 500;
            assertEquals(expected, actual);
        }

        @Test
        void testExample4() {
            int actual = solver.getMaximumRevenue(7, new int[]{1, 1, 1, 1, 1, 50, 50});
            int expected = 103;
            assertEquals(expected, actual);
        }

        @Test
        void testExample5() {
            int actual = solver.getMaximumRevenue(8, new int[]{10, 10, 10, 10, 10, 10, 10, 100});
            int expected = 130;
            assertEquals(expected, actual);
        }

        @Test
        void testEmptyArray() {
            int actual = solver.getMaximumRevenue(0, new int[]{});
            int expected = 0;
            assertEquals(expected, actual);
        }

        @Test
        void testAllSame() {
            int actual = solver.getMaximumRevenue(8, new int[]{10, 10, 10, 10, 10, 10, 10, 10});
            int expected = 50;
            assertEquals(expected, actual);
        }

        @Test
        void testMultipleLargePeaks() {
            int actual = solver.getMaximumRevenue(14, new int[]{1, 100, 100, 1, 1, 1, 1, 100, 100, 100, 1, 1, 1, 100});
            int expected = 503;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class CodeupMentorshipMatching {
        @BeforeEach
        void setUp() {
            solver = new ProblemSolver();
        }

        @Test
        void testExample1() {
            int actual = solver.getMaximumCompatibilityScore(2, new int[][]{{10, 20}, {5, 15}});
            int expected = 25;
            assertEquals(expected, actual);
        }

        @Test
        void testExample2() {
            int actual = solver.getMaximumCompatibilityScore(3, new int[][]{{0, 0, 10}, {0, 10, 0}, {10, 0, 0}});
            int expected = 30;
            assertEquals(expected, actual);
        }

        @Test
        void testExample3() {
            int actual = solver.getMaximumCompatibilityScore(2, new int[][]{{100, 1}, {1, 1}});
            int expected = 101;
            assertEquals(expected, actual);
        }

        @Test
        void testExample4() {
            int actual = solver.getMaximumCompatibilityScore(3, new int[][]{{10, 10, 10}, {10, 10, 10}, {10, 10, 10}});
            int expected = 30;
            assertEquals(expected, actual);
        }

        @Test
        void testEmptyArray() {
            int actual = solver.getMaximumCompatibilityScore(0, new int[][]{});
            int expected = 0;
            assertEquals(expected, actual);
        }

        @Test
        void testSingleElement() {
            int actual = solver.getMaximumCompatibilityScore(1, new int[][]{{10}});
            int expected = 10;
            assertEquals(expected, actual);
        }

        @Test
        void testAllZeros() {
            int actual = solver.getMaximumCompatibilityScore(2, new int[][]{{0, 0}, {0, 0}});
            int expected = 0;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class CircularOfficeSecurity {
        @BeforeEach
        void setUp() {
            solver = new ProblemSolver();
        }

        @Test
        void testExample1() {
            int actual = solver.getMaxAuditAmount(new int[]{2, 3, 2});
            int expected = 3;
            assertEquals(expected, actual);
        }

        @Test
        void testExample2() {
            int actual = solver.getMaxAuditAmount(new int[]{1, 2, 3, 1});
            int expected = 4;
            assertEquals(expected, actual);
        }

        @Test
        void testExample3() {
            int actual = solver.getMaxAuditAmount(new int[]{10});
            int expected = 10;
            assertEquals(expected, actual);
        }

        @Test
        void testExample4() {
            int actual = solver.getMaxAuditAmount(new int[]{10, 1, 1, 10, 1});
            int expected = 20;
            assertEquals(expected, actual);
        }

        @Test
        void testEmptyArray() {
            int actual = solver.getMaxAuditAmount(new int[]{});
            int expected = 0;
            assertEquals(expected, actual);
        }

        @Test
        void testTwoElements() {
            int actual = solver.getMaxAuditAmount(new int[]{5, 10});
            int expected = 10;
            assertEquals(expected, actual);
        }

        @Test
        void testAllSame() {
            int actual = solver.getMaxAuditAmount(new int[]{5, 5, 5, 5});
            int expected = 10;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class JaipurTechHubRoutes {
        @BeforeEach
        void setUp() {
            solver = new ProblemSolver();
        }

        @Test
        void testExample1() {
            long actual = solver.countPrimes(1, 10);
            long expected = 4;
            assertEquals(expected, actual);
        }

        @Test
        void testExample2() {
            long actual = solver.countPrimes(11, 15);
            long expected = 3;
            assertEquals(expected, actual);
        }

        @Test
        void testExample3() {
            long actual = solver.countPrimes(20, 20);
            long expected = 1;
            assertEquals(expected, actual);
        }

        @Test
        void testExample4() {
            long actual = solver.countPrimes(1, 2);
            long expected = 1;
            assertEquals(expected, actual);
        }

        @Test
        void testSingleDigitPrimeSum() {
            long actual = solver.countPrimes(7, 7);
            long expected = 1;
            assertEquals(expected, actual);
        }

        @Test
        void testLargeRange() {
            long actual = solver.countPrimes(1, 1000);
            long expected = 340;
            assertEquals(expected, actual);
        }

        @Test
        void testVeryLargeRange() {
            long actual = solver.countPrimes(1000000000000L, 1000000000100L);
            long expected = 38;
            assertEquals(expected, actual);
        }
    }

    @Nested
    class BinaryTreeAudit {
        @BeforeEach
        void setUp() {
            solver = new ProblemSolver();
        }

        @Test
        void testExample1() {
            TreeNode root = new TreeNode(10, new TreeNode(2), new TreeNode(3));
            int actual = solver.getMaxEfficiency(root);
            int expected = 10;
            assertEquals(expected, actual);
        }

        @Test
        void testExample2() {
            TreeNode root = new TreeNode(1, new TreeNode(10), new TreeNode(10));
            int actual = solver.getMaxEfficiency(root);
            int expected = 20;
            assertEquals(expected, actual);
        }

        @Test
        void testExample3() {
            TreeNode left = new TreeNode(1, new TreeNode(10), new TreeNode(10));
            TreeNode right = new TreeNode(1, new TreeNode(10), new TreeNode(10));
            TreeNode root = new TreeNode(5, left, right);
            int actual = solver.getMaxEfficiency(root);
            int expected = 45;
            assertEquals(expected, actual);
        }

        @Test
        void testExample4() {
            TreeNode root = new TreeNode(100);
            int actual = solver.getMaxEfficiency(root);
            int expected = 100;
            assertEquals(expected, actual);
        }

        @Test
        void testEmptyTree() {
            int actual = solver.getMaxEfficiency(null);
            int expected = 0;
            assertEquals(expected, actual);
        }

        @Test
        void testTwoNodes() {
            TreeNode root = new TreeNode(5, new TreeNode(10), null);
            int actual = solver.getMaxEfficiency(root);
            int expected = 10;
            assertEquals(expected, actual);
        }

        @Test
        void testAllSameValues() {
            TreeNode left = new TreeNode(5, new TreeNode(5), new TreeNode(5));
            TreeNode right = new TreeNode(5, new TreeNode(5), new TreeNode(5));
            TreeNode root = new TreeNode(5, left, right);
            int actual = solver.getMaxEfficiency(root);
            int expected = 25;
            assertEquals(expected, actual);
        }

        @Test
        void testMixedLevelSelection() {

            TreeNode d = new TreeNode(100);
            TreeNode c = new TreeNode(1, null, d);
            TreeNode b = new TreeNode(100);
            TreeNode root = new TreeNode(10, b, c);

            int actual = solver.getMaxEfficiency(root);
            int expected = 200;
            assertEquals(expected, actual);
        }
    }
}
