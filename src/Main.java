/**
 * <p>This is the main class which will provide a menu to user to select a problem based on array</p>
 * @Author- Aaditya Jain*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scannerObj = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n==============================");
                System.out.println("Choose the Problem to Solve:");
                System.out.println("==============================");
                System.out.println("1. The Efficient Traveller");
                System.out.println("2. The Sum That Stands Out");
                System.out.println("3. Flip the Switch");
                System.out.println("4. The Odd One Out");
                System.out.println("5. Smart Pair Finder");
                System.out.println("6. The Minimalist Painter");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");

                problemSolver solve = null;

                if (!scannerObj.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scannerObj.next();
                    continue;
                }

                int option = scannerObj.nextInt();

                switch (option) {
                    case 1 -> solve = new TheEfficientTraveller();
                    case 2 -> solve = new TheSumThatStandOut();
                    case 3 -> solve = new FlipTheSwitch();
                    case 4 -> solve = new TheOddOneOut();
                    case 5 -> solve = new SmartPairFinder();
                    case 6 -> solve = new TheMinimalistPainter();
                    case 7 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid Option!! Please choose a number between 1 and 7.");
                        continue;
                    }
                }


                solve.inputArray();
                solve.solver();
            }
        }
    }
}