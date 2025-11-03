import java.util.*;

class Story2{

    int equalSum(List<Integer> nums){
        int totalSum = 0;
        
        // calculate total sum
        for(int value : nums){
            totalSum += value;
        }

        int prefixSum = 0;

        for(int index = 0; index < nums.size(); index++){

            totalSum -= nums.get(index);  // now totalsum is suffix sum

            if(prefixSum == totalSum){
                return index;
            }

            prefixSum += nums.get(index);
        }

        return -1;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        System.out.println("Enter elements:");
        for(int i=0; i<size; i++){
            nums.add(sc.nextInt());
        }

        Story2 obj = new Story3();
        System.out.println("Index = " + obj.equalSum(nums));
    }
}
