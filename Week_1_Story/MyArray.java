/*
@filename - MyArray.java
@description - Array methods implementation
@author - Kavya Gupta
*/

package Assignment_4;

public class MyArray {

    int[] data;

    MyArray(int[] value) {
        data = value;
    }

    boolean getSmartPair(int target) {

        int size = data.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (data[i] + data[j] == target)
                    return true;
            }
        }

        return false;
    }

    int getMinimumFlips() {
        int countFor1 = 0;
        int countFor0 = 0;

        int size = data.length;

        for (int i = 0; i < size; i++) {
            if (data[i] == 0)
                countFor0++;
            if (data[i] == 1)
                countFor1++;
        }

        return Math.min(countFor0, countFor1);
    }

    int getFirstCommonIndex() {
        int n = data.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = data[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + data[i];
        }

        suffix[n - 1] = data[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = suffix[j + 1] + data[j];
        }

        for (int k = 0; k < n; k++) {
            if (prefix[k] == suffix[k])
                return k;
        }

        return -1;
    }

    int getTheOdd() {
        int element = 0;
        int size = data.length;

        for (int i = 0; i < size; i++) {
            element ^= data[i];
        }

        return element;
    }

    int getMinimumPaintingTime() {

        int totalTime = 0;
        int maxTime = 0;
        int size = data.length;

        for (int i = 0; i < size; i++) {
            totalTime += data[i];
            maxTime = Math.max(maxTime, data[i]);
        }

        int minimumTime = totalTime - maxTime;

        return minimumTime;
    }

    int getFarthestCityIndex(int initialEnergy) {
        int size = data.length;

        int index = 0;

        while (index < size && initialEnergy >= 0) {
            initialEnergy = initialEnergy - data[index];
            index++;
        }

        return index - 1;
    }
}