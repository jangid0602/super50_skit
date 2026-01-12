import java.util.*;

class Robot {
    private String name;
    private int battery;
    private int x, y;

    public Robot(String name, int battery, int x, int y) {
        this.name = name;
        this.battery = battery;
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public Robot clone() {
        return new Robot(this.name + "_copy", this.battery, this.x, this.y);
    }

    public String getDetails() {
        return name + " (Battery: " + battery + ", Position: (" + x + ", " + y + "))";
    }
}

public class main {

    public static int readInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            
            boolean isValid = true;
            if (input.isEmpty()) isValid = false;
            
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c) && c != '-') { // allow negative values
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue;
            }

            return Integer.parseInt(input);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Robot original = null;
        Robot clone = null;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. CREATE Robot");
            System.out.println("2. MOVE Robot");
            System.out.println("3. CLONE Robot");
            System.out.println("4. SHOW Robots");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            try {
                switch (choice) {

                    case "1":  // CREATE
                        System.out.print("Enter Robot Name: ");
                        String name = sc.nextLine();

                        int battery = readInt(sc, "Enter Battery: ");
                        int x = readInt(sc, "Enter X position: ");
                        int y = readInt(sc, "Enter Y position: ");

                        original = new Robot(name, battery, x, y);
                        System.out.println("Robot Created Successfully!");
                        break;

                    case "2":  // MOVE
                        if (original == null)
                            throw new IllegalStateException("No robot found! Create robot first.");

                        int dx = readInt(sc, "Enter dx: ");
                        int dy = readInt(sc, "Enter dy: ");

                        original.move(dx, dy);
                        System.out.println("Robot Moved Successfully!");
                        break;

                    case "3":  // CLONE
                        if (original == null)
                            throw new IllegalStateException("No robot found! Create robot first.");
                        clone = original.clone();
                        System.out.println("Robot Cloned Successfully!");
                        break;

                    case "4": // SHOW
                        if (original == null)
                            throw new IllegalStateException("No robot found!");
                        System.out.println("Original: " + original.getDetails());
                        if (clone != null)
                            System.out.println("Clone: " + clone.getDetails());
                        else
                            System.out.println("No Clone exists yet.");
                        break;

                    case "5": // EXIT
                        System.out.println("Exiting Program...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }
    }
}
