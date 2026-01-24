import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingPageNumbersSolution {
    private static List<String> getMissingPageRanges(int[] pages, int n) {
        Set<Integer> set = new HashSet<>();
        List<Integer> missing = new ArrayList<>();
        int size = 0;
        for (int page : pages) set.add(page);
        for (int i = 1; i < n + 1; i++) {
            if (!set.contains(i)) {
                missing.add(i);
                size++;
            }
        }
        if (size == 0) return new ArrayList<>();
        // grouping
        List<String> pageRanges = new ArrayList<>();
        int i = 0;
        while (i < size) {
            int start = missing.get(i);
            while (i + 1 < size && missing.get(i + 1) - missing.get(i) == 1) {
                i++;
            }
            int end = missing.get(i);
            String range = start < end ? start + "-" + end : String.valueOf(start);
            pageRanges.add(range);
            i++;
        }
        return pageRanges;
    }


    public static void main(String[] args) {
        int[] pages = new int[]{1,2,3,4};
        int n = 1;
        System.out.println(getMissingPageRanges(pages, n));
    }
}
