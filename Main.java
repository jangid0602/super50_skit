import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = 0;

        System.out.println("🎯 Welcome to the Array Operations Console!");
        System.out.println("============================================");

        while (true) {
            System.out.print("📏 Enter the size of the array: ");
            String size = input.nextLine();
            try {
                number = Integer.parseInt(size);
                if (number <= 0) {
                    System.out.println("⚠️ Size must be positive. Try again.\n");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter digits only.\n");
            }
        }

        MyArray nums = new MyArray(number);
        nums.nums = new int[number];

        System.out.println("\n🧩 Now, let's fill your array!");
        for (int i = 0; i < number; i++) {
            while (true) {
                System.out.print("➡️ Enter array element at index " + i + ": ");
                String arrayInput = input.nextLine();
                try {
                    int num = Integer.parseInt(arrayInput);
                    nums.nums[i] = num;
                    System.out.println("✅ Stored " + num + " at index " + i);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Invalid input! Please enter digits only.\n");
                }
            }
        }

        System.out.println("\n✅ Array entered successfully!");
        System.out.println("============================================");


        String[] arrayOperations = {
                "The Efficient Traveller",
                "The Sum That Stands Out",
                "Flip the Switch",
                "The Odd One Out",
                "Smart Pair Finder",
                "The Minimalist Painter",
                "Change the array"
        };

        boolean exit = false;
        while (!exit) {
            System.out.println("\n🧮 ======= ARRAY OPERATIONS MENU =======");
            for (int i = 0; i < arrayOperations.length; i++) {
                System.out.println((i + 1) + "️⃣  " + arrayOperations[i]);
            }
            System.out.println("0️⃣  Terminate Program");
            System.out.println("========================================");
            System.out.print("👉 Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a number between 0 and 7.\n");
                continue;
            }

            System.out.println("----------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("🚀 You chose: " + arrayOperations[0]);
                    System.out.print("🔋 Enter initial energy: ");
                    try {
                        int initialEnergy = Integer.parseInt(input.nextLine());
                        int answer = nums.theEfficientTraveller(initialEnergy);
                        System.out.println("✅ Result (The Efficient Traveller): " + answer);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter a number.");
                    }
                    break;

                case 2:
                    System.out.println("🧮 You chose: " + arrayOperations[1]);
                    int sum = nums.getTheSumThatStandsOut();
                    System.out.println("📊 Result (Sum that stands out): " + sum);
                    break;

                case 3:
                    System.out.println("💡 You chose: " + arrayOperations[2]);
                    int count = nums.flipTheSwitch();
                    System.out.println("🔁 Total switches flipped: " + count);
                    break;

                case 4:
                    System.out.println("🌀 You chose: " + arrayOperations[3]);
                    int oddOne = nums.getTheOddOneOut();
                    if(oddOne == -1){
                        System.out.println("No odd one out found.");
                    }
                    else{
                        System.out.println("🔹 The odd one out is: " + oddOne);
                    }
                    break;

                case 5:
                    System.out.println("🤝 You chose: " + arrayOperations[4]);
                    System.out.print("🎯 Enter target value for pair finding: ");
                    try {
                        int target = Integer.parseInt(input.nextLine());
                        boolean found = nums.getThePair(target);
                        if (found)
                            System.out.println("✅ Pair found that sums to target!");
                        else
                            System.out.println("❌ No valid pair found.");
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid input! Please enter a valid number.");
                    }
                    break;

                case 6:
                    System.out.println("🎨 You chose: " + arrayOperations[5]);
                    int time = nums.getMinimumTime();
                    System.out.println("⏱️ Minimum time required: " + time);
                    break;

                case 7:
                    System.out.println("🔄 You chose: " + arrayOperations[6]);
                    System.out.println("📋 Let's update your array!");
                    for (int i = 0; i < number; i++) {
                        while (true) {
                            System.out.print("➡️ Enter new element at index " + i + ": ");
                            String arrayInput = input.nextLine();
                            try {
                                int num = Integer.parseInt(arrayInput);
                                nums.nums[i] = num;
                                System.out.println("✅ Updated index " + i + " with " + num);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("❌ Invalid input! Please enter digits only.");
                            }
                        }
                    }
                    System.out.println("✅ Array updated successfully!");
                    break;

                case 0:
                    System.out.println("👋 Terminating program... Thank you for using the Array Console!");
                    System.out.println("============================================");
                    exit = true;
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please select between 0 and 7.");
            }

            if (!exit) {
                System.out.println("\n🔁 Returning to main menu...\n");
            }
        }

        input.close();
    }
}

