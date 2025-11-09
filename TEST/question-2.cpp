#include <iostream>
#include <string>
using namespace std;

class Robot {
public:
    string name;
    int battery;
    pair<int, int> position;

    // Constructor
    Robot(string n, int b, int x, int y) {
        name = n;
        battery = b;
        position = {x, y};
    }

    // Move robot
    void move(int dx, int dy) {
        position.first += dx;
        position.second += dy;
    }

    // Clone robot
    Robot clone() {
        Robot temp = *this;         // copy current robot
        temp.name = name + "_copy"; // rename clone
        return temp;
    }

    // Display robot details
    void show(string label) {
        cout << label << ": " << name
             << " | Battery: " << battery
             << " | Position: (" << position.first << ", " 
             << position.second << ")" << endl;
    }
};

int main() {
    Robot *original = nullptr;
    Robot *clone = nullptr;

    int choice;
    do {
        cout << "\n----- Robot Menu -----\n";
        cout << "1. CREATE Robot\n";
        cout << "2. MOVE Robot\n";
        cout << "3. CLONE Robot\n";
        cout << "4. SHOW Robots\n";
        cout << "5. EXIT\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                string name;
                int battery, x, y;
                cout << "Enter name, battery, x, y: ";
                cin >> name >> battery >> x >> y;
                original = new Robot(name, battery, x, y);
                cout << "Robot created successfully!\n";
                break;
            }

            case 2: {
                int dx, dy;
                cout << "Enter move dx and dy: ";
                cin >> dx >> dy;
                if (clone) clone->move(dx, dy);
                else if (original) original->move(dx, dy);
                else cout << "No robot found!\n";
                break;
            }

            case 3: {
                if (original) {
                    clone = new Robot(original->clone());
                    cout << "Robot cloned successfully!\n";
                } else cout << "No original robot to clone!\n";
                break;
            }

            case 4: {
                if (original) original->show("Original");
                if (clone) clone->show("Clone");
                break;
            }

            case 5:
                cout << "Exiting program.\n";
                break;

            default:
                cout << "Invalid choice! Try again.\n";
        }

    } while (choice != 5);

    return 0;
}
