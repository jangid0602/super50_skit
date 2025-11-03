package Test1;

public class Robot {
    String name;
    int battery;
    int[] position = new int[2];

    Robot(String name , int battery , int[] position){
        this.name = name;
        this.battery = battery;
        this.position = position;
    }
}
