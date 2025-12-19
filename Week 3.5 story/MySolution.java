/* 
 * @filename - MySolution.java
 * @description - Solutions for story3.5
 * @author - Khushi Gehlot
 */


import java.util.*;

public class MySolution {

    /* ---------- 1. Cosmic Courier ---------- */
    public int minDeadline(int[] arr) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > max) {
                secondMax = max;
                max = x;
            } else if (x > secondMax) {
                secondMax = x;
            }
        }
        return secondMax == Integer.MIN_VALUE ? max : secondMax;
    }

    /* ---------- 2. Digital Library ---------- */
    static class Book {
        String title;
        Book(String t) { title = t; }
        public String toString() { return "Book(\"" + title + "\")"; }
    }

    static class Library {
        List<Book> books = new ArrayList<>();

        void add(String title) {
            books.add(new Book(title));
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

    public void libraryDemo() {
        Library lib = new Library();
        lib.add("Data");
        lib.add("Database");
        System.out.println(lib.search("Data", false));
    }

    /* ---------- 3. Factory Floor Robot ---------- */
    public List<String> robotLabels(int[] arr) {
        List<String> res = new ArrayList<>();
        for (int x : arr) {
            if (x % 15 == 0) res.add("Hazardous");
            else if (x % 3 == 0) res.add("Heavy");
            else if (x % 5 == 0) res.add("Fragile");
            else res.add(String.valueOf(x));
        }
        return res;
    }

    /* ---------- 4. Spy’s Cipher ---------- */
    public char findExtraChar(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s2.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s1.toCharArray())
            map.put(c, map.get(c) - 1);

        for (char c : map.keySet())
            if (map.get(c) > 0) return c;

        return ' ';
    }

    /* ---------- 5. Concert Seat Manager ---------- */
    public String duplicateSeat(String[][] req) {
        Set<String> seats = new HashSet<>();

        for (String[] r : req) {
            if (seats.contains(r[1]))
                return r[0];
            seats.add(r[1]);
        }
        return "-1";
    }

    /* ---------- 6. Weather Station ---------- */
    public int recordDays(int[] arr) {
        int count = 0, max = Integer.MIN_VALUE;

        for (int x : arr) {
            if (x > max) {
                count++;
                max = x;
            }
        }
        return count;
    }

    /* ---------- 7. Midpoint Finder ---------- */
    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    public int middleNode(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    /* ---------- 8. Browser History ---------- */
    static class Browser {
        Stack<String> back = new Stack<>();
        Stack<String> forward = new Stack<>();
        String curr = null;

        void visit(String page) {
            if (curr != null) back.push(curr);
            curr = page;
            forward.clear();
        }

        void back() {
            if (!back.isEmpty()) {
                forward.push(curr);
                curr = back.pop();
            }
        }

        void forward() {
            if (!forward.isEmpty()) {
                back.push(curr);
                curr = forward.pop();
            }
        }
    }

    public void browserDemo() {
        Browser b = new Browser();
        b.visit("A");
        b.visit("B");
        b.back();
        System.out.println(b.curr);
    }
}
