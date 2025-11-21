public class CStringInterweaver {

    public static String interweave(String s1, String s2) {

        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        boolean takeFromS1 = true;

        while (i < s1.length() || j < s2.length()) {

            if (takeFromS1) {
                if (i < s1.length()) {
                    result.append(s1.charAt(i++));
                } else if (j < s2.length()) {
                    result.append(s2.charAt(j++));
                }
            } else {
                if (j < s2.length()) {
                    result.append(s2.charAt(j++));
                } else if (i < s1.length()) {
                    result.append(s1.charAt(i++));
                }
            }

            takeFromS1 = !takeFromS1;
        }

        return result.toString();
    }
}
