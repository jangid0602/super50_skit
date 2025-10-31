import java.util.*; 

public class Main {

    
    static void getInputArray(int nums[], int size, Scanner sc) {
        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    System.out.print("Enter element " + (i + 1) + ": ");
                    nums[i] = sc.nextInt();  
                    break;  
                } catch (Exception e) {
                    System.out.println("Invalid input! Try again.");
                    sc.next(); 
                }
            }
        }
    }

   
    static void printArray(int nums[], int size) {
        System.out.print("Array elements are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int choice, size;
        int nums[];

        
        while (true) {
            try {
                
                System.out.println("1. Efficient Traveler");
                System.out.println("2. Sum that stands out");
                System.out.println("3. Flip the switch");
                System.out.println("4. Odd one out");
                System.out.println("5. Smart pair finder");
                System.out.println("6. Minimalist Painter");
                System.out.println("7. OOPs");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt(); 

                
                switch (choice) {

                    //Efficient Traveler
                    case 1:
                        System.out.print("Enter size of array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        System.out.print("Enter initial energy: ");
                        int initEnergy = sc.nextInt();
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Farthest city index: " + Method.efficientTraveler(nums, initEnergy));
                        System.out.println("");
                        break;

                    //Sum that stands out
                    case 2:
                        System.out.print("Enter size of array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Prefix sum stands out at index: " + Method.sumThatStandOuts(nums));
                        System.out.println("");
                        break;

                    //Flip the switch
                    case 3:
                        System.out.print("Enter size of array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Minimum number of flips required: " + Method.numberOfFlips(nums));
                        System.out.println("");
                        break;

                    //Odd one out
                    case 4:
                        System.out.print("Enter size of array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Number with no repetition: " + Method.oddOneOut(nums));
                        System.out.println("");
                        break;

                    //Smart pair finder
                    case 5:
                        System.out.print("Enter size of array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        System.out.print("Enter target: ");
                        int target = sc.nextInt();
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Smart pair exists?: " + Method.smartPairFinder(nums, target));
                        System.out.println("");
                        break;

                    //Minimalist Painter
                    case 6:
                        System.out.print("Enter size of time array: ");
                        size = sc.nextInt();
                        nums = new int[size];
                        getInputArray(nums, size, sc);
                        printArray(nums, size);
                        System.out.println("Minimum time after skipping: " + Method.minimalistPainter(nums));
                        System.out.println("");
                        break;

                    //OOPs program
                    case 7:
                        int x1, y1, x2, y2, dx, dy, radius, side;
                        System.out.print("Enter point p1 (x y): ");
                        x1 = sc.nextInt();
                        y1 = sc.nextInt();
                        System.out.print("Enter point p2 (x y): ");
                        x2 = sc.nextInt();
                        y2 = sc.nextInt();

                        Point p1 = new Point(x1, y1);
                        Point p2 = new Point(x2, y2);

                        //distance between points
                        double distance = p1.distance(p2);
                        System.out.println("Distance between p1 and p2: " + distance);

                        //Translation of point
                        System.out.print("Enter translation factors dx and dy: ");
                        dx = sc.nextInt();
                        dy = sc.nextInt();
                        System.out.println("Original: " + p1);
                        p1.translate(dx, dy);
                        System.out.println("Translated: " + p1);

                        // Circle and Square area
                        System.out.print("Enter radius of circle: ");
                        radius = sc.nextInt();
                        System.out.print("Enter side of square: ");
                        side = sc.nextInt();
                        Circle c1 = new Circle(radius);
                        Square s1 = new Square(side);
                        System.out.println("Area of circle: " + c1.getArea());
                        System.out.println("Area of square: " + s1.getArea());
                        System.out.println("");
                        break;

                    // Exit
                    case 8:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                
                System.out.println("Invalid input! Please try again.");
                sc.nextLine(); 
            }
        }
    }
}
