public class PrimeCompositePartition {

    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    public static Node partitionPrimes(Node head) {

        Node primeHead = null, primeTail = null;
        Node compHead = null, compTail = null;
        Node onesHead = null, onesTail = null;

        Node cur = head;

        while (cur != null) {
            // Store next node before modifying cur.next
            Node next = cur.next;
            
            // Clear cur.next to break original links
            cur.next = null;

            if (cur.val == 1) {
                if (onesHead == null) onesHead = onesTail = cur;
                else { onesTail.next = cur; onesTail = cur; }
            }
            else if (isPrime(cur.val)) {
                if (primeHead == null) primeHead = primeTail = cur;
                else { primeTail.next = cur; primeTail = cur; }
            }
            else {
                if (compHead == null) compHead = compTail = cur;
                else { compTail.next = cur; compTail = cur; }
            }

            cur = next;
        }

        // join lists
        Node result = null, tail = null;

        if (primeHead != null) {
            result = primeHead;
            tail = primeTail;
        }

        if (compHead != null) {
            if (result == null) { result = compHead; tail = compTail; }
            else { tail.next = compHead; tail = compTail; }
        }

        if (onesHead != null) {
            if (result == null) result = onesHead;
            else tail.next = onesHead;
            tail = onesTail;
        }

        if (tail != null) tail.next = null;

        return result;
    }
}
