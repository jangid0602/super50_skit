import java.util.ArrayList;
import java.util.List;

/**
 * @Filename-MyArray.java
 * @Description-This will perform the operations on array
 * @Author-Aditya Virmani
 */

class OddOneResult {
    boolean isValid;
    int element;

    OddOneResult(boolean isValid, int element) {
        this.isValid = isValid;
        this.element = element;
    }
}

public class MyArray {
    int[] array;
    int size;

    MyArray(int[] arr, int size) {
        array = arr;
        this.size = size;
    }

    void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }
        while (left <= mid)
            temp.add(arr[left++]);
        while (right <= high)
            temp.add(arr[right++]);
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low);
    }

    void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    int efficientTraveller(int initialEnergy) {
        if (initialEnergy <= 0)
            return -1;
        for (int i = 0; i < size; i++) {
            if (array[i] <= 0)
                return -1;
        }
        for (int i = 0; i < size; i++) {
            if (initialEnergy < 0)
                return i - 1;
            initialEnergy -= array[i];
        }
        return size - 1;
    }

    int sumStandsOut() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        int prefixSum = 0, suffixSum = sum;
        for (int i = 0; i < size; i++) {
            suffixSum -= array[i];
            if (prefixSum == suffixSum)
                return i;
            prefixSum += array[i];
        }
        return -1;
    }

    int flipTheSwitch() {
        for (int i = 0; i < size; i++) {
            if (array[i] != 0 && array[i] != 1)
                return -1;
        }
        int oneCount = 0, zeroCount = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == 0)
                zeroCount++;
            else
                oneCount++;
        }
        return zeroCount < oneCount ? zeroCount : oneCount;
    }

    OddOneResult oddOneOut() {
        int[] copyArray = new int[size];
        for (int i = 0; i < size; i++) {
            copyArray[i] = array[i];
        }

        mergeSort(copyArray, 0, size - 1);

        int singleCount = 0;
        int singleElement = -1;

        for (int i = 0; i < size; i++) {
            int count = 1;
            while (i + 1 < size && copyArray[i] == copyArray[i + 1]) {
                count++;
                i++;
            }
            if (count == 1) {
                singleCount++;
                if (singleCount > 1)
                    return new OddOneResult(false, 0);
                singleElement = copyArray[i];

            } else if (count > 2) {
                return new OddOneResult(false, 0);
            }
        }

        if (singleCount == 1)
            return new OddOneResult(true, singleElement);
        return new OddOneResult(false, 0);
    }

    boolean smartPairFinder(int target) {
        int[] copyArray = new int[size];
        for (int i = 0; i < size; i++) {
            copyArray[i] = array[i];
        }
        mergeSort(copyArray, 0, size - 1);
        int left = 0, right = size - 1;
        while (left < right) {
            int sum = copyArray[left] + copyArray[right];
            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }
        return false;
    }

    int minimalistPainter() {
        int maximum = -1;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] < 0)
                return -1;
            sum += array[i];
            if (maximum < array[i])
                maximum = array[i];
        }
        return sum - maximum;
    }
}
