/**
 * @filename    - Story7.cpp
 * @description - The Geometry Hierarchy
 * @author      - Ehtesham Nawaz
 */
#include <iostream>
using namespace std;

class Point {
private:
    float x, y;

    double customSqrt(double value) {
        if (value == 0 || value == 1) return value;
        double low = 0, high = value, mid, ans = 0;
        for (int i = 0; i < 100; i++) {
            mid = (low + high) / 2;
            if (mid * mid <= value) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        return ans;
    }

public:
    Point() : x(0), y(0) {}
    Point(float x, float y) {
        this->x = x;
        this->y = y;
    }

    float distance(Point other) {
        double dx = x - other.x;
        double dy = y - other.y;
        return customSqrt(dx * dx + dy * dy);
    }

    void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    void display() const {
        cout << "(" << x << ", " << y << ")";
    }
};

class Shape {
public:
    virtual float get_area() const = 0;
};

class Circle : public Shape {
private:
    float radius;
    const double PI = 3.141592653589793;
public:
    Circle(float radius) {
        this->radius = radius;
    }
    float get_area() const override {
        return PI * radius * radius;
    }
};

class Square : public Shape {
private:
    float side;
public:
    Square(float side) {
        this->side = side;
    }
    float get_area() const override {
        return side * side;
    }
};

int main() {
    float x1, y1, x2, y2, radius, side, dx, dy;

    cout << "Enter coordinates of point1 (x1 y1): ";
    cin >> x1 >> y1;
    cout << "Enter coordinates of point2 (x2 y2): ";
    cin >> x2 >> y2;
    cout << "Enter radius of circle: ";
    cin >> radius;
    cout << "Enter side of square: ";
    cin >> side;
    cout << "Enter translation values (dx dy): ";
    cin >> dx >> dy;

    Point p1(x1, y1), p2(x2, y2);
    Circle c(radius);
    Square s(side);

    cout << "Distance: " << p1.distance(p2) << endl;
    cout << "Circle Area: " << c.get_area() << endl;
    cout << "Square Area: " << s.get_area() << endl;

    p1.translate(dx, dy);
    cout << "Translated Point1: ";
    p1.display();
    cout << endl;
}
