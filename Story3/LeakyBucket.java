package Story3;

import java.util.Arrays;

class LeakyBucket {
    int n;
    int[] arr;

    LeakyBucket(int capacity) {
        this.n = capacity;
        arr = new int[n];
        Arrays.fill(arr, -1); // initialize all elements to -1
    }

    void enqueue(int item) {
        boolean full = arr[n - 1] != -1;
        if (full) {
            // shift elements to left
            for (int i = 0; i < n - 1; i++)
                arr[i] = arr[i + 1];
            arr[n - 1] = item;
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[i] == -1) {
                    arr[i] = item;
                    break;
                }
            }
        }
    }

    void process(int k) {
        int count = 0;
        for (int val : arr)
            if (val != -1)
                count++;

        if (k >= count) {
            Arrays.fill(arr, -1); // remove all
        } else {
            int removed = 0;
            for (int i = 0; i < n && removed < k; i++) {
                if (arr[i] != -1) {
                    arr[i] = -1;
                    removed++;
                }
            }
            // shift remaining elements to left
            int[] newArr = new int[n];
            Arrays.fill(newArr, -1);
            int idx = 0;
            for (int val : arr) {
                if (val != -1)
                    newArr[idx++] = val;
            }
            arr = newArr;
        }
    }

    void display() {
        System.out.println(Arrays.toString(arr));
    }
}
