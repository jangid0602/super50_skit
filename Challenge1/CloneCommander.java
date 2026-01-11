package Challenge1;

import java.util.Scanner;

public class CloneCommander {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Robot original = new Robot("Robo1", 100, 0, 0);
        Robot clone = null;

        while (sc.hasNext()) {
            String command = sc.next();

            switch (command.toUpperCase()) {
                case "MOVE":
                    int dx = sc.nextInt();
                    int dy = sc.nextInt();
                    original.move(dx, dy);
                    System.out.println("Original Robot:");
                    original.show();
                    break;

                case "CLONE":
                    clone = original.clone();
                    System.out.println("Original Robot:");
                    original.show();
                    break;

                case "SHOW":
                    System.out.println("Original Robot:");
                    original.show();
                    if (clone != null) {
                        System.out.println("Cloned Robot:");
                        clone.show();
                    }
                    break;

                default:
                    System.out.println("Invalid command ..");
            }
        }

        sc.close();
    }
}
