import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Generic singly linked list node
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class myFunction {

    // Returns the second maximum value (or maximum if both are equal)
    public int getMinimumDeadline(int[] routes) {
        if (routes.length == 1) {
            return routes[0];
        }

        int maxi = routes[0];
        int secondMaxi = -1;

        for (int i = 0; i < routes.length; i++) {
            if (routes[i] >= maxi) {
                secondMaxi = maxi;
                maxi = routes[i];
            }
        }

        if (maxi == secondMaxi) {
            return maxi;
        }

        return secondMaxi;
    }

    // Categorizes items based on divisibility rules
    public void inspectItem(int[] items) {
        int size = items.length;
        String[] output = new String[size];

        for (int i = 0; i < size; i++) {
            if (items[i] % 15 == 0) {
                output[i] = "Hazardous";
            } else if (items[i] % 5 == 0) {
                output[i] = "Fragile";
            } else if (items[i] % 3 == 0) {
                output[i] = "Heavy";
            } else {
                output[i] = String.valueOf(items[i]);
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(output[i] + " ");
        }
    }

    // Finds the extra character in the scrambled string
    public char findExtraCharacter(String original, String scrambled) {
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

    // Returns customer ID if seat is already assigned
    public String findDuplicate(String[][] requests) {
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

    // Counts days when temperature sets a new record
    public int countDays(String[] temperatures) {
        int recordDays = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (String temp : temperatures) {
            int current = Integer.parseInt(temp);
            if (current > maxSoFar) {
                recordDays++;
                maxSoFar = current;
            }
        }

        return recordDays;
    }

    // Returns the middle node data using slow-fast pointer technique
    public <T> T findMid(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }
}