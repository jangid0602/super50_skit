// @filename - Method.java
// @description - Contains implementation of all logic used by Main.java for the assignment problems.
// @author - Kripendra Singh


import java.util.*;

public class Methods {

    // Cosmic Courier
    public static int minDeadline(int[] arr) {
        if (arr.length <= 1)
            return arr[0];
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        return secondMax == Integer.MIN_VALUE ? max : secondMax;
    }

    // Digital Library
    static class Book {
        String title;

        Book(String t) {
            title = t;
        }

        public String toString() {
            return "Book[\"" + title + "\"]";
        }
    }

    static class Library {
        List<Book> books = new ArrayList<>();

        void addBook(String t) {
            books.add(new Book(t));
        }

        void removeBook(String t) {
            for (int i = books.size() - 1; i >= 0; i--) {
                if (books.get(i).title.equals(t)) {
                    books.remove(i);
                }
            }

        }

        List<Book> search(String key, boolean exact) {
            List<Book> res = new ArrayList<>();
            for (Book b : books) {
                if (exact && b.title.equals(key))
                    res.add(b);
                else if (!exact && b.title.contains(key))
                    res.add(b);
            }
            return res;
        }
    }

    // Factory Robot
    public static List<String> robotLabels(int[] w) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < w.length; i++) {
            if (w[i] % 15 == 0)
                res.add("Hazardous");
            else if (w[i] % 3 == 0)
                res.add("Heavy");
            else if (w[i] % 5 == 0)
                res.add("Fragile");
            else
                res.add(String.valueOf(w[i]));
        }
        return res;
    }

    // Spy Cipher
    public static char findExtraChar(String original, String scrambled) {
        char res = 0;
        char[] oArr = original.toCharArray();
        char[] sArr = scrambled.toCharArray();

        // XOR all characters in original
        for (int i = 0; i < oArr.length; i++) {
            res ^= oArr[i];
        }

        // XOR all characters in scrambled
        for (int i = 0; i < sArr.length; i++) {
            res ^= sArr[i];
        }

        return res;

    }

    // Concert Seat
    public static String firstDuplicateSeat(List<String[]> req) {
        Set<String> seats = new HashSet<>();

        for (int i = 0; i < req.size(); i++) {

            String customer = req.get(i)[0];
            String seat = req.get(i)[1];

            if (seats.contains(seat)) {
                return customer;
            }
            seats.add(seat);
        }
        return "-1";
    }

    // Weather Station
    public static int recordDays(int[] t) {
        int max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] > max) {
                count++;
                max = t[i];
            }
        }
        return count;
    }

    // Midpoint Finder
    static class Node<T> {
        T data;
        Node<T> next;

        Node(T d) {
            data = d;
        }
    }

    public static <T> T findMiddle(Node<T> h) {
        Node<T> slow = h, fast = h;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    // Browser History
    static class BrowserHistory {
        Stack<String> back = new Stack<>();
        Stack<String> forward = new Stack<>();
        String curr = null;

        void visit(String p) {
            if (curr != null)
                back.push(curr);
            curr = p;
            forward.clear();
        }

        String back() {
            if (back.isEmpty())
                return null;
            forward.push(curr);
            curr = back.pop();
            return curr;
        }

        String forward() {
            if (forward.isEmpty())
                return null;
            back.push(curr);
            curr = forward.pop();
            return curr;
        }
    }
}
