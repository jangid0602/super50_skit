import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Logics to given problems in week story 3.5
 *
 * @author Bhavya Jain
 */
public class Logics {
    public int minimizeMaxDeadline(int[] routes) {
        if (routes == null || routes.length == 0) throw new NullPointerException("Input is empty!");
        if (routes.length == 1) return routes[0];
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i : routes) {
            if (i > max) {
                max2 = max;
                max = i;
            } else if (i > max2) {
                max2 = i;
            }
        }
        return max;
    }

    public String[] labelFactoryItems(int[] weights) {
        if (weights == null || weights.length == 0) throw new NullPointerException("Input is empty!");
        String[] result = new String[weights.length];
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] % 15 == 0) result[i] = "Hazardous";
            else if (weights[i] % 3 == 0) result[i] = "Heavy";
            else if (weights[i] % 5 == 0) result[i] = "Fragile";
            else result[i] = String.valueOf(weights[i]);
        }
        return result;
    }

    public char findExtraCharacter(String original, String scrambled) {
        if (scrambled.length() != original.length() + 1)
            throw new IllegalArgumentException("Invalid input: no extra character");

        int[] freq = new int[256];
        for (int i = 0; i < scrambled.length(); i++)
            freq[scrambled.charAt(i)]++;
        for (int i = 0; i < original.length(); i++)
            freq[original.charAt(i)]--;
        for (int i = 0; i < 256; i++) {
            if (freq[i] == 1)
                return (char) i;
        }
        throw new IllegalStateException("No extra character found");
    }

    public String findFirstDuplicateSeatRequester(Map<String, Integer> requests) {
        Set<Integer> bookedSeats = new HashSet<>();
        for (var request : requests.entrySet()) {
            if (bookedSeats.contains(request.getValue())) return request.getKey();
            bookedSeats.add(request.getValue());
        }
        return "-1";
    }

    public int countNewTemperatureRecords(int[] temperatures) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int temperature : temperatures) {
            if (max < temperature) {
                count++;
                max = temperature;
            }
        }
        return count;
    }

    public int findMiddleNode(ListNode<Integer> head) {
        if (head == null) throw new NullPointerException("head is null");
        ListNode<Integer> fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

}
