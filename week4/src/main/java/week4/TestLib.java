import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for various different scenarios in the Week 4 stories
 *
 * @author Bhavya Jain
 * @date 7 Jan 2025
 */
class TestLib {

    private LogicsLib util;

    @Nested
    class RussianDollTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void testKeyInSmallestDoll() {
            // Build nested dolls from inside out
            Doll doll1 = new Doll(1, true); // Smallest doll with key
            Doll doll2 = new Doll(2, doll1);
            Doll doll3 = new Doll(3, doll2);
            Doll doll4 = new Doll(4, doll3);
            Doll doll5 = new Doll(5, doll4); // Largest doll

            Key key = util.findKey(doll5); // Should recursively search through all dolls

            assertNotNull(key, "Key should be found");
            assertEquals("Key Found!", key.toString());
        }

        @Test
        void testSingleDollWithKey() {
            Doll singleDoll = new Doll(1, true); // Simplest case - only one doll

            Key key = util.findKey(singleDoll); // No recursion needed

            assertNotNull(key, "Key should be found in single doll");
            assertEquals("Key Found!", key.toString());
        }

        @Test
        void testKeyInMiddleDoll() {
            Doll doll1 = new Doll(1, false); // Smallest doll without key
            Doll doll2 = new Doll(2, true); // Middle doll with key
            Doll doll3 = new Doll(3, doll2);
            Doll doll4 = new Doll(4, doll3); // Outermost doll

            Key key = util.findKey(doll4); // Should stop at doll2 when key is found

            assertNotNull(key, "Key should be found in middle doll");
            assertEquals("Key Found!", key.toString());
        }

        @Test
        void testNoKeyFound() {
            Doll doll1 = new Doll(1, false); // Smallest doll without key
            Doll doll2 = new Doll(2, doll1);
            Doll doll3 = new Doll(3, doll2); // No doll contains key

            // Should throw exception when reaching innermost doll without key
            assertThrows(IllegalStateException.class, () -> util.findKey(doll3),
                    "Should throw IllegalStateException when no key is found");
        }

        @Test
        void testNullDoll() {
            // Null input should be rejected immediately
            assertThrows(IllegalArgumentException.class, () -> util.findKey(null),
                    "Should throw IllegalArgumentException when doll is null");
        }

        @Test
        void testKeyInOutermostDoll() {
            Doll doll1 = new Doll(5, true); // Key found immediately in first doll

            Key key = util.findKey(doll1); // No inner dolls to check

            assertNotNull(key, "Key should be found in outermost doll");
            assertEquals("Key Found!", key.toString());
        }
    }

    @Nested
    class ClimbStairsTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void testSingleStair() {
            int result = util.climbStairs(1);
            assertEquals(1, result);
        }

        @Test
        void testTwoStairs() {
            int result = util.climbStairs(2);
            assertEquals(2, result);
        }

        @Test
        void testThreeStairs() {
            int result = util.climbStairs(3);
            assertEquals(3, result);
        }

        @Test
        void testFourStairs() {
            int result = util.climbStairs(4);
            assertEquals(5, result);
        }

        @Test
        void testFiveStairs() {
            int result = util.climbStairs(5);
            assertEquals(8, result);
        }

        @Test
        void testMediumStaircase() {
            int result = util.climbStairs(10);
            assertEquals(89, result);
        }

        @Test
        void testLargeStaircase() {
            int result = util.climbStairs(20);
            assertEquals(10946, result);
        }

        @Test
        void testVeryLargeStaircase() {
            int result = util.climbStairs(30);
            assertEquals(1346269, result);
        }

        @Test
        void testZeroStairsThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.climbStairs(0));
        }

        @Test
        void testNegativeStairsThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.climbStairs(-1));
        }

        @Test
        void testNegativeLargeNumberThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.climbStairs(-100));
        }
    }

    @Nested
    class FamilyLegacyTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void testSimpleTwoLevelFamily() {
            Person parentA = new Person(100);
            Person childB = new Person(50);
            Person childC = new Person(50);

            parentA.addChild(childB);
            parentA.addChild(childC);

            int legacy = util.calculateLegacy(parentA);
            assertEquals(200, legacy);
        }

        @Test
        void testSinglePersonNoChildren() {
            Person person = new Person(500);

            int legacy = util.calculateLegacy(person);
            assertEquals(500, legacy);
        }

        @Test
        void testThreeLevelFamily() {
            Person grandparent = new Person(1000);
            Person parent1 = new Person(500);
            Person parent2 = new Person(300);
            Person child1 = new Person(100);
            Person child2 = new Person(50);

            grandparent.addChild(parent1);
            grandparent.addChild(parent2);
            parent1.addChild(child1);
            parent1.addChild(child2);

            int legacy = util.calculateLegacy(grandparent);
            assertEquals(1950, legacy);
        }

        @Test
        void testDeepFamilyTree() {
            Person gen1 = new Person(100);
            Person gen2 = new Person(200);
            Person gen3 = new Person(300);
            Person gen4 = new Person(400);
            Person gen5 = new Person(500);

            gen1.addChild(gen2);
            gen2.addChild(gen3);
            gen3.addChild(gen4);
            gen4.addChild(gen5);

            int legacy = util.calculateLegacy(gen1);
            assertEquals(1500, legacy);
        }

        @Test
        void testWideFamily() {
            Person parent = new Person(1000);
            Person child1 = new Person(100);
            Person child2 = new Person(200);
            Person child3 = new Person(300);
            Person child4 = new Person(400);
            Person child5 = new Person(500);

            parent.addChild(child1);
            parent.addChild(child2);
            parent.addChild(child3);
            parent.addChild(child4);
            parent.addChild(child5);

            int legacy = util.calculateLegacy(parent);
            assertEquals(2500, legacy);
        }

        @Test
        void testPersonWithZeroWealth() {
            Person parent = new Person(0);
            Person child = new Person(100);

            parent.addChild(child);

            int legacy = util.calculateLegacy(parent);
            assertEquals(100, legacy);
        }

        @Test
        void testComplexFamilyTree() {
            Person founder = new Person(5000);

            Person child1 = new Person(1000);
            Person child2 = new Person(1500);

            Person grandchild1 = new Person(500);
            Person grandchild2 = new Person(750);
            Person grandchild3 = new Person(250);

            Person greatGrandchild = new Person(100);

            founder.addChild(child1);
            founder.addChild(child2);

            child1.addChild(grandchild1);
            child1.addChild(grandchild2);

            child2.addChild(grandchild3);

            grandchild2.addChild(greatGrandchild);

            int legacy = util.calculateLegacy(founder);
            assertEquals(9100, legacy);
        }

        @Test
        void testNullPersonThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.calculateLegacy(null));
        }

        @Test
        void testLeafNodeCalculation() {
            Person child = new Person(250);

            int legacy = util.calculateLegacy(child);
            assertEquals(250, legacy);
        }
    }

    @Nested
    class WordMirrorTests {
        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void exampleTest() {
            assertTrue(util.isMirrorWord("racecar"));
        }

        @Test
        void nullTest() {
            assertThrows(IllegalArgumentException.class, () -> util.isMirrorWord(null));
        }

        @Test
        void blankTest() {
            assertTrue(util.isMirrorWord(""));
        }

        @Test
        void whiteSpacesTest() {
            assertTrue(util.isMirrorWord("  "));
        }

        @Test
        void falseTest() {
            assertFalse(util.isMirrorWord("carrace"));
        }
    }

    @Nested
    class MazeRunnerTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void exampleTest() {
            int[][] maze = new int[][]{{1, 0}, {1, 1}};
            assertTrue(util.pathExists(maze));
        }

        @Test
        void exampleRectangleHorizontalTest() {
            int[][] maze = new int[][]{
                    {1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 1},
                    {1, 0, 1, 0, 1},
                    {1, 1, 1, 0, 1}
            };
            assertFalse(util.pathExists(maze));
        }

        @Test
        void exampleRectangleVerticalTest() {
            int[][] maze = new int[][]{
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 0, 1},
                    {1, 0, 1}
            };
            assertFalse(util.pathExists(maze));
        }

        @Test
        void oneByOneTest() {
            int[][] maze = new int[][]{{1}};
            assertTrue(util.pathExists(maze));
        }

        @Test
        void nullTest() {
            int[][] maze = null;
            assertThrows(IllegalArgumentException.class, () -> util.pathExists(maze));
        }
    }

    @Nested
    class PerfectTeamTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        private List<List<String>> allSubsetsUtility(List<String> list) {
            List<List<String>> res = new ArrayList<>();
            int n = list.size();
            for (int i = 0; i < (1 << n); i++) {
                List<String> subSet = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        subSet.add(list.get(j));
                    }
                }
                res.add(subSet);
            }
            return res;
        }

        @Test
        void testEmptyList() {
            List<String> devs = List.of();
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertEquals(1, result.size());
            assertTrue(result.contains(List.of()));
        }

        @Test
        void testSingleDeveloper() {
            List<String> devs = List.of("dev");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertEquals(2, result.size());
            assertTrue(result.contains(List.of()));
            assertTrue(result.contains(List.of("dev")));
        }

        @Test
        void testTwoDevelopers() {
            List<String> devs = List.of("devA", "devB");
            List<List<String>> result = util.assemblePerfectTeam(devs);
            List<List<String>> expected = allSubsetsUtility(devs);

            assertEquals(4, result.size());
            assertEquals(new HashSet<>(expected), new HashSet<>(result));
        }

        @Test
        void testThreeDevelopers() {
            List<String> devs = List.of("devA", "devB", "devC");
            List<List<String>> result = util.assemblePerfectTeam(devs);
            List<List<String>> expected = allSubsetsUtility(devs);

            assertEquals(8, result.size());
            assertEquals(new HashSet<>(expected), new HashSet<>(result));
        }

        @Test
        void testFourDevelopers() {
            List<String> devs = List.of("Dev1", "Dev2", "Dev3", "Dev4");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertEquals(16, result.size());
            assertTrue(result.contains(List.of()));
            assertTrue(result.contains(List.of("Dev1", "Dev2", "Dev3", "Dev4")));
        }

        @Test
        void testFiveDevelopers() {
            List<String> devs = List.of("A", "B", "C", "D", "E");
            List<List<String>> result = util.assemblePerfectTeam(devs);
            List<List<String>> expected = allSubsetsUtility(devs);

            assertEquals(32, result.size());
            assertEquals(new HashSet<>(expected), new HashSet<>(result));
        }

        @Test
        void testEmptySetIncluded() {
            List<String> devs = List.of("John", "Jane");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertTrue(result.contains(List.of()));
        }

        @Test
        void testFullSetIncluded() {
            List<String> devs = List.of("X", "Y", "Z");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertTrue(result.contains(List.of("X", "Y", "Z")));
        }

        @Test
        void testSpecificSubsetsPresent() {
            List<String> devs = List.of("Red", "Blue", "Green");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            assertTrue(result.contains(List.of("Red")));
            assertTrue(result.contains(List.of("Blue")));
            assertTrue(result.contains(List.of("Green")));
            assertTrue(result.contains(List.of("Red", "Blue")));
            assertTrue(result.contains(List.of("Red", "Green")));
            assertTrue(result.contains(List.of("Blue", "Green")));
        }

        @Test
        void testNoDuplicateSubsets() {
            List<String> devs = List.of("P1", "P2", "P3");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            HashSet<List<String>> uniqueSubsets = new HashSet<>(result);
            assertEquals(result.size(), uniqueSubsets.size());
        }

        @Test
        void testPowerSetSize() {
            List<String> devs = List.of("T1", "T2", "T3", "T4", "T5", "T6");
            List<List<String>> result = util.assemblePerfectTeam(devs);

            int expectedSize = (int) Math.pow(2, devs.size());
            assertEquals(expectedSize, result.size());
        }

        @Test
        void testNullListThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.assemblePerfectTeam(null));
        }
    }

    @Nested
    class VaultCodeTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void testThreeDigitCode() {
            int[] digits = {1, 2, 3};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(6, result.size());
            assertTrue(result.contains(123));
            assertTrue(result.contains(132));
            assertTrue(result.contains(213));
            assertTrue(result.contains(231));
            assertTrue(result.contains(312));
            assertTrue(result.contains(321));
        }

        @Test
        void testSingleDigit() {
            int[] digits = {5};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(1, result.size());
            assertTrue(result.contains(5));
        }

        @Test
        void testTwoDigits() {
            int[] digits = {4, 7};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(2, result.size());
            assertTrue(result.contains(47));
            assertTrue(result.contains(74));
        }

        @Test
        void testFourDigits() {
            int[] digits = {1, 2, 3, 4};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(24, result.size());
            assertTrue(result.contains(1234));
            assertTrue(result.contains(4321));
            assertTrue(result.contains(2143));
        }

        @Test
        void testDifferentDigits() {
            int[] digits = {5, 8, 9};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(6, result.size());
            assertTrue(result.contains(589));
            assertTrue(result.contains(598));
            assertTrue(result.contains(859));
            assertTrue(result.contains(895));
            assertTrue(result.contains(958));
            assertTrue(result.contains(985));
        }

        @Test
        void testZeroIncluded() {
            int[] digits = {0, 1, 2};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(6, result.size());
            assertTrue(result.contains(12));
            assertTrue(result.contains(21));
            assertTrue(result.contains(102));
            assertTrue(result.contains(120));
            assertTrue(result.contains(201));
            assertTrue(result.contains(210));
        }

        @Test
        void testNoDuplicateCodes() {
            int[] digits = {3, 6, 9};
            List<Integer> result = util.generateVaultCodes(digits);

            HashSet<Integer> uniqueCodes = new HashSet<>(result);
            assertEquals(result.size(), uniqueCodes.size());
        }

        @Test
        void testFactorialSize() {
            int[] digits = {1, 2, 3, 4, 5};
            List<Integer> result = util.generateVaultCodes(digits);

            int expectedSize = 120; // 5! = 120
            assertEquals(expectedSize, result.size());
        }

        @Test
        void testEmptyArray() {
            int[] digits = {};
            List<Integer> result = util.generateVaultCodes(digits);

            assertTrue(result.isEmpty());
        }

        @Test
        void testNullArrayThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> util.generateVaultCodes(null));
        }

        @Test
        void testAllCodesUnique() {
            int[] digits = {2, 5, 8, 9};
            List<Integer> result = util.generateVaultCodes(digits);

            long distinctCount = result.stream().distinct().count();
            assertEquals(result.size(), distinctCount);
        }

        @Test
        void testLargerDigits() {
            int[] digits = {7, 8, 9};
            List<Integer> result = util.generateVaultCodes(digits);

            assertEquals(6, result.size());
            assertTrue(result.contains(789));
            assertTrue(result.contains(798));
            assertTrue(result.contains(879));
            assertTrue(result.contains(897));
            assertTrue(result.contains(978));
            assertTrue(result.contains(987));
        }
    }

    @Nested
    class StringTilingTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void exampleTest() {
            assertEquals("2A1B", util.tileString("AAB"));
        }

        @Test
        void nullTest() {
            assertThrows(IllegalArgumentException.class, () -> util.tileString(null));
        }

        @Test
        void bigStringTest() {
            assertEquals("1A1B1C1D1E1F1G1H", util.tileString("ABCDEFGH"));
        }

        @Test
        void singleCharacterTest() {
            assertEquals("1A", util.tileString("A"));
        }

        @Test
        void largeTilesTest() {
            assertEquals("11A9B1C3D", util.tileString("AAAAAAAAAAABBBBBBBBBCDDD"));
        }
    }

    @Nested
    class CombinationSumTests {

        @BeforeEach
        void setUp() {
            util = new LogicsLib();
        }

        @Test
        void exampleTest() {
            List<List<Integer>> expected = List.of(List.of(2, 3));
            List<List<Integer>> actual = util.findCombinations(new int[]{2, 3}, 5);
            assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
        }

        @Test
        void repetitionTest() {
            List<List<Integer>> expected = List.of(
                    List.of(2, 2, 3),
                    List.of(7)
            );
            List<List<Integer>> actual = util.findCombinations(new int[]{2, 3, 6, 7}, 7);
            assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
        }

        @Test
        void nullPricesTest() {
            assertThrows(IllegalArgumentException.class, () -> util.findCombinations(null, 5));
        }

        @Test
        void negativeBudgetTest() {
            assertThrows(IllegalArgumentException.class, () -> util.findCombinations(new int[]{2, 3}, -1));
        }

        @Test
        void emptyPricesTest() {
            List<List<Integer>> result = util.findCombinations(new int[]{}, 5);
            assertTrue(result.isEmpty(), "Result should be empty for empty prices array");
        }

        @Test
        void zeroBudgetTest() {
            List<List<Integer>> result = util.findCombinations(new int[]{1, 2, 3}, 0);
            assertTrue(result.isEmpty(), "Result should be empty when budget is zero");
        }

        @Test
        void priceTooHighTest() {
            List<List<Integer>> result = util.findCombinations(new int[]{10, 20}, 5);
            assertTrue(result.isEmpty(), "Result should be empty if all items are over budget");
        }
    }
}