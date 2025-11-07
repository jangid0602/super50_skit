import java.util.*;

class Robot {
    String name;
    int battery;
    int[] coordinates = new int[2];
    String clone_name;
    int clone_battery;
    int[] clone_coordinates = new int[2];

    Robot() {
        name = null;
        battery = 0;
        coordinates[0] = 0;
        coordinates[1] = 0;
    }

    Robot(String name, int battery, int x, int y) {
        this.name = name;
        this.battery = battery;
        coordinates[0] = x;
        coordinates[1] = y;
    }

    void move(int dx, int dy) {
        coordinates[0] += dx;
        coordinates[1] += dy;
    }

    void clone_Robot() {
        this.clone_name = this.name;
        this.clone_battery = this.battery;
        this.clone_coordinates = this.coordinates;

    }

    void show() {
        System.out.println(
                "Battery" + ":" + battery + "," + "Position" + "(" + coordinates[0] + "," + coordinates[1] + ")");
        System.out.println("Clone_Battery" + ":" + clone_battery + "," + "Clone_Position" + "(" + clone_coordinates[0]
                + "," + clone_coordinates[1] + ")");
    }
}

public class Challenge1setaques2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int battery = 0, x = 0, y = 0;
        String name = "";

        System.out.println("enter in order : name battery coordinates");
        if (sc.hasNext()) {
            name = sc.nextLine();
        } else {
            System.out.println("wrong input");
        }
        if (sc.hasNextInt()) {
            battery = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();
        } else {
            System.out.println("wrong input");
        }
        Robot robo1 = new Robot(name, battery, x, y);
   while(true){
        System.out.println("1.Move");
        System.out.println("2.show");
        System.out.println("3.exit");
        int ch = 0;
        if (sc.hasNextInt()) {
            ch = sc.nextInt();
            switch (ch) {

                case 1:
                    int dx = 0, dy = 0;
                    if (sc.hasNextInt()) {
                        dx = sc.nextInt();
                        dy = sc.nextInt();
                    } else {
                        System.out.println("wrong");
                    }
                    robo1.move(dx, dy);
                    break;
                case 2:
                    robo1.show();
                    case 3:System.out.println("exiting");
                    System.exit(0);
            }

        }
    }
}
}