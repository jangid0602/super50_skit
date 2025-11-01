#include <iostream>
#include <cmath>
#include <limits>
#include <stdexcept>
using namespace std;

class Point
{

    float x;
    float y;

public:
    Point() : x(0.0), y(0.0) {}

    Point(float inputX, float inputY)
    {
        x = inputX;
        y = inputY;
    }

    float distance(const Point nextPoint)
    {
        return sqrt(pow(nextPoint.x - x, 2) + pow(nextPoint.y - y, 2));
    }

    void translate(float dx, float dy)
    {
        x += dx;
        y += dy;
    }

    void display()
    {
        cout << '(' << x << "," << y << ')' << endl;
    }
};

class Shape
{
public:
    virtual float get_area() const = 0;
};

class Circle : public Shape
{
    float radius;

public:
    Circle(float radius) : radius(radius) {};

    // Overriding get_area()
    float get_area() const override
    {

        // M_pi is pie(3.1415)
        return M_PI * radius * radius;
    }
};

class Square : public Shape
{
    float side;

public:
    Square(float side) : side(side) {};

    // Overriding get_area()
    float get_area() const override
    {
        return side * side;
    }
};

float getValidatedInput()
{
    float x;

    while (true)
    {
        cin >> x;

        if (cin.fail())
        {
            cin.clear();
            cin.ignore(numeric_limits<std::streamsize>::max(), '\n');
            throw invalid_argument("Invalid input! Please enter a number input");
        }else{
            break;
        }
    }
    return x;
}

int main()
{
   try
    {
        float x1, y1, x2, y2, radius, side, dx, dy;

        cout << "Enter coordintes of point1 (x1,y1) : ";
        x1 = getValidatedInput();
        y1 = getValidatedInput();

        cout << "Enter coordinates of point2 (x2,y2) : ";
        x2 = getValidatedInput();
        y2 = getValidatedInput();

        cout << "Enter radius of circle: ";
        radius = getValidatedInput();

        cout << "Enter side of square: ";
        side = getValidatedInput();

        cout << "Enter translation values (dx ,dy) : ";
        dx = getValidatedInput();
        dy = getValidatedInput();

        Point point1(x1,y1), point2(x2,y2);
        
        cout << "Distance: " << point1.distance(point2) << endl;

        point1.translate(dx, dy);
        cout << "Translated point1 is now: "<<endl;
        point1.display();

        Circle c(radius);
        Square s(side);

        cout << "Circle Area: " << c.get_area() << endl;
        cout << "Square Area: " << s.get_area() << endl;



    }catch (const invalid_argument& e) {
            cout << e.what() << endl;
            cout << "Please try again.\n";
        }
    return 0;
}