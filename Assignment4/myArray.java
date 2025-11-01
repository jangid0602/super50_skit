public class myArray {

    private int[] array;

    public myArray() {
        // Do it later;
    }

    // Constructor
    public myArray(int[] array) {
        this.array = array;
    }

    // Setter
    public void setArray(int[] array) {
        this.array = array;
    }

    int getFarthestCity(int initialEnergy) {
        int arraySize = array.length;
        int pointer = 0;
        while (pointer < arraySize && initialEnergy >= array[pointer]) {
            initialEnergy -= array[pointer];
            pointer++;
        }
        return pointer;
    }

    int findEqualSumIndex() {
        int arraySize = array.length;

        int[] prefixSum = new int[arraySize];
        int[] suffixSum = new int[arraySize];
        int currentPrefixSum = 0, currentSuffixSum = 0;
        for (int i = 0; i < arraySize; i++) {
            currentPrefixSum += array[i];
            currentSuffixSum += array[arraySize - i - 1];
            prefixSum[i] = currentPrefixSum;
            suffixSum[arraySize - i - 1] = currentSuffixSum;
        }

        for (int i = 0; i < arraySize; i++) {
            if (prefixSum[i] - array[i] == suffixSum[i] - array[i]) {
                return i;
            }
        }
        return -1;
    }

    int minimumFlipsToEqualize() {
        int count0 = 0;
        int count1 = 0;

        for (int number : array) {
            if (number == 0)
                count0++;
            else
                count1++;
        }

        return Math.min(count0, count1);
    }

    int getSingleElement() {
        int unique = 0;

        int maxValue = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        int[] hash = new int[maxValue + 1];
        for (int i = 0; i < array.length; i++) {
            hash[array[i]]++;
        }

        int count = 0;
        for (int i = 0; i <= maxValue; i++) {
            if (hash[i] == 1) {
                count++;
            }
            if (count > 1) {
                return -1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            unique ^= array[i];
        }
        return unique;
    }

    boolean checkPairSum(int targetPair) {
        int arraySize = array.length;

        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[i] + array[j] == targetPair) {
                    return true;
                }
            }
        }
        return false;
    }

    int findMinimumPaintingTime() {
        int totalSum = 0;

        for (int number : array) {
            totalSum += number;
        }

        int answer = totalSum;
        for (int number : array) {
            int value = totalSum - number;
            answer = Math.min(answer, value);
        }

        return answer;
    }
}
