public class Methods {
    static int efficientTraveler(int nums[], int initEnergy) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // Decreasing energy while visiting city
            initEnergy = initEnergy - nums[i];
            if (initEnergy == 0 || initEnergy < 0) {
                break;
            }
            ans++;
        }
        return ans;
    }

    static int sumThatStandOuts(int nums[]) {
        int total = 0;
        // For calculating total
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        // For traversing each element
        for (int i = 0; i < nums.length; i++) {
            int prefixSum = 0;
            int suffixSum = 0;
            // Calculating prefix sum
            for (int j = 0; j < i; j++) {
                prefixSum += nums[j];
            }
            suffixSum = total - prefixSum - nums[i];
            if (suffixSum == prefixSum) {
                return i;
            }
        }
        return -1;
    }

    static int numberOfFlips(int arr[]) {
        int zeros = 0, ones = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeros++;
            else if (arr[i] == 1)
                ones++;
        }
        return Math.min(zeros, ones);
    }

    static int oddOneOut(int arr[]) {
        int freq[] = new int[arr.length];
        // Calculating frequency
        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] = 1;
            } else {
                freq[arr[i]]++;
            }
        }
        // Finding number with freq = 1 i.e., Non repeated
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    static boolean smartPairFinder(int nums[], int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Checking whether pair(i,j) exist such that i+j=k
                if (nums[i] + nums[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    static int minimalistPainter(int time[]) {
        int totalTime = 0;
        int maxTime = 0;
        for (int i = 0; i < time.length; i++) {
            totalTime += time[i];
            if (time[i] > maxTime) {
                maxTime = time[i];
            }
        }
        return totalTime - maxTime;
    }

}
