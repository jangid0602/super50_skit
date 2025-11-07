import java.text.CollationElementIterator;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Myarray {

    int TrendsetterScore(int[] arr, int k) {
        int size = arr.length;
        if (k > size)
            return 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int score = 0;
        for (int i = 0; i < k; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        if (hasTrendsetter(freq))
            score++;
        for (int i = k; i < size; i++) {
            int add = arr[i];
            int remove = arr[i - k];

            removeInMap(freq, remove);
            freq.put(add, freq.getOrDefault(add, 0) + 1);
            if (hasTrendsetter(freq))
                score++;
        }
        return score;
    }

    private boolean hasTrendsetter(HashMap<Integer, Integer> freq) {
        int maxFreq = Collections.max(freq.values());
        int count = 0;
        for (int value : freq.values()) {
            if (value == maxFreq)
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }

    void removeInMap(HashMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) <= 0) {
                map.remove(key);
            }
        }
    }

    String FunnelAnalysis(String[] actions) {
        HashMap<String, String> lastPage = new HashMap<>();
        HashMap<String, Integer> pathCount = new HashMap<>();

        for (String action : actions) {
            String[] parts = action.split(",");
            String user = parts[0];
            String page = parts[1];

            if (lastPage.containsKey(user)) {
                String path = lastPage.get(user) + "," + page;
                pathCount.put(path, pathCount.getOrDefault(path, 0) + 1);
            }

            lastPage.put(user, page); 
        }

        
        String bestPath = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : pathCount.entrySet()) {
            String path = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && path.compareTo(bestPath) < 0)) {
                bestPath = path;
                maxCount = count;
            }
        }

        return bestPath;
    }

    int pairMaching(int[] arr, int k) {
        // if(k>size) return 0;
        int size = arr.length;
        int score = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < size; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < size; i++) {
            int num = k - arr[i];
            if (freq.containsKey(arr[i]) && freq.containsKey(num)) {
                if (num == arr[i] && freq.get(num) < 2)
                    continue;
                removeInMap(freq, arr[i]);
                removeInMap(freq, k - arr[i]);
                score++;
            }
        }
        return score;
    }

    int colorBalance(int[] arr) {
        int size = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1)
                sum += 1;
            else if (arr[i] == 2)
                sum -= 1;
            else if (arr[i] == 0)
                sum = sum;
            else
                return -1;
            if (map.containsKey(sum)) {
                int x = map.get(sum);
                maxLength = Math.max(maxLength, i - x);
            } else {
                map.put(sum, i);
            }

        }
        return maxLength;
    }

    int resumeKeyword(String[] v1, String[] v2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int n1 = v1.length;
        int n2 = v2.length;
        for (int i = 0; i < n1; i++) {
            map1.put(v1[i], map1.getOrDefault(v1[i], 0) + 1);
        }
        for (int i = 0; i < n2; i++) {
            map2.put(v2[i], map2.getOrDefault(v2[i], 0) + 1);
        }
        int min = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int a1 = map1.get(key);
                int a2 = map2.get(key);
                if (a1 <= a2)
                    min += a1;
                else
                    min += a2;
            }
        }
        return min;
    }
}
