import java.util.*;

class Story5{

    boolean pairExists(List<Integer> nums, int target){

        Set<Integer> seenValues = new HashSet<>();

        for(int currentValue : nums){

            int requiredValue = target - currentValue;

            if(seenValues.contains(requiredValue)){
                return true;
            }

            seenValues.add(currentValue);
        }

        return false;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        System.out.println("Enter the elements:");
        for(int i=0; i<size; i++){
            nums.add(sc.nextInt());
        }

        System.out.print("Enter target k: ");
        int target = sc.nextInt();

        Story5 obj = new Story4();
        System.out.println(obj.pairExists(nums, target));
    }
}
