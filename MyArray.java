import java.util.Arrays;

public class MyArray {
    private int[] values;

    MyArray(int[] values) {
        this.values = values;
    }

    public int getEfficientTraveler(int initialEnergy) {
        if (values.length == 0 || initialEnergy <= 0) {
            return -1;
        }

        int farthest = -1;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0)
                return -1;
            initialEnergy -= values[i];
            if (initialEnergy < 0)
                break;
            farthest = i;
        }
        return farthest+1;

    }

    public int getSumThatStandsOut() {
        if (values == null || values.length < 3)
            return -1;
        long totalSum = 0;
        for (int number : values)
            totalSum += number;

        long prefixSum = 0;
        for (int i = 0; i < values.length; i++) {
            long suffixSum = totalSum - prefixSum - values[i];
            if (prefixSum == suffixSum)
                return i;
            prefixSum += values[i];
        }
        return -1;
    }

    public int flipTheSwitch() {
        if (values == null || values.length == 0)
            return -1;
        int countZero = 0, countOne = 0;
        for (int number : values) {
            if (number == 0)
                countZero++;
            else if (number == 1)
                countOne++;
            else
                return -1;
        }

        if (countZero < countOne) {
            return countZero;
        }
        return countOne;
    }

    public int getOddOneOut(){
        if (values == null || values.length == 0) return Integer.MIN_VALUE;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int number:values){
            if(number<mini) mini = number;
            if(number>maxi) maxi = number;
        }

        int offset = -mini;
        int[] freq = new int[maxi-mini+1];
        for(int num:values){
            freq[num+offset]++;
        }
        for(int i = 0;i<freq.length;i++){
            if(freq[i]%2!=0){
                return i-offset;
            }
        }
        return Integer.MIN_VALUE;
    }

    public int minimalistPainter() {
        if (values == null || values.length < 2)
            return -1;
        int total = 0;
        int maxi = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < 0)
                return -1;
            total += values[i];
            if (values[i] > maxi) {
                maxi = values[i];
            }
        }
        return total - maxi;
    }

    public int smartPairFinder(int k) {
        if (values == null || values.length < 2)
            return -1;
        int[] arr = values.clone();
        sort(arr);
        int left = 0, right = arr.length - 1;

        while (left < right) {
            long sum = (long) arr[left] + arr[right];
            if (sum == k)
                return 1;
            else if (sum < k)
                left++;
            else
                right--;
        }

        return 0;
    }

    private static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[index++] = arr[i++];
            else
                temp[index++] = arr[j++];
        }
        while (i <= mid)
            temp[index++] = arr[i++];
        while (j <= right)
            temp[index++] = arr[j++];
        for (int k = 0; k < temp.length; k++)
            arr[left + k] = temp[k];
    }
}
