import java.util.*;

public class Cloner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Robot original = null;
        Robot clone = null;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.equals("")) continue;
            String[] parts = line.split(" ");

            switch (parts[0]) {

                case "CREATE":
                    String name = parts[1];
                    int battery = Integer.parseInt(parts[2]);
                    int x = Integer.parseInt(parts[3]);
                    int y = Integer.parseInt(parts[4]);
                    original = new Robot(name, battery, x, y);
                    break;

                case "MOVE":
                    int dx = Integer.parseInt(parts[1]);
                    int dy = Integer.parseInt(parts[2]);
                    if (clone != null) clone.move(dx, dy);
                    else original.move(dx, dy);
                    break;

                case "CLONE":
                    clone = original.cloneRobot();
                    break;

                case "SHOW":
                    System.out.println("Original: " + original);
                    if (clone != null) System.out.println("Clone: " + clone);
                    break;
            }
        }
        sc.close();
    }
}
