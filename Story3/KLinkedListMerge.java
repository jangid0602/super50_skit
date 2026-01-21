package Story3;

import java.util.*;

public class KLinkedListMerge {

    LinkedList<String> merge(LinkedList<Integer> list1, LinkedList<Character> list2, int k) {

        if (k <= 0) {
            throw new IllegalArgumentException("k must be greater than 0");
        }

        LinkedList<String> mergedList = new LinkedList<>();

        Iterator<Integer> it1 = list1.iterator();
        Iterator<Character> it2 = list2.iterator();

        while (it1.hasNext() || it2.hasNext()) {

            int count = 0;
            while (count < k && it1.hasNext()) {
                mergedList.add(String.valueOf(it1.next()));
                count++;
            }

            count = 0;
            while (count < k && it2.hasNext()) {
                mergedList.add(String.valueOf(it2.next()));
                count++;
            }
        }

        return mergedList;
    }
}
