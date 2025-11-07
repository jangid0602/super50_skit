import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Mystring {

    boolean encoded(String superString, String subString) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        int n1 = superString.length();
        int n2 = subString.length();
        for (int i = 0; i < n2; i++) {
            char s = subString.charAt(i);
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < n1; i++) {
            char s = superString.charAt(i);
            map2.put(s, map2.getOrDefault(s, 0) + 1);
            if (i >= n2) {
                char toRemove = superString.charAt(i - n2);
                map2.put(toRemove, map2.get(toRemove) - 1);
                if (map2.get(toRemove) == 0) {
                    map2.remove(toRemove);
                }
            }
            if (map2.equals(map1))
                return true;

        }
        return false;
    }

    String nonOverlappingReplace(String str, String target, String replacement) {
        int size = str.length();
        int targetLength = target.length();
        String result = "";
        int j;

        for (int i = 0; i < size; i++) {
            boolean matchFound = false;
            int tempIndex = i;
            j = 0;

            while (tempIndex < size && j < targetLength && str.charAt(tempIndex) == target.charAt(j)) {
                j++;
                tempIndex++;
            }

            if (j == targetLength)
                matchFound = true;

            if (matchFound) {
                result += replacement;
                i = tempIndex - 1;
            } else {
                result += str.charAt(i);
            }
        }
        return result;
    }

    String logCompaction(String logs) {
        String[] parts = logs.split(" ");
        int n = parts.length;

        String result = "";
        int count = 1;
        String prev = parts[0];

        for (int i = 1; i < n; i++) {
            String current = parts[i];

            if (current.equals(prev)) {
                count++;
            } else {
                result += prev + "(" + count + ") ";
                prev = current;
                count = 1;
            }
        }
        result += prev + "(" + count + ")";

        return result;
    }

    String SKUnormalisation(String str) {
        int size = str.length();
        int count = 0;
        int cnt = 1;
        String answer = "";
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == '-') {
                if (cnt == 1) {
                    if (count < 3 || count > 4)
                        return "invalid";
                } else if (cnt == 2) {
                    if (count < 4 || count > 6)
                        return "invalid";
                } else {
                    return "invalid";
                }
                count = -1;
                cnt++;
            }
            count++;
            char ch = str.charAt(i);
            if (cnt == 1 && ch != '-') {
                if ((ch >= '0' && ch <= '9')) {
                    return "invalid";
                }
            }
            if (cnt == 2 && ch != '-') {
                if (!(ch >= '0' && ch <= '9')) {
                    return "invalid";
                }
            }
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                ch = (char) (ch - 32);
            }
            answer += ch;
        }
        if (count > 2)
            return "invalid";
        else if (count == 2) {
            if (!((str.charAt(size - 2) == 'x' || str.charAt(size - 2) == 'X') &&
                    (str.charAt(size - 1) == 'l' || str.charAt(size - 1) == 'L'))) {
                return "invalid";
            }

        } else if (count == 1) {
            char ch = Character.toLowerCase(str.charAt(size - 1));
            if (ch != 'm' && ch != 'l' && ch != 's') {
                return "invalid";

            }
        }
        return answer;
    }

    String chatMessageRedaction(String str, String[] bannedWords) {

        HashSet<String> bannedSet = new HashSet<>();
        for (String word : bannedWords) {
            bannedSet.add(word.toLowerCase());
        }

        String[] words = str.split(" ");
        String answer = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String lowerWord = word.toLowerCase();

            for (String banned : bannedSet) {
                if (lowerWord.contains(banned)) {
                    int index = lowerWord.indexOf(banned);
                    String stars = "*".repeat(banned.length());

                    word = word.substring(0, index) + stars + word.substring(index + banned.length());
                    lowerWord = word.toLowerCase();
                }
            }

            answer += word;
            if (i < words.length - 1)
                answer += " ";
        }

        return answer;
    }

}
