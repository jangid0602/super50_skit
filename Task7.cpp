// @Filename - Task7.cpp
// @Description - The Geometry Hierarchy
// @Author - Ayushi Shukla
#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

//Base class
class Point {
private:
    float x, y;  

public:
    // Constructor Overloading
    Point() : x(0), y(0) {}
    Point(float x, float y) {
        this->x = x;
        this->y = y;
    }

    // Distance between two points
    float distance(Point other) {
        return sqrt(pow(x - other.x, 2) + pow(y - other.y, 2));
    }

    // Translate the point by dx and dy
    void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    // Display coordinates
    void display() const {
        cout << "(" << fixed << setprecision(1) << x << ", " << y << ")";
    }
};

//Base Class: Shape 
class Shape {
public:
    // Virtual method (to be overridden)
    virtual float get_area() const = 0;
};

//Derived Class: Circle 
class Circle : public Shape {
private:
    float radius;

public:
    Circle(float radius) {
        this->radius = radius;
    }

    // Override get_area()
    float get_area() const override {
        return M_PI * radius * radius;
    }
};

// Derived Class: Square 
class Square : public Shape {
private:
    float side;

public:
    Square(float side) {
        this->side = side;
    }

    // Override get_area()
    float get_area() const override {
        return side * side;
    }
};

//Main Function
int main() {
    float x1, y1, x2, y2, radius, side, dx, dy;

    // Input
    cout<<"Enter coordintes of point1 (x1,y1) : ";
    cin >> x1 >> y1 ;

    cout<<"Enter coordinates of point2 (x2,y2) : ";
    cin >> x2 >> y2 ;
    cout<<"Enter radius of circle: ";
    cin >> radius;
    cout<<"Enter side of square: ";
    cin >> side;
    cout<<"Enter translation values (dx ,dy) : ";
    cin >> dx >> dy;

    // Create objects
    Point p1(x1, y1), p2(x2, y2);
    Circle c(radius);
    Square s(side);

    // Compute and print
    cout << fixed << setprecision(2);
    cout << "Distance: " << p1.distance(p2) << endl;
    cout << "Circle Area: " << c.get_area() << endl;
    cout << "Square Area: " << s.get_area() << endl;

    p1.translate(dx, dy);
    cout << "Translated Point1: ";
    p1.display();
    cout << endl;

    return 0;
}