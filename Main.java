import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter size of array: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.nextLine();
                continue;
            }

            n = scanner.nextInt();

            if (n <= 0) {
                System.out.println("Invalid input! Size must be a positive integer.");
                continue;
            }
            else if(n>10000000){
                System.out.println("Array size too large!");
                continue;
            }
            break;
        }

        int[] arr = new int[n];

        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++) {
            do {
                if (scanner.hasNextInt()) {
                    arr[i] = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Invalid input! Please enter an integer.");
                    scanner.next();
                }
            } while (true);
        }

        Myarray obj = new Myarray(arr, n);

        int choice;
        do {
            System.out.println(
                    "\n====== MENU ======\n" +
                            "1. Efficient Traveller\n" +
                            "2. Prefix Equal Suffix\n" +
                            "3. Flip Switch\n" +
                            "4. Single Number\n" +
                            "5. Smart Pair Finder\n" +
                            "6. Minimalist Painter\n" +
                            "7. Exit\n" +
                            "Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter initial energy: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter an integer.");
                        scanner.nextLine();
                        break;
                    }
                    int initialEnergy = scanner.nextInt();
                    int result1 = obj.efficientTraveller(initialEnergy);
                    System.out.println(result1 == -1 ? "Invalid input!" : "the farthest city index can reach: " + result1);
                    break;

                case 2:
                    int result2=obj.prefixEqualSuffix();
                    System.out.println(result2==-1?result2+" no such index exit":"Index where prefixsum equals the suffixsum : " +result2 );
                    break;

                case 3:
                    int result3 = obj.flipSwitch();
                    System.out.println(result3 == -1 ? "Array is not valid" : "Minimum number of flips: " + result3);
                    break;

                case 4:
                    int result4 = obj.singleNumber();
                    System.out.println(result4 == -1 ? "Array is not valid" : "Single element: " + result4);
                    break;

                case 5:
                    System.out.print("Enter target: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter an integer.");
                        scanner.nextLine();
                        break;
                    }
                    int k = scanner.nextInt();
                    System.out.println(obj.smartPairFinder(k) ? "True! smart pair exist" : "False! smart pair not exist");
                    break;

                case 6:
                    int result6 = obj.minimalistPainter();
                    System.out.println(result6 == -1 ? "Invalid input!" : "Minimum total time after skipping one wall: " + result6);
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
