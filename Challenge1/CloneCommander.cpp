#include <iostream>
#include <string>
using namespace std;

class Robot {
public:
    string name;
    int battery;
    int x_coordinate;
    int y_coordinate;

    // Constructor
    Robot(string n, int b, int x, int y) {
        name = n;
        battery = b;
        x_coordinate = x;
        y_coordinate = y;
    }

    // Move function
    void move(int dx, int dy) {
        x_coordinate += dx;
        y_coordinate += dy;
    }

    // Modify function
    void modify(string newName, int newBattery, int newX, int newY) {
        name = newName;
        battery = newBattery;
        x_coordinate = newX;
        y_coordinate = newY;
    }

    // Clone function
    Robot clone() {
        // Create and return a new Robot with same data
        return Robot(name, battery, x_coordinate, y_coordinate);
    }

    // Display
    void show() {
        cout << "Name: " << name << ", Battery: " << battery
             << ", Position: (" << x_coordinate << ", " << y_coordinate << ")\n";
    }
};

int main() {
    Robot r1("Alpha", 100, 0, 0);

    cout << "Original Robot:\n";
    r1.show();

    // Clone the robot
    Robot r2 = r1.clone();

    cout << "\nAfter Cloning:\n";
    cout << "Clone Robot:\n";
    r2.show();

    // Modify clone
    r2.modify("Beta", 80, 5, 5);

    cout << "\nAfter Modifying Clone:\n";
    cout << "Clone Robot:\n";
    r2.show();

    cout << "Original Robot (Unchanged):\n";
    r1.show();

    return 0;
}
