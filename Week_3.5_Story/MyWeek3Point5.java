import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyWeek3Point5 {

    // 1. The Cosmic Courier Challenge
    public static int minDeadline(int[] routes) {
        if (routes.length == 1) {
            return routes[0];
        }

        Arrays.sort(routes);
        return routes[routes.length - 2];
    }

    // 3. The Factory Floor Robot
    public static List<String> labelItems(int[] weights) {
        List<String> result = new ArrayList<>();

        for (int w : weights) {
            if (w % 15 == 0) {
                result.add("Hazardous");
            } else if (w % 3 == 0) {
                result.add("Heavy");
            } else if (w % 5 == 0) {
                result.add("Fragile");
            } else {
                result.add(String.valueOf(w));
            }
        }

        return result;
    }

    // 4. The Spy’s Cipher
    public static char findExtraCharacter(String original, String scrambled) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : scrambled.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c : original.toCharArray()) {
            freq.put(c, freq.get(c) - 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '\0';
    }

    //6. The Weather Station Data Aggregator
    public static int countRecordDays(String[] temperatures) {
        int recordCount = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (String temp : temperatures) {
            int current = Integer.parseInt(temp);
            if (current > maxSoFar) {
                recordCount++;
                maxSoFar = current;
            }
        }

        return recordCount;
    }

    // 7. The Midpoint Finder
    public static <T> T findMiddle(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // 5. The Concert Seat Manager
    public static String findFirstDuplicateSeat(String[][] requests) {
        Set<String> assignedSeats = new HashSet<>();

        for (String[] request : requests) {
            String customer = request[0];
            String seat = request[1];

            if (assignedSeats.contains(seat)) {
                return customer;
            }

            assignedSeats.add(seat);
        }

        return "-1";
    }

}