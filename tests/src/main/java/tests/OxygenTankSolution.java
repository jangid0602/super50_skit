public class OxygenTankSolution {
    private static String simulateReactions(String s) {
        StringBuilder result = new StringBuilder(s);
        boolean flag = false;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            char c1 = result.charAt(i);
            char c2 = result.charAt(i + 1);
            if (Math.abs(c2 - c1) == 32) {
                result.delete(i, i + 2);
                i -= 2;
                n -= 2;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "aaaaaAaaAAAAA";
        System.out.println(simulateReactions(input));
    }
}
