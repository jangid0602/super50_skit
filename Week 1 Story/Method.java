public class Method {
    
    //Efficient Traveler
     static int efficientTraveler(int[] nums, int initialEnergy) {
        
        for (int i = 0; i < nums.length; i++) {
            initialEnergy -= nums[i];
            if (initialEnergy <= 0) {
                // stop before next city
                return i;    
            }
        }

        return nums.length - 1; 
    }


  //Sum that stands out
     static int sumThatStandOuts(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            long suffixSum = totalSum - prefixSum - nums[i];
            if (prefixSum == suffixSum) {
                return i;   // found the index
            }
            prefixSum += nums[i];
        }

        return -1;  // if no such index found
    }

    //Flip the switch
    static int numberOfFlips(int[] nums) {
        int zeros = 0;
        int ones = 0;

        // number of 0s and 1s
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            }
        }

        // Minimum flips
         return Math.min(zeros, ones);
    }

   //Odd one out
    static int oddOneOut(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return nums[i];
            }
        }

        return -1; // No unique element 
    }


     
    //Smart pair finder
    static boolean smartPairFinder(int[] nums, int k) {
        int n = nums.length;

        // Check all pairs (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == k) {
                    return true;
                }
            }
        }

        return false; // No pair found
    }


    //Minimalist Painter
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
