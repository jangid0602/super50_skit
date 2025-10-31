import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @file StoryProblems.java
 * @description Menu-driven program implementing Week 1 Stories:
 * 1. Efficient Traveler
 * 2. The Sum That Stands Out (Pivot Index)
 * 3. Flip The Switch
 * 4. The Odd One Out (Manual Frequency Array)
 * 5. Smart Pair Finder (Manual Frequency Array)
 * 6. The Minimalist Painter
 * @author - Badal
 */

public class story1{

    //  Efficient Traveler
    public int efficientTraveler(int[] nums, int initialEnergy) {
        int tempEnergy = initialEnergy;
        for (int i = 0; i < nums.length; i++) {
            tempEnergy -= nums[i];
            if (tempEnergy < 0)
                return i ;
        }
        return nums.length - 1;
    }

    //  The Sum That Stands Out (Pivot Index)
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++)
            totalSum += nums[i];
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
            if (leftSum == totalSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    //  Flip the Switch
    public int flips(int[] nums) {
        int count0 = 0, count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0++;
            else
                count1++;
        }
        return (count0 < count1) ? count0 : count1;
    }

    //  The Odd One Out — manual frequency array
    public int oddOneOut(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        int[] freq = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i <= max; i++) {
            if (freq[i] == 1)
                return i;
        }
        return -1;
    }

    //  Smart Pair Finder — manual frequency array
    public boolean smartPairFinder(int[] nums, int target) {
       for(int i=0;i<nums.length-1;i++){
           for(int j=i+1;j<nums.length;j++){
               if(nums[i]+nums[j]==target)
                   return true;
           }
       }
       return false;
    }

    // The Minimalist Painter
    public int minimalistPainter(int[] time) {
        if (time.length == 0)
            return 0;
        int total = 0;
        int max = time[0];
        for (int i = 0; i < time.length; i++) {
            total += time[i];
            if (time[i] > max)
                max = time[i];
        }
        return total - max;
    }

    // Menu-Driven Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        story1 obj = new story1();

        while (true) {
            try {
                System.out.println("\n--------- Week 1 Stories Menu ---------");
                System.out.println("1. Efficient Traveler");
                System.out.println("2. The Sum That Stands Out (Pivot Index)");
                System.out.println("3. Flip The Switch");
                System.out.println("4. The Odd One Out");
                System.out.println("5. Smart Pair Finder");
                System.out.println("6. The Minimalist Painter");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter number of cities: ");
                        int n1 = sc.nextInt();
                        int[] nums1 = new int[n1];
                        System.out.println("Enter energy costs:");
                        for (int i = 0; i < n1; i++)
                            nums1[i] = sc.nextInt();
                        System.out.print("Enter initial energy: ");
                        int e = sc.nextInt();
                        System.out.println("Farthest city index: " + obj.efficientTraveler(nums1, e));
                        break;

                    case 2:
                        System.out.print("Enter array size: ");
                        int n2 = sc.nextInt();
                        int[] nums2 = new int[n2];
                        System.out.println("Enter elements:");
                        for (int i = 0; i < n2; i++)
                            nums2[i] = sc.nextInt();
                        System.out.println("Pivot Index: " + obj.pivotIndex(nums2));
                        break;

                    case 3:
                        System.out.print("Enter binary array size: ");
                        int n3 = sc.nextInt();
                        int[] nums3 = new int[n3];
                        System.out.println("Enter binary elements (0/1):");
                        for (int i = 0; i < n3; i++)
                            nums3[i] = sc.nextInt();
                        System.out.println("Minimum flips: " + obj.flips(nums3));
                        break;

                    case 4:
                        System.out.print("Enter array size: ");
                        int n4 = sc.nextInt();
                        int[] nums4 = new int[n4];
                        System.out.println("Enter elements (each appears twice except one):");
                        for (int i = 0; i < n4; i++)
                            nums4[i] = sc.nextInt();
                        System.out.println("Odd one out: " + obj.oddOneOut(nums4));
                        break;

                    case 5:
                        System.out.print("Enter array size: ");
                        int n5 = sc.nextInt();
                        int[] nums5 = new int[n5];
                        System.out.println("Enter elements:");
                        for (int i = 0; i < n5; i++)
                            nums5[i] = sc.nextInt();
                        System.out.print("Enter target sum: ");
                        int target = sc.nextInt();
                        System.out.println("Pair with sum " + target + " exists: " + obj.smartPairFinder(nums5, target));
                        break;

                    case 6:
                        System.out.print("Enter number of walls: ");
                        int n6 = sc.nextInt();
                        int[] time = new int[n6];
                        System.out.println("Enter painting times:");
                        for (int i = 0; i < n6; i++)
                            time[i] = sc.nextInt();
                        System.out.println("Minimum total time (after skipping one wall): " + obj.minimalistPainter(time));
                        break;

                    case 7:
                        System.out.print("Are you sure you want to exit? (y/n): ");
                        char confirm = sc.next().charAt(0);
                        if (confirm == 'y' || confirm == 'Y') {
                            System.out.println("Exiting program. Thank you!");
                            sc.close();
                            return;
                        } else {
                            System.out.println("Exit cancelled. Returning to menu...");
                        }
                        break;

                    default:
                        System.out.println("Wrong choice! Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input! Please enter only numeric values given in Menu.");
                sc.nextLine(); // clear invalid input
            }
        }
    }
}
