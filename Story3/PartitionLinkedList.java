package Story3;

import java.util.LinkedList;

public class PartitionLinkedList {
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return (n == 2);
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Partition using 2 lists and then merge
    static LinkedList<Integer> partition(LinkedList<Integer> list) {

        LinkedList<Integer> primeList = new LinkedList<>();
        LinkedList<Integer> compositeList = new LinkedList<>();

        for (int x : list) {
            if (x == 1 || isPrime(x)) {
                primeList.add(x); // 1 and primes
            } else {
                compositeList.add(x); // composite numbers
            }
        }

        // Merge: primeList + compositeList
        primeList.addAll(compositeList);

        return primeList;
    }
}
