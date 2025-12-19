public class Robot {
    private String name;
    private int battery;
    private int[] position;

    public Robot(String name, int battery, int x, int y) {
        this.name = name;
        this.battery = battery;
        this.position = new int[]{x, y};
    }

    public void move(int dx, int dy) {
        position[0] += dx;
        position[1] += dy;
    }

   
    public Robot cloneRobot() {
        return new Robot(this.name + "_copy", this.battery, this.position[0], this.position[1]);
    }

    public String toString() {
        return name + " (Battery: " + battery + ", Position: (" + position[0] + ", " + position[1] + "))";
    }
}
