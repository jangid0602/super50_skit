/* 
 * @filename - MySolution.java
 * @description - Solutions for story3
 * @author - Khushi
 */


import java.util.*;

public class MySolution {

    // ==================== 1. O(1) Average Stack ====================
    public static class AverageStack {
        private Stack<Integer> stack = new Stack<>();
        private long sum = 0;

        public void push(int val) {
            stack.push(val);
            sum += val;
        }

        public int pop() {
            if (stack.isEmpty()) throw new RuntimeException("Stack empty");
            int v = stack.pop();
            sum -= v;
            return v;
        }

        public int top() {
            if (stack.isEmpty()) throw new RuntimeException("Stack empty");
            return stack.peek();
        }

        public double getAverage() {
            if (stack.isEmpty()) return 0.0;
            return (double) sum / stack.size();
        }
    }


    // ==================== 2. Python Indentation Validator ====================
    public static boolean isValidIndentation(String[] lines) {
        Stack<Integer> st = new Stack<>();
        st.push(0);  // base indent

        for (String line : lines) {
            int spaces = 0;
            while (spaces < line.length() && line.charAt(spaces) == ' ')
                spaces++;

            if (spaces == 0) { // reset block
                st.clear();
                st.push(0);
                continue;
            }

            if (spaces > st.peek()) {
                st.push(spaces);
            } else {
                while (!st.isEmpty() && st.peek() > spaces)
                    st.pop();
                if (st.isEmpty() || st.peek() != spaces)
                    return false;
            }
        }
        return true;
    }


    // ==================== 3. 2D Linked List Transpose ====================
    public static class Node2D {
        int val;
        Node2D right, down;
        Node2D(int v){val=v;}
    }

    public static Node2D transpose(Node2D head) {
        if (head == null) return null;

        Node2D curr = head;
        while (curr != null) {
            Node2D temp = curr.right;
            curr.right = curr.down;
            curr.down = temp;
            curr = curr.right;
        }
        return head; 
    }


    // ==================== 4. K-Zipline Merge ====================
    public static class Node {
        int val;
        Node next;
        Node(int v){val=v;}
    }

    public static Node kZiplineMerge(Node h1, Node h2, int k) {
        Node dummy = new Node(0);
        Node tail = dummy;
        boolean useFirst = true;

        while (h1 != null || h2 != null) {
            int count = k;

            if (useFirst) {
                while (count-- > 0 && h1 != null) {
                    tail.next = h1;
                    tail = tail.next;
                    h1 = h1.next;
                }
            } else {
                while (count-- > 0 && h2 != null) {
                    tail.next = h2;
                    tail = tail.next;
                    h2 = h2.next;
                }
            }

            useFirst = !useFirst;
        }

        return dummy.next;
    }


    // ==================== 5. Prime/Composite Partition ====================
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static Node partitionPrimes(Node head) {
        Node pH = new Node(0), pT = pH;  // primes
        Node cH = new Node(0), cT = cH;  // composites
        Node oH = new Node(0), oT = oH;  // ones

        while (head != null) {
            if (head.val == 1) {
                oT.next = head;
                oT = oT.next;
            }
            else if (isPrime(head.val)) {
                pT.next = head;
                pT = pT.next;
            } else {
                cT.next = head;
                cT = cT.next;
            }
            head = head.next;
        }

        oT.next = null;
        cT.next = oH.next;
        pT.next = cH.next;

        return pH.next;
    }


    // ==================== 6. Leaky Bucket Queue ====================
    public static class LeakyBucket {
        int cap;
        Queue<Object> q;

        public LeakyBucket(int c) {
            cap = c;
            q = new LinkedList<>();
        }

        public void enqueue(Object item) {
            if (q.size() == cap) q.poll();
            q.offer(item);
        }

        public List<Object> process(int k) {
            List<Object> out = new ArrayList<>();
            while (k-- > 0 && !q.isEmpty())
                out.add(q.poll());
            return out;
        }
    }


    // ==================== 7. C-String Interweaver ====================
    public static String interweave(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;

        while (i < s1.length() || j < s2.length()) {
            if (i < s1.length()) sb.append(s1.charAt(i++));
            if (j < s2.length()) sb.append(s2.charAt(j++));
        }
        return sb.toString();
    }


    // ==================== 8. Collapsing Count List ====================
    public static class CNT {
        String val;
        int count;
        CNT next;
        CNT(String v, int c){val=v;count=c;}
    }

    public static CNT collapse(CNT head) {
        CNT curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val.equals(curr.next.val)) {
                curr.count += curr.next.count;
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    // ==================== 9. Zigzag Multi-Level Flatten ====================
    public static class DNode {
        int val;
        DNode prev, next, child;
        DNode(int v){val=v;}
    }

    public static List<Integer> zigzagFlatten(DNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head == null) return ans;

        Queue<DNode> q = new LinkedList<>();
        q.offer(head);

        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            List<DNode> level = new ArrayList<>();

            while (size-- > 0) {
                DNode n = q.poll();
                level.add(n);

                if (n.child != null) q.offer(n.child);
                if (n.next != null) q.offer(n.next);
            }

            if (!leftToRight) Collections.reverse(level);
            for (DNode d : level) ans.add(d.val);

            leftToRight = !leftToRight;
        }

        return ans;
    }

}
