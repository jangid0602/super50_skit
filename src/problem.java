/**
 * <p>This class consist all the problems in the form of class </p>
 * <p>All the classes extends the arrayHandler Class to get input in the array</p>
 * @Author- Aaditya Jain*/
import java.util.Arrays;
import java.util.Scanner;

class TheEfficientTraveller extends arrayHandler {
    long initialEnergy = 0;

    void getInitialEnergy() {
        Scanner scannerObj = new Scanner(System.in);
        System.out.println("Enter initial energy");
        if(scannerObj.hasNextLong())
        {
            initialEnergy = scannerObj.nextLong();
        }
        else {
            System.out.println("Enter valid Initital Energy(Only Integers allowed)");
            System.out.println("Exiting...");
            System.exit(1);
        }
    }

    @Override
    public void solver() {
        getInitialEnergy();
        int index ;
        for (index = 0; index < sizeOfNums; index++) {
            if (initialEnergy < nums[index]) {
                System.out.println("Farthest city reached: " + index);
                return;
            }
            initialEnergy -= nums[index];
        }
        System.out.println("Farthest city reached: " + (sizeOfNums - 1));
    }
}

class TheSumThatStandOut extends arrayHandler {
    @Override
    public void solver() {
        if (nums == null || sizeOfNums == 0) {
            System.out.println("No pivot index (empty or null array)");
            return;
        }
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        long prefixSum = 0;
        for (int index = 0; index < sizeOfNums; index++) {
            long suffixSum = totalSum - prefixSum - nums[index];
            if (prefixSum == suffixSum) {
                System.out.println("The first index where the prefix sum equals the suffix sum " + index);
                return;
            }
            prefixSum += nums[index];
        }
        System.out.println("No such index found");
    }
}

class FlipTheSwitch extends arrayHandler {
    @Override
    public void solver() {

        int count1 = 0;
        if (sizeOfNums == 0) {
            System.out.println("Minimum flips required : 0");
            return;
        }
        for (int index = 0; index < sizeOfNums; index++) {
            if (nums[index] == 1)
                count1++;
        }
        int count0 = sizeOfNums - count1;
        int minimumFlips = Math.min(count0, count1);
        System.out.println("Minimum Flips required: " + minimumFlips);
    }
}

class SmartPairFinder extends arrayHandler {
    long target;

    public void getTarget() {
        System.out.println("Enter the target ");
        Scanner scannerObj = new Scanner(System.in);
        if(scannerObj.hasNextLong())
        {
            target = scannerObj.nextLong();
        }
        else {
            System.out.println("Enter valid Target(Only Integers allowed)");
            System.out.println("Exiting...");
            System.exit(1);
        }
    }

    @Override
    public void solver() {
        getTarget();
        for (int index = 0; index < sizeOfNums; index++) {
            for (int j = index + 1; j < sizeOfNums; j++) {
                if (nums[index] + nums[j] == target) {
                    System.out.println("Pair Exists");
                    return;
                }

            }
        }

        System.out.println("No such Pair Exists");
    }
}

class TheMinimalistPainter extends arrayHandler {
    @Override
    public void solver() {
        if (sizeOfNums == 0) {
            System.out.println("The Minimum total time taken after skipping one wall is : 0");
            return;
        }
        int maximumTime = Integer.MIN_VALUE;
        long totalTime = 0;
        for (int index = 0; index < sizeOfNums; index++) {
            totalTime += nums[index];
            if (nums[index] > maximumTime)
                maximumTime = nums[index];
        }
        long minimumTime = totalTime - maximumTime;
        System.out.println(" The minimum total time after skipping one wall is :" + minimumTime);
    }
}

class TheOddOneOut extends arrayHandler {
    @Override
    public void solver() {
        if (sizeOfNums == 1) {
            System.out.println("The odd one out element is " + nums[0]);
            return;
        }
        Arrays.sort(nums, 0, sizeOfNums);

        for (int index = 0; index < sizeOfNums; index += 2) {
            if (index + 1 >= sizeOfNums || nums[index] != nums[index + 1]) {
                System.out.println("The odd one out element is " + nums[index]);
                return;
            }
        }

        System.out.println("No such element found");
    }
}
