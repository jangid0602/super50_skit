import java.util.*;
class Story3{
    int flip(List<Integer> nums){
        int countZero = 0;
        int countOne = 0;
        for(int currentElement : nums){
            if(currentElement == 0){
                countZero++;
            } else {
                countOne++;
            }
        }

        return countOne<countZero?countOne:countZero;
        
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int sizeOfNums = sc.nextInt();

        List<Integer> nums = new ArrayList<>();

        System.out.println("Enter the elements (0s and 1s):");
        for(int i=0; i<sizeOfNums; i++){
            nums.add(sc.nextInt());
        }

        Story3 obj = new Story2();
        int result = obj.flip(nums);

        System.out.println("Minimum flips required: " + result);
    }
}
