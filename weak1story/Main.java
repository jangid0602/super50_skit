package story1;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main_Implemtation imp = new Main_Implemtation();

        while (true) {
            System.out.println("Press 1: Find Efficient Traveler.");
            System.out.println("Press 2:The Sum that Stands out");
            System.out.println("Press 3: Flip the switch");
            System.out.println("Press 4: Odd One Out");
            System.out.println("Press 5: Smart Pair finder");
            System.out.println("Press 6:The Minimalist painter");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int n1 = sc.nextInt();

            switch (n1) {
                case 1:
                    System.out.print("Enter the no of cities: ");
                    int n = sc.nextInt();
                    int[] nums = new int[n];

                    System.out.println("Enter the energy array:");
                    for (int i = 0; i < n; i++) {
                        nums[i] = sc.nextInt();
                    }

                    System.out.print("Enter initial energy level: ");
                    int El = sc.nextInt();

                    int index = imp.FarthestCity(nums, El);
                    System.out.println("The farthest city index you can reach: " + index);
                    break;

                case 2 :
                // the sum that stands out
                 System.out.println("Enter the size of the array:");
                     int s3 = sc.nextInt();
                     int[] prefixSuffixArray= new int[s3];
                     System.out.println("Enter the array Elements:");
                     for(int i=0;i<s3;i++){
                      prefixSuffixArray[i] = sc.nextInt();
                     }
              
                    int indexs = imp.findPrefixSuffix(prefixSuffixArray);
                    System.out.println("Index where prefixsum equals suffix sum is(0 based indexing):"+indexs);
                    break; 

                case 3:
                     System.out.println("Enter the size of the array:");
                     int s = sc.nextInt();
                     int[] binaryArray = new int[s];
                     System.out.println("Enter binary array:");
                     for(int i=0;i<s;i++){
                      binaryArray[i] = sc.nextInt();
                     }
                    int output =  imp.FlipSwitch(binaryArray);
                    System.out.println("minimum number of flips:"+output);
                    break; 

                    case 4:
                // odd one out 
                     System.out.println("Enter the size of the array:");
                     int s1 = sc.nextInt();
                     int[] singleElementArray = new int[s1];
                     System.out.println("Enter the array Elements:");
                     for(int i=0;i<s1;i++){
                      singleElementArray[i] = sc.nextInt();
                     }
                     int el = imp.findSingleElement(singleElementArray);
                     if(el == -1){
                      System.out.println("No single element found.....");
                     }else{
                      System.out.println("Single element is:"+el);
                     }
                     break; 


                     case 5:
                // smart pair finder
                     System.out.println("Enter the size of the array:");
                     int sp = sc.nextInt();
                     int[] smartpairArray = new int[sp];
                     System.out.println("Enter the array Elements:");
                     for(int i=0;i<sp;i++){
                      smartpairArray[i] = sc.nextInt();
                     }
                     System.out.println("Enter the value of the k:");
                     int k = sc.nextInt();
                     List<int[]> pair = imp.findSmartPair(smartpairArray,k);
                     if(pair.isEmpty()){
                      System.out.println("False");
                      System.out.println("No pair exist");
                     }else{
                      System.out.println("True");
                      System.out.println("Pairs with sum " + k + ":");
                      for (int[] p : pair) {
                          System.out.println(p[0] + ", " + p[1]);
                      }
                     }
                     break; 


                     case 6:
                     // the minimalist painter

                     System.out.println("enter the size of the array;");
                     int n2 = sc.nextInt();
                     int[] paintArray = new int[n2];
                     System.out.println("Enter Array eleemnets:");
                     for(int i=0;i<n2;i++){
                      paintArray[i] = sc.nextInt();
                     }

                     int answer = imp.findMinPaintTime(paintArray);
                     System.out.println("Mininum Total Time After Skipping oen wall :"+answer);

                     break; 
                     


                case 7:
                    System.out.println("Exiting from the system.....");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
                    break;
            }
        }
    }
}
