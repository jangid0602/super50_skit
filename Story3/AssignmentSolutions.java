package Story3;

import java.util.*;

public class AssignmentSolutions {

    public static class AverageStack {
        private Deque<Integer> stack;
        private long sumOfElements;
        private int elementCount;

        public AverageStack() {
            this.stack = new ArrayDeque<>();
            this.sumOfElements = 0;
            this.elementCount = 0;
        }

        public void push(int value) {
            stack.push(value);
            sumOfElements += value;
            elementCount++;
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty. Cannot pop.");
            }
            int removed = stack.pop();
            sumOfElements -= removed;
            elementCount--;
            return removed;
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new IllegalStateException("Stack is empty. No top element.");
            }
            return stack.peek();
        }

        public double getAverage() {
            if (elementCount == 0) {
                return 0.0;
            }
            return (double) sumOfElements / elementCount;
        }
    }

    public static void runAverageStackDemo() {
        AverageStack averageStack = new AverageStack();
        averageStack.push(10);
        averageStack.push(20);
        System.out.println("Average after pushing 10, 20: " + averageStack.getAverage());
        averageStack.push(30);
        System.out.println("Average after pushing 30: " + averageStack.getAverage());
        System.out.println("Popped: " + averageStack.pop());
        System.out.println("Average after pop: " + averageStack.getAverage());
    }

    public static boolean isValidIndentation(List<String> lines) {
        Deque<Integer> indentationStack = new ArrayDeque<>();
        indentationStack.push(0); // base level

        for (String line : lines) {
            if (line == null || line.trim().isEmpty()) {
                // Ignore completely empty lines.
                continue;
            }

            int currentIndentation = countLeadingSpaces(line);

            // Ignore lines with no indentation as per problem statement.
            if (currentIndentation == 0) {
                // If we see a non-indented line after indentation, it should match base level 0.
                if (indentationStack.peek() != 0) {
                    return false;
                }
                continue;
            }

            int previousIndentation = indentationStack.peek();

            if (currentIndentation == previousIndentation) {
                // Same indentation level is fine.
                continue;
            } else if (currentIndentation > previousIndentation) {
                // Must indent to a strictly greater level than previous.
                indentationStack.push(currentIndentation);
            } else {
                // De-indentation: must exactly match a previous level.
                while (!indentationStack.isEmpty() && indentationStack.peek() > currentIndentation) {
                    indentationStack.pop();
                }
                if (indentationStack.isEmpty() || indentationStack.peek() != currentIndentation) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int countLeadingSpaces(String line) {
        int count = 0;
        while (count < line.length() && line.charAt(count) == ' ') {
            count++;
        }
        return count;
    }

    public static void runIndentationValidatorDemo() {
        List<String> testLines = Arrays.asList(
                "def func():",
                " x = 1",
                " y = 2",
                " z = 3",
                " a = 4",
                "b = 5"
        );
        System.out.println("Indentation valid: " + isValidIndentation(testLines));
    }

    public static class Node2D {
        int value;
        Node2D right;
        Node2D down;

        public Node2D(int value) {
            this.value = value;
        }
    }

    public static Node2D transpose(Node2D head) {
        if (head == null || head.down == null) {
            // No transpose change for single row.
            return head;
        }

        // First pass: swap right and down pointers for every node in the structure.
        Node2D rowPointer = head;
        while (rowPointer != null) {
            Node2D columnPointer = rowPointer;
            while (columnPointer != null) {
                Node2D temp = columnPointer.right;
                columnPointer.right = columnPointer.down;
                columnPointer.down = temp;
                columnPointer = columnPointer.right; // now move along new "row"
            }
            rowPointer = rowPointer.down; // move along new "column"
        }

        // After transpose, the new head is the original head.down (matrix transpose).
        return head.down;
    }

    public static void runTransposeDemo() {
        /*
         * Builds:
         * 1 -> 2 -> 3
         * |    |    |
         * 4 -> 5 -> 6
         */
        Node2D n1 = new Node2D(1);
        Node2D n2 = new Node2D(2);
        Node2D n3 = new Node2D(3);
        Node2D n4 = new Node2D(4);
        Node2D n5 = new Node2D(5);
        Node2D n6 = new Node2D(6);

        n1.right = n2;
        n2.right = n3;
        n1.down = n4;
        n2.down = n5;
        n3.down = n6;
        n4.right = n5;
        n5.right = n6;

        Node2D newHead = transpose(n1);
        System.out.println("New head after transpose: " + newHead.value); // should be 4
    }

    public static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode kZiplineMerge(ListNode head1, ListNode head2, int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k must be positive.");
        }

        ListNode dummyHead = new ListNode(0);
        ListNode mergeTail = dummyHead;

        ListNode current1 = head1;
        ListNode current2 = head2;
        boolean takeFromFirstList = true;

        while (current1 != null || current2 != null) {
            int nodesTaken = 0;
            if (takeFromFirstList) {
                // Take up to k nodes from first list
                while (current1 != null && nodesTaken < k) {
                    mergeTail.next = current1;
                    mergeTail = mergeTail.next;
                    current1 = current1.next;
                    nodesTaken++;
                }
            } else {
                // Take up to k nodes from second list
                while (current2 != null && nodesTaken < k) {
                    mergeTail.next = current2;
                    mergeTail = mergeTail.next;
                    current2 = current2.next;
                    nodesTaken++;
                }
            }

            // Toggle which list to take from next
            takeFromFirstList = !takeFromFirstList;

            // If one list is exhausted while taking a chunk, simply append rest of the other.
            if (nodesTaken < k) {
                if (current1 == null && current2 != null) {
                    mergeTail.next = current2;
                    break;
                }
                if (current2 == null && current1 != null) {
                    mergeTail.next = current1;
                    break;
                }
            }
        }

        return dummyHead.next;
    }

    public static void runKZiplineMergeDemo() {
        ListNode head1 = buildList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode head2 = buildList(new int[]{11, 12, 13, 14}); // use numbers instead of A,B,...
        ListNode merged = kZiplineMerge(head1, head2, 2);
        System.out.print("Merged list: ");
        printList(merged);
    }

    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int value : values) {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        return dummy.next;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode partitionPrimes(ListNode head) {
        ListNode primeHead = null, primeTail = null;
        ListNode compositeHead = null, compositeTail = null;
        ListNode oneHead = null, oneTail = null;

        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = null;

            if (current.value == 1) {
                if (oneHead == null) {
                    oneHead = oneTail = current;
                } else {
                    oneTail.next = current;
                    oneTail = current;
                }
            } else if (isPrime(current.value)) {
                if (primeHead == null) {
                    primeHead = primeTail = current;
                } else {
                    primeTail.next = current;
                    primeTail = current;
                }
            } else {
                if (compositeHead == null) {
                    compositeHead = compositeTail = current;
                } else {
                    compositeTail.next = current;
                    compositeTail = current;
                }
            }

            current = nextNode;
        }

        // Connect prime -> composite -> ones
        ListNode newHead = null;
        ListNode newTail = null;

        if (primeHead != null) {
            newHead = primeHead;
            newTail = primeTail;
        }

        if (compositeHead != null) {
            if (newHead == null) {
                newHead = compositeHead;
                newTail = compositeTail;
            } else {
                newTail.next = compositeHead;
                newTail = compositeTail;
            }
        }

        if (oneHead != null) {
            if (newHead == null) {
                newHead = oneHead;
                newTail = oneTail;
            } else {
                newTail.next = oneHead;
                newTail = oneTail;
            }
        }

        return newHead;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    public static void runPartitionPrimesDemo() {
        ListNode head = buildList(new int[]{3, 4, 1, 2, 6, 5, 7});
        ListNode newHead = partitionPrimes(head);
        System.out.print("Partitioned list: ");
        printList(newHead);
    }

    public static class LeakyBucket<T> {
        private final int capacity;
        private final Deque<T> queue;

        public LeakyBucket(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Capacity must be positive.");
            }
            this.capacity = capacity;
            this.queue = new ArrayDeque<>();
        }

        public void enqueue(T item) {
            // If full, drop front element first.
            if (queue.size() == capacity) {
                queue.pollFirst();
            }
            queue.offerLast(item);
        }

        public List<T> process(int k) {
            List<T> processedItems = new ArrayList<>();
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                processedItems.add(queue.pollFirst());
            }
            return processedItems;
        }
    }

    public static void runLeakyBucketDemo() {
        LeakyBucket<Integer> bucket = new LeakyBucket<>(3);
        bucket.enqueue(1);
        bucket.enqueue(2);
        bucket.enqueue(3);
        bucket.enqueue(4); // drops 1, keeps 2,3,4
        List<Integer> processed = bucket.process(2);
        System.out.println("Processed items: " + processed);
    }

    public static class CountNode {
        char value;
        int count;
        CountNode next;

        public CountNode(char value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    /**
     * Collapses adjacent nodes having same value by merging counts.
     */
    public static CountNode collapse(CountNode head) {
        if (head == null) {
            return null;
        }

        CountNode current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                // Merge next node into current node.
                current.count += current.next.count;
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    public static void runCollapseDemo() {
        CountNode a1 = new CountNode('A', 2);
        CountNode a2 = new CountNode('A', 3);
        CountNode b = new CountNode('B', 1);
        CountNode c = new CountNode('C', 4);

        a1.next = a2;
        a2.next = b;
        b.next = c;

        CountNode newHead = collapse(a1);
        printCountList(newHead);
    }

    private static void printCountList(CountNode head) {
        CountNode current = head;
        while (current != null) {
            System.out.print("(" + current.value + ", " + current.count + ")");
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static class MultiLevelNode {
        int value;
        MultiLevelNode prev;
        MultiLevelNode next;
        MultiLevelNode child;

        public MultiLevelNode(int value) {
            this.value = value;
        }
    }

    public static MultiLevelNode flattenZigzag(MultiLevelNode head) {
        if (head == null) {
            return null;
        }

        Deque<MultiLevelNode> deque = new ArrayDeque<>();
        deque.offerLast(head);

        List<MultiLevelNode> resultOrder = new ArrayList<>();
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int levelSize = deque.size();
            List<MultiLevelNode> levelNodes = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                MultiLevelNode node;
                if (leftToRight) {
                    node = deque.pollFirst();
                    // traverse next
                    if (node.next != null) {
                        deque.offerLast(node.next);
                    }
                    if (node.child != null) {
                        deque.offerLast(node.child);
                    }
                } else {
                    node = deque.pollLast();
                    // traverse "prev" direction order for right-to-left level
                    if (node.prev != null) {
                        deque.offerFirst(node.prev);
                    }
                    if (node.child != null) {
                        deque.offerFirst(node.child);
                    }
                }
                levelNodes.add(node);
            }

            if (!leftToRight) {
                Collections.reverse(levelNodes);
            }
            resultOrder.addAll(levelNodes);
            leftToRight = !leftToRight;
        }

        // Reconstruct flattened doubly linked list from resultOrder.
        MultiLevelNode flatHead = resultOrder.get(0);
        flatHead.prev = null;
        flatHead.child = null;
        MultiLevelNode current = flatHead;

        for (int i = 1; i < resultOrder.size(); i++) {
            MultiLevelNode node = resultOrder.get(i);
            node.child = null;
            node.prev = current;
            current.next = node;
            current = node;
        }
        current.next = null;

        return flatHead;
    }

    public static void runFlattenZigzagDemo() {
        // Minimal demo; building full example is verbose.
        MultiLevelNode n1 = new MultiLevelNode(1);
        MultiLevelNode n2 = new MultiLevelNode(2);
        MultiLevelNode n3 = new MultiLevelNode(3);

        n1.next = n2;
        n2.prev = n1;
        n2.next = n3;
        n3.prev = n2;

        MultiLevelNode flatHead = flattenZigzag(n1);
        MultiLevelNode temp = flatHead;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
