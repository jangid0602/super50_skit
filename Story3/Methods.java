// @filename - Method.java
// @description - Contains implementation of all Linked List and stack based logic used by Main.java for the assignment problems.
// @author - Kripendra Singh


import java.util.*;

public class Methods {

    // Node class
    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }

    }

    // O(1) Average Stack (using Linked List)
    public static class AverageStack {

        private Node top; // top of stack
        private int size;
        private long sum;

        public AverageStack() {
            top = null;
            size = 0;
            sum = 0;
        }

        public void push(int val) {
            Node node = new Node(val);
            node.next = top;
            top = node;
            sum += val;
            size++;
        }

        public int pop() {
            if (top == null)
                return -1;
            int val = top.value;
            top = top.next;
            sum -= val;
            size--;
            return val;
        }

        public int top() {
            if (top == null)
                return -1;
            return top.value;
        }

        public double getAverage() {
            if (size == 0)
                return 0.0;
            return (double) sum / size;
        }
    }

    // Python Indentation Validator
    public static boolean isValidIndentation(String[] lines) {
        try {
            Stack<Integer> st = new Stack<>();
            st.push(0); // base level

            for (String line : lines) {
                if (line.trim().isEmpty())
                    continue;

                int indent = line.length() - line.stripLeading().length();

                if (indent > st.peek()) {
                    // new block(push)
                    st.push(indent);
                } else {

                    while (!st.isEmpty() && indent < st.peek()) {
                        st.pop();
                    }
                    if (st.isEmpty() || indent != st.peek()) {
                        return false; // invalid de-indent
                    }
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 2D LinkedList Transpose
    public static class Node2D {
        int val;
        Node2D right, down;

        public Node2D(int val) {
            this.val = val;
            right = down = null;
        }
    }

    public static Node2D transpose(Node2D head) {
        try {
            if (head == null)
                return null;
            Node2D r = head;
            Node2D d = head;
            Node2D dummy = new Node2D(0), prevRow;
            Node2D[] rows = new Node2D[1000]; // max rows
            int rowCount = 0;
            while (d != null) {
                Node2D c = d;
                Node2D colPrev = null;
                int colIdx = 0;
                while (c != null) {
                    Node2D newNode = new Node2D(c.val);
                    if (rows[colIdx] == null) {
                        rows[colIdx] = newNode;
                    } else {
                        Node2D temp = rows[colIdx];
                        while (temp.down != null)
                            temp = temp.down;
                        temp.down = newNode;
                    }
                    if (colPrev != null)
                        colPrev.right = newNode;
                    colPrev = newNode;
                    c = c.right;
                    colIdx++;
                }
                d = d.down;
            }
            return rows[0];
        } catch (Exception e) {
            return null;
        }
    }

    // K-Zipline Merge

    public static class NodeObj {
        Object value;
        NodeObj next;

        public NodeObj(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    public static NodeObj kZiplineMerge(NodeObj head1, NodeObj head2, int k) {
        try {
            if (head1 == null)
                return head2;
            if (head2 == null)
                return head1;

            NodeObj dummy = new NodeObj(null);
            NodeObj tail = dummy;
            NodeObj p1 = head1, p2 = head2;

            while (p1 != null || p2 != null) {

                for (int i = 0; i < k && p1 != null; i++) {
                    tail.next = p1;
                    tail = tail.next;
                    p1 = p1.next;
                }

                for (int i = 0; i < k && p2 != null; i++) {
                    tail.next = p2;
                    tail = tail.next;
                    p2 = p2.next;
                }
            }

            tail.next = null;
            return dummy.next;

        } catch (Exception e) {
            return null;
        }
    }

    // Prime/Composite Partition
    public static Node partitionPrimes(Node head) {
        try {
            Node primeDummy = new Node(0);
            Node compDummy = new Node(0), oneDummy = new Node(0);
            Node primeTail = primeDummy;
            Node compTail = compDummy, oneTail = oneDummy;
            Node curr = head;
            while (curr != null) {
                if (curr.value == 1) {
                    oneTail.next = curr;
                    oneTail = curr;
                } else if (isPrime(curr.value)) {
                    primeTail.next = curr;
                    primeTail = curr;
                } else {
                    compTail.next = curr;
                    compTail = curr;
                }
                curr = curr.next;
            }
            primeTail.next = compDummy.next;
            compTail.next = oneDummy.next;
            oneTail.next = null;
            return primeDummy.next;
        } catch (Exception e) {
            return null;
        }
    }

    // isPrimeCheck
    private static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    // Leaky Bucket Queue
    public static class LeakyBucket {
        private Deque<Object> dq; // deque(Object) because we can store any data type in object as it is a
                                  // superclass of all datatypes
        private int capacity;

        public LeakyBucket(int capacity) {
            dq = new LinkedList<>();
            this.capacity = capacity;
        }

        public void enqueue(Object item) {
            if (dq.size() == capacity)
                dq.pollFirst();
            dq.addLast(item);
        }

        public List<Object> process(int k) {
            List<Object> res = new ArrayList<>();
            for (int i = 0; i < k && !dq.isEmpty(); i++) {
                res.add(dq.pollFirst());
            }
            return res;
        }
    }

    // C-String Interweaver
    public static String interweave(String s1, String s2) {
        try {
            StringBuilder sb = new StringBuilder();
            int n = Math.max(s1.length(), s2.length());
            for (int i = 0; i < n; i++) {
                if (i < s1.length())
                    sb.append(s1.charAt(i));
                if (i < s2.length())
                    sb.append(s2.charAt(i));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    // Collapsing Count List
    public static class CountNode {
        String val;
        int count;
        CountNode next;

        public CountNode(String val, int count) {
            this.val = val;
            this.count = count;
            this.next = null;
        }
    }

    public static CountNode collapse(CountNode head) {
        try {
            if (head == null)
                return null;
            CountNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val.equals(curr.next.val)) { // for comparing objects
                    curr.count += curr.next.count;
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
            return head;
        } catch (Exception e) {
            return null;
        }
    }

    // Zigzag Multi-Level Flatten
    public static class ZigNode {
        int val;
        ZigNode prev, next, child;

        public ZigNode(int val) {
            this.val = val;
            prev = null;
            next = null;
            child = null;
        }
    }

    public static List<Integer> zigzagFlatten(ZigNode head) {
        List<Integer> res = new ArrayList<>();
        try {
            if (head == null)
                return res;

            Deque<ZigNode> dq = new ArrayDeque<>();
            dq.addFirst(head);
            boolean leftToRight = true;

            while (!dq.isEmpty()) {
                int sz = dq.size();
                List<ZigNode> nextLevel = new ArrayList<>();

                for (int i = 0; i < sz; i++) {
                    ZigNode node = dq.pollFirst();
                    res.add(node.val);

                    if (node.child != null)
                        nextLevel.add(node.child);

                    if (leftToRight && node.next != null) {
                        dq.addLast(node.next);
                    } else if (!leftToRight && node.next != null) {
                        dq.addFirst(node.next);
                    }
                }

                if (!leftToRight)
                    Collections.reverse(nextLevel);
                for (ZigNode n : nextLevel)
                    dq.addFirst(n);

                leftToRight = !leftToRight;
            }
        } catch (Exception e) {

        }
        return res;
    }

}