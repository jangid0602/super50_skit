#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

// ---------------------------
// Base Class → Point
// ---------------------------
class Point {
private:
    float x, y;

public:
    // Constructor
    Point(float x = 0, float y = 0) {
        this->x = x;
        this->y = y;
    }

    // Compute Euclidean distance between two points
    float distance(const Point &other) const {
        float dx = x - other.x;
        float dy = y - other.y;
        return round(sqrt(dx * dx + dy * dy) * 100) / 100;  // Rounded to 2 decimal places
    }

    // Translate (move) the point
    void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    // Display in format (x, y)
    void display() const {
        cout << fixed << setprecision(1);
        cout << "(" << x << ", " << y << ")";
    }
};

// ---------------------------
// Abstract Base Class → Shape
// ---------------------------
class Shape {
public:
    virtual float getArea() const = 0;  // Pure virtual function
    virtual ~Shape() {} // Virtual destructor
};

// ---------------------------
// Derived Class → Circle
// ---------------------------
class Circle : public Shape {
private:
    float radius;

public:
    Circle(float r) { radius = r; }

    float getArea() const override {
        return round(M_PI * radius * radius * 100) / 100;
    }
};

// ---------------------------
// Derived Class → Square
// ---------------------------
class Square : public Shape {
private:
    float side;

public:
    Square(float s) { side = s; }

    float getArea() const override {
        return round(side * side * 100) / 100;
    }
};

// ---------------------------
// Main Function
// ---------------------------
int main() {
    float x1, y1, x2, y2;
    cin >> x1 >> y1 >> x2 >> y2;

    float r, s;
    cin >> r >> s;

    float dx, dy;
    cin >> dx >> dy;

    // Create Points
    Point p1(x1, y1);
    Point p2(x2, y2);

    // Compute distance
    cout << fixed << setprecision(1);
    cout << "Distance: " << p1.distance(p2) << endl;

    // Create Shapes
    Circle c(r);
    Square sq(s);

    cout << fixed << setprecision(2);
    cout << "Circle Area: " << c.getArea() << endl;
    cout << "Square Area: " << sq.getArea() << endl;

    // Translate p1
    p1.translate(dx, dy);
    cout << "Translated Point1: ";
    p1.display();
    cout << endl;

    return 0;
}
