/*
------------------------------------------------------------
    Topic : OOP – Inheritance, Method Overriding, 
             Encapsulation, Function Overloading
    Problem Title : The Geometry Hierarchy
    Description : Program to demonstrate OOP concepts by 
                  modeling geometric objects in a hierarchy
------------------------------------------------------------
*/

#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

/*------------------------------------------------------------
   Base Class → Point
   Represents a point in 2D plane with coordinates (x, y)
   Demonstrates: Encapsulation, Function Overloading concept
------------------------------------------------------------*/
class Point {
private:
    float x, y;  // Encapsulated attributes

public:
    // Constructor to initialize coordinates
    Point(float x = 0, float y = 0) {
        this->x = x;
        this->y = y;
    }

    // Method to calculate Euclidean distance between two points
    float distance(Point other) {
        float dx = x - other.x;
        float dy = y - other.y;
        return sqrt(dx * dx + dy * dy);
    }

    // Method to move (translate) the point by dx, dy
    void translate(float dx, float dy) {
        x += dx;
        y += dy;
    }

    // Display function to print coordinates in (x, y) format
    void display() {
        cout << fixed << setprecision(1);
        cout << "(" << x << ", " << y << ")";
    }
};

/*------------------------------------------------------------
   Abstract Class → Shape
   Represents a generic geometric shape.
   Demonstrates: Inheritance (Base Class for Circle & Square)
------------------------------------------------------------*/
class Shape {
public:
    // Pure virtual function to be overridden by derived classes
    virtual float get_area() = 0;
};

/*------------------------------------------------------------
   Derived Class → Circle
   Inherits from Shape
   Demonstrates: Inheritance, Method Overriding, Encapsulation
------------------------------------------------------------*/
class Circle : public Shape {
private:
    float radius;  // Encapsulated attribute

public:
    // Constructor to initialize radius
    Circle(float r) {
        radius = r;
    }

    // Override get_area() to calculate area of circle
    float get_area() override {
        return 3.14159f * radius * radius;
    }
};

/*------------------------------------------------------------
   Derived Class → Square
   Inherits from Shape
   Demonstrates: Inheritance, Method Overriding, Encapsulation
------------------------------------------------------------*/
class Square : public Shape {
private:
    float side;  // Encapsulated attribute

public:
    // Constructor to initialize side length
    Square(float s) {
        side = s;
    }

    // Override get_area() to calculate area of square
    float get_area() override {
        return side * side;
    }
};

/*------------------------------------------------------------
   Main Function
   Demonstrates all OOP concepts and required functionalities
------------------------------------------------------------*/
int main() {
    float x1, y1, x2, y2;   // Coordinates for two points
    float radius, side;     // Circle radius & square side
    float dx, dy;           // Translation values

    // ---------- Input Section ----------
    cout << "Enter coordinates of first and second point (x1 y1 x2 y2): ";
    cin >> x1 >> y1 >> x2 >> y2;

    cout << "Enter radius of circle: ";
    cin >> radius;

    cout << "Enter side of square: ";
    cin >> side;

    cout << "Enter translation values (dx dy): ";
    cin >> dx >> dy;

    // ---------- Creating Objects ----------
    Point p1(x1, y1);
    Point p2(x2, y2);

    // ---------- Calculations ----------
    float dist = p1.distance(p2);   // Distance between points

    Circle c(radius);               // Circle object
    Square s(side);                 // Square object

    // ---------- Output Section ----------
    cout << fixed << setprecision(2);
    cout << "\nDistance: " << dist << endl;
    cout << "Circle Area: " << c.get_area() << endl;
    cout << "Square Area: " << s.get_area() << endl;

    // Translate point 1
    p1.translate(dx, dy);
    cout << "Translated Point1: ";
    p1.display();

    return 0;
}

