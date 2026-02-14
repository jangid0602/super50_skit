import java.util.Scanner;

public class Main {

    static void getInputArray(int nums[], int size) {
        Scanner sc = new Scanner(System.in);
        int element;
        for (int i = 0; i < size; i++) {
            System.out.println("Enter elements:");
            element = sc.nextInt();
            nums[i] = element;
        }
        sc.close();
    }

    static void printArray(int nums[], int size) {
        System.out.println("Array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int choice;
        int nums[];
        int size;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Efficient Traveler\n2.Sum that stands out\n3.Flip the swiych\n4.Odd one out\n5.Smart pair finder\n6.Minimalist Painter\n7.OOPs\n8.Exit\n");
            System.out.println("Enter choice");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter size of array");
                    size = sc.nextInt();
                    nums = new int[size];
                    System.out.println("Enter initial energy");
                    int initEnergy = sc.nextInt();
                    getInputArray(nums, size);
                    System.out.println("Farthest city index:" + Methods.efficientTraveler(nums, initEnergy));
                    break;
                case 2:
                    System.out.println("Enter size of array");
                    size = sc.nextInt();
                    nums = new int[size];
                    getInputArray(nums, size);
                    System.out.println("Prefix sum stands out at index:" + Methods.sumThatStandOuts(nums));
                    break;
                case 3:
                    System.out.println("Enter size of array");
                    size = sc.nextInt();
                    nums = new int[size];
                    getInputArray(nums, size);
                    System.out.println("Mininum number of flips required:" + Methods.numberOfFlips(nums));
                    break;
                case 4:
                    System.out.println("Enter size of array");
                    size = sc.nextInt();
                    nums = new int[size];
                    getInputArray(nums, size);
                    System.out.println("Number with no repetition:" + Methods.oddOneOut(nums));
                    break;
                case 5:
                    System.out.println("Enter size of array");
                    size = sc.nextInt();
                    nums = new int[size];
                    System.out.println("Enter target");
                    int target = sc.nextInt();
                    getInputArray(nums, size);
                    System.out.println("Smart pair exits?:" + Methods.smartPairFinder(nums, target));
                    break;
                case 6:
                    System.out.println("Enter size of time array");
                    size = sc.nextInt();
                    nums = new int[size];
                    getInputArray(nums, size);
                    System.out.println("Minimum time after skipping:" + Methods.minimalistPainter(nums));
                    break;
                case 7:
                    int x1, y1, x2, y2, dx, dy, radius, side;
                    System.out.println("Enter point p1(x,y)");
                    x1 = sc.nextInt();
                    y1 = sc.nextInt();
                    System.out.println("Enter point p2(x,y)");
                    x2 = sc.nextInt();
                    y2 = sc.nextInt();
                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    double distance = p1.distance(p2);
                    System.out.println("Distance between p1 and p2:" + distance);
                    System.out.println("Enter scaling factors dx and dy");
                    dx = sc.nextInt();
                    dy = sc.nextInt();
                    System.out.println("Original:" + p1);
                    p1.translate(dx, dy);
                    System.out.println("Translated:" + p1);
                    System.out.println("Enter radius of circle");
                    radius = sc.nextInt();
                    System.out.println("Enter side of square");
                    side = sc.nextInt();
                    Circle c1 = new Circle(radius);
                    Square s1 = new Square(side);
                    System.out.println("Area of circle:" + c1.getArea());
                    System.out.println("Area of square:" + s1.getArea());
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
            sc.close();
        }

    }
}
