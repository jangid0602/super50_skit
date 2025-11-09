import java.util.Scanner;

public class TheGeometryHierarchy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("🎯 Welcome to The Geometry Hierarchy Program!");
        System.out.println("==============================================");
        System.out.println("This program can perform various geometric computations such as:");
        System.out.println("• Calculating distance between two points");
        System.out.println("• Translating a point");
        System.out.println("• Calculating the area of a Circle");
        System.out.println("• Calculating the area of a Square");
        System.out.println("==============================================\n");

        boolean exit = false;
        while (!exit) {
            System.out.println("\n📚 MENU:");
            System.out.println("1️⃣  Calculate distance between two points");
            System.out.println("2️⃣  Translate a point");
            System.out.println("3️⃣  Find the area of a Circle");
            System.out.println("4️⃣  Find the area of a Square");
            System.out.println("0️⃣  Exit Program");
            System.out.print("👉 Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input! Please enter a number (0-4).");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.println("\n📏 DISTANCE BETWEEN TWO POINTS");
                    try {
                        System.out.print("Enter x1: ");
                        int x1 = Integer.parseInt(input.nextLine());
                        System.out.print("Enter y1: ");
                        int y1 = Integer.parseInt(input.nextLine());
                        System.out.print("Enter x2: ");
                        int x2 = Integer.parseInt(input.nextLine());
                        System.out.print("Enter y2: ");
                        int y2 = Integer.parseInt(input.nextLine());

                        Point p1 = new Point(x1, y1);
                        Point p2 = new Point(x2, y2);
                        int distance = p1.getDistance(p2);

                        System.out.println("➡️ Point 1: " + p1);
                        System.out.println("➡️ Point 2: " + p2);
                        System.out.println("✅ Distance between them: " + distance);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter integers only.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("\n🧭 TRANSLATE A POINT");
                    try {
                        System.out.print("Enter initial x coordinate: ");
                        int x = Integer.parseInt(input.nextLine());
                        System.out.print("Enter initial y coordinate: ");
                        int y = Integer.parseInt(input.nextLine());

                        Point p = new Point(x, y);
                        System.out.println("Original Point: " + p);

                        System.out.print("Enter dx (change in x): ");
                        int dx = Integer.parseInt(input.nextLine());
                        System.out.print("Enter dy (change in y): ");
                        int dy = Integer.parseInt(input.nextLine());

                        p.translatePoint(dx, dy);
                        System.out.println("✅ Translated Point: " + p);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter integers only.");
                    }
                    break;
                }

                case 3: {
                    System.out.println("\n⚪ CIRCLE AREA CALCULATION");
                    try {
                        System.out.print("Enter the radius of the circle: ");
                        double radius = Double.parseDouble(input.nextLine());
                        Circle c = new Circle(radius);
                        System.out.println("✅ Circle radius: " + c.getRadius());
                        System.out.println("📐 Area of the Circle: " + c.getArea());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter a numeric value.");
                    }
                    break;
                }

                case 4: {
                    System.out.println("\n⬛ SQUARE AREA CALCULATION");
                    try {
                        System.out.print("Enter the side length of the square: ");
                        double side = Double.parseDouble(input.nextLine());
                        Square s = new Square(side);
                        System.out.println("✅ Square side length: " + s.getSide());
                        System.out.println("📐 Area of the Square: " + s.getArea());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Please enter a numeric value.");
                    }
                    break;
                }

                case 0:
                    System.out.println("\n👋 Exiting The Geometry Hierarchy Program...");
                    System.out.println("==============================================");
                    exit = true;
                    break;

                default:
                    System.out.println("⚠️ Invalid choice! Please select between 0 and 4.");
            }

            if (!exit) {
                System.out.println("\n🔁 Returning to main menu...\n");
            }
        }

        input.close();
    }
}
