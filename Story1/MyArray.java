import java.util.ArrayList;

/**
 * @filename- MyArray.java
 * @description - Encapsulates operations for numeric array problems.
 * @author - Gautam Singh Rathore
 */
public class MyArray {
    int arraySize;    // Stores the size of the array
    int elements[];   // Stores the actual array elements

    MyArray() {
        arraySize = 0;
        elements = new int[arraySize];
    }

    MyArray(int arraySize) {
        this.arraySize = arraySize;
        elements = new int[arraySize];
    }

    /**
     * @method theEfficientTraveller
     * @description Computes how far a traveler can go by deducting the cost at each step while energy remains.
     * @param initialEnergy Initial energy value of the traveler
     * @return Number of steps traveler can complete, or -1 if initial energy is negative
     */
    public int theEfficientTraveller(int initialEnergy) {
        int lastReachableIndex = -1;
        int totalElements = elements.length;
        int currentIndex = 0;
        if (initialEnergy < 0) return -1;
        while (currentIndex < totalElements) {
            if (initialEnergy > 0 && initialEnergy >= elements[currentIndex]) {
                initialEnergy -= elements[currentIndex];
                currentIndex++;
            } else break;
        }
        lastReachableIndex = currentIndex;
        return lastReachableIndex;
    }

    /**
     * @method getTheOddOneOut
     * @description Finds the element which does not have a pair in the array.
     * @return The unique element, or -1 if none or multiple odd elements are present
     */
    public int getTheOddOneOut() {
        ArrayList<Integer> singleElements = new ArrayList<>();
        for (int index = 0; index < elements.length; index++) {
            if (singleElements.contains(elements[index])) {
                singleElements.remove(Integer.valueOf(elements[index]));
                continue;
            }
            singleElements.add(elements[index]);
        }
        if (singleElements.size() > 1) return -1;
        return singleElements.get(0);
    }

    /**
     * @method getThePair
     * @description Checks whether any two distinct elements in the array sum up to the target value.
     * @param targetSum The target sum value to check for
     * @return true if such a pair exists, false otherwise
     */
    public boolean getThePair(int targetSum) {
        for (int firstIndex = 0; firstIndex < elements.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < elements.length; secondIndex++) {
                if (elements[firstIndex] + elements[secondIndex] == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @method getMinimumTime
     * @description Calculates total time except for the largest single time value in the array.
     * @return Sum of all elements minus the maximum element
     */
    public int getMinimumTime() {
        int maximumTime = 0;
        int totalTime = 0;
        for (int index = 0; index < elements.length; index++) {
            if (maximumTime < elements[index]) {
                maximumTime = elements[index];
            }
            totalTime += elements[index];
        }
        return totalTime - maximumTime;
    }

    /**
     * @method getTheSumThatStandsOut
     * @description Finds the index where sum of elements to its left equals the sum of elements to its right.
     * @return The index, or -1 if no such index exists
     */
    public int getTheSumThatStandsOut() {
        int totalElements = elements.length;
        int overallSum = 0;
        int leftPrefixSum = 0;
        for (int element : elements) {
            overallSum += element;
        }
        for (int index = 0; index < totalElements; index++) {
            int rightSuffixSum = overallSum - leftPrefixSum - elements[index];
            if (leftPrefixSum == rightSuffixSum) return index;
            leftPrefixSum += elements[index];
        }
        return -1;
    }

    /**
     * @method flipTheSwitch
     * @description Computes the minimum number of switches to flip all elements to the majority state.
     * @return The number of flips required
     */
    public int flipTheSwitch() {
        int countZero = 0;
        int countOne = 1; // Start from 1 for correct majority check
        for (int index = 0; index < elements.length; index++) {
            if (elements[index] == 1) countOne++;
            if (elements[index] == 0) countZero++;
        }
        if (countOne > countZero) return countZero;
        else return countOne;
    }
}
