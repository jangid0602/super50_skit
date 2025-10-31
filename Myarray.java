

public class Myarray {
    private int[] arr;
    private int size;

    Myarray(int[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    int efficientTraveller(int initialEnergy) {
        if (initialEnergy < 1)
            return -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 1)
                return -1;
            if (arr[i] <= initialEnergy)
                initialEnergy -= arr[i];
            else {
                return i;
            }
        }
        return size - 1;
    }

    int prefixEqualSuffix() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += this.arr[i];
        }
        int i = 0;
        int prefixSum = 0;
        while (i < size) {
            sum -= arr[i];
            if (sum == prefixSum)
                return i;
            prefixSum += arr[i];
            i++;
        }
        return -1;
    }

    int flipSwitch() {
        int countOnes = 0;
        int countZeros = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == 1)
                countOnes++;
            else if (arr[i] == 0)
                countZeros++;
            else
                return -1;
        }
        if (countOnes <= countZeros)
            return countOnes;
        return countZeros;
    }

    int singleNumber() {
        sort(arr);  
        int n = arr.length;
        

        for (int i = 0; i < n; ) {
            int count = 1;
        
            while (i + count < n && arr[i] == arr[i + count]) {
                count++;
            }
            
            if (count > 2) {
                break;
            }
            if (count == 1) {
                return arr[i];
            }

            i += count;
        }

        return Integer.MIN_VALUE;
    }

    boolean smartPairFinder(int k) {
        sort(arr);

        int i = 0, j = size - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < k)
                i++;
            else if (sum > k)
                j--;
            else
                return true;
        }
        return false;
    }

    int minimalistPainter() {
        int maxNum = arr[0];
        if(maxNum<0) return -1;
        int answer = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < 0)
                return -1;
            if (arr[i] < maxNum)
                answer += arr[i];
            else {
                answer += maxNum;
                maxNum = arr[i];
            }
        }
        return answer;
    }
    int[] merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        
        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];

        return arr; 
    }

    int[] divide(int[] arr, int left, int right) {
        if (left >= right)
            return arr;

        int mid = left + (right - left) / 2;

        arr = divide(arr, left, mid);
        arr = divide(arr, mid + 1, right);
        arr = merge(arr, left, mid, right);

        return arr;
    }

    private void sort(int[] arr) {
        int length = arr.length;
        arr = divide(arr, 0, length - 1);
    }

}
