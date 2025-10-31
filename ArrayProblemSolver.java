import java.util.*;

class ArrayproblemSolver {

    int ArraySize;
    int array[] = new int[ArraySize];

    ArrayproblemSolver(int Arraysize) {
        Scanner sc = new Scanner(System.in);

        this.ArraySize = Arraysize;
        array = new int[ArraySize];
        System.out.println("enter array elements:");
        for (int i = 0; i < ArraySize; i++) {
            array[i] = sc.nextInt();
        }
    }

    // 1
    int calculateFarthestIndex(int initialEnergy) {
        int farthestIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (initialEnergy <= 0) {
                farthestIndex = i - 1;
                break;
            }
            initialEnergy -= array[i];
        }
        return farthestIndex;
    }

    // 2
    int findEquilibriumIndex() {
        int totalsum = 0;
        for (int i = 0; i < array.length; i++) {
            totalsum += array[i];
        }
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];
        }
        for (int i = 0; i < array.length; i++) {
            if (totalsum - (array[array.length - 1] - array[i]) == array[i]) {
                return i;
            }
        }
        return -1;
    }

    // 3
    int getMinimumBitFlips() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0 && array[i] != 1) {
                System.out.println("Invalid array according to problem");
                return -1;
            }
        }
        int ones = 0, zeroes = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroes++;
            } else {
                ones++;
            }
        }
        return (ones < zeroes) ? ones : zeroes;

    }

    // 4
    int getUniqueElement() {
        int maxx = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxx) {
                maxx = array[i];
            }
        }
        int[] frequency = new int[maxx];
        for (int i = 0; i < array.length; i++) {
            frequency[array[i] - 1]++;
        }
        int uniqueElement = 0;
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] == 1) {
                uniqueElement = i + 1;
            }
        }
        return uniqueElement;
    }

    // 5
    boolean hasPairWithTargetSum(int k) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 6
    int getMinimumTime() {
        int maxx = array[0];
        int totaltime = 0;
        for (int i = 0; i < array.length; i++) {
            totaltime += array[i];
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxx) {
                maxx = array[i];
            }
        }
        return totaltime - maxx;
    }

}
