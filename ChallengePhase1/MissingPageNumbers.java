package ChallengePhase1;

import java.util.ArrayList;
import java.util.List;

public class MissingPageNumbers {
    public static List<String> getMissingPages(int[] pages, int n) {
        List<String> missingPagesList = new ArrayList<>();
        boolean[] existingPage = new boolean[n + 1];
        for (int a : pages)
            existingPage[a] = true;
        int start = 0;
        int end = 0;
        for (int i = 1; i <= n; i++) {
            if (!existingPage[i]) {
                if (start == 0) {
                    start = end = i;
                } else {
                    end++;
                }
            } else {
                if (start == 0)
                    continue;
                if (start == end) {
                    missingPagesList.add(new String("" + start));
                    start = end = 0;
                } else {
                    missingPagesList.add(new String(start + "-" + end));
                    start = end = 0;
                }
            }
        }
        if (start != 0) {
            if (start == end) {
                missingPagesList.add(new String("" + start));
                start = end = 0;
            } else {
                missingPagesList.add(new String(start + "-" + end));
                start = end = 0;
            }
        }
        return missingPagesList;
    }

    public static void main(String[] args) {
        int[] pages = new int[] { 1,2,3 };
        System.out.println(getMissingPages(pages, 5));
    }
}
