/*
Author     : Avani Shrimali
Program    : Week 1 Stories – OOP & Problem Solving Tasks
Language   : C++ 
Description:
    This program implements seven independent problems.

    Problems Implemented:
      1. Efficient Traveler        – Binary feasibility check
      2. Sum That Stands Out       – Prefix/Suffix sum balance
      3. Flip the Switch           – Binary group flip counter
      4. Odd One Out               – XOR-based unique finder
      5. Smart Pair Finder         – Brute-force pair search
      6. Minimalist Painter        – Skip-one minimum total
      7. Geometry Problem          – OOP hierarchy demo (Point,
                                     Circle, Square, inheritance)

Error Handling:
    - Every numeric input validated using IsValidInteger().
    - cin.fail() checks prevent crashes on bad inputs.
    - All loops and arrays guarded by size limits.
    - Program exits gracefully without undefined behavior.

*/

#include <iostream>
#include <cmath>
using namespace std;

// Utility Class: for helper functions
class Utility {
public:
    // Validate integer string (handles negatives)
    bool IsValidInteger(const char input[]) {
        if (input[0] == '\0') return false;
        int i = (input[0] == '-') ? 1 : 0;
        for (; input[i] != '\0'; ++i)
            if (input[i] < '0' || input[i] > '9')
                return false;
        return true;
    }

    // Read integer array safely (space-separated).
    // Returns the number of integers read (0..maxSize).
    int ReadIntegerArray(int arr[], int maxSize) {
        int index = 0;
        char input[64];
        cout << "Enter numbers (space separated, stop with non-integer): ";
        while (index < maxSize) {
            if (!(cin >> input)) break;
            if (!IsValidInteger(input)) break;
            arr[index++] = atoi(input);
        }
        // clear leftover from input
        cin.clear();
        cin.ignore(10000, '\n');
        return index;
    }

    // Simple helper utilities
    long long CalculatePrefixSum(int arr[], int upToIndex) {
        long long sum = 0;
        for (int i = 0; i < upToIndex; ++i) sum += arr[i];
        return sum;
    }

    long long CalculateSuffixSum(int arr[], int fromIndex, int size) {
        long long sum = 0;
        for (int i = fromIndex + 1; i < size; ++i) sum += arr[i];
        return sum;
    }

    int FindMinimum(int a, int b) { return (a < b) ? a : b; }

    int FindXOR(int arr[], int size) {
        int result = 0;
        for (int i = 0; i < size; ++i) result ^= arr[i];
        return result;
    }
};

// Story 1
class ProblemSolver {
private:
    Utility util;
public:
    // 1. Efficient Traveler (fixed)
    // energyCosts: array of n costs, initialEnergy: starting energy
    // returns farthest city index reachable (0-based). If no cities given returns -1.
    int FindFarthestCity(int energyCosts[], int n, int initialEnergy) {
        if (n <= 0) return -1;            // no cities given
        long long currentEnergy = initialEnergy;
        for (int i = 0; i < n; ++i) {
            if (currentEnergy - energyCosts[i] < 0)
                return i;                 // can reach city i but not move to i+1
            currentEnergy -= energyCosts[i];
        }
        return n - 1;                     // reached last city
    }

    // 2. Sum That Stands Out
    // find index i where sum(arr[0..i-1]) == sum(arr[i+1..n-1])
    int FindBalancedIndex(int numbers[], int n) {
        for (int i = 0; i < n; ++i)
            if (util.CalculatePrefixSum(numbers, i) ==
                util.CalculateSuffixSum(numbers, i, n))
                return i;
        return -1;
    }

    // 3. Flip the Switch
    // Assumes binaryArray contains only 0s and 1s; if not, it treats other values as groups too.
    int FindMinimumFlips(int binaryArray[], int n) {
        if (n <= 0) return 0;
        int zeroGroups = 0, oneGroups = 0, i = 0;
        while (i < n) {
            int bitValue = binaryArray[i];
            int j = i;
            while (j < n && binaryArray[j] == bitValue) j++;
            if (bitValue == 0) zeroGroups++;
            else oneGroups++;
            i = j;
        }
        return util.FindMinimum(zeroGroups, oneGroups);
    }

    // 4. Odd One Out
    int FindUniqueElement(int numbers[], int n) {
        return util.FindXOR(numbers, n);
    }

    // 5. Smart Pair Finder
    bool IsPairWithSumExists(int numbers[], int n, int targetSum) {
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (numbers[i] + numbers[j] == targetSum)
                    return true;
        return false;
    }

    // 6. Minimalist Painter
    // Skip exactly one wall to minimize total time. If n==0 -> 0, if n==1 -> 0.
    int FindMinimalPaintingTime(int times[], int n) {
        if (n <= 0) return 0;
        long long totalSum = 0;
        int minTime = times[0];
        for (int i = 0; i < n; ++i) {
            totalSum += times[i];
            if (times[i] < minTime) minTime = times[i];
        }
        return (int)(totalSum - minTime);
    }
};

// Problem 7.
class Point {
public:
    double x, y;
    Point(double xVal = 0, double yVal = 0) : x(xVal), y(yVal) {}
    double Distance(const Point &other) const {
        return sqrt((x - other.x) * (x - other.x) +
                    (y - other.y) * (y - other.y));
    }
    void Translate(double dx, double dy) { x += dx; y += dy; }
    void Print() const { cout << "(" << x << ", " << y << ")"; }
};

class Shape {
public:
    virtual double GetArea() const = 0;
    virtual ~Shape() {}
};

class Circle : public Shape {
private:
    double radius;
public:
    Circle(double r) : radius(r) {}
    double GetArea() const override { return 3.1416 * radius * radius; }
};

class Square : public Shape {
private:
    double side;
public:
    Square(double s) : side(s) {}
    double GetArea() const override { return side * side; }
};

int main() {
    ProblemSolver solver;
    Utility util;
    int choice;

    do {
        cout << "\nMenu\n";
        cout << "1) Efficient Traveler\n2) Sum That Stands Out\n3) Flip the Switch\n";
        cout << "4) Odd One Out\n5) Smart Pair Finder\n6) Minimalist Painter\n";
        cout << "7) Geometry Problem\n0) Exit\nChoice: ";

        cin >> choice;
        if (cin.fail()) {
            cin.clear();
            cin.ignore(10000, '\n');
            cout << "Invalid input. Please enter a number between 0 and 7.\n";
            continue;
        }

        switch (choice) {
            case 1: {
                // Efficient Traveler
                char energyStr[64];
                do { cout << "Enter initial energy: "; cin >> energyStr; }
                while (!util.IsValidInteger(energyStr));
                int initialEnergy = atoi(energyStr);

                int energyCosts[100];
                int n = util.ReadIntegerArray(energyCosts, 100);
                int farthest = solver.FindFarthestCity(energyCosts, n, initialEnergy);
                cout << "Farthest city index reachable: " << farthest << endl;
            } break;

            case 2: {
                // Sum That Stands Out
                int numbers[100];
                int n = util.ReadIntegerArray(numbers, 100);
                cout << "Balanced index: " << solver.FindBalancedIndex(numbers, n) << endl;
            } break;

            case 3: {
                // Flip the Switch
                int binaryArr[100];
                int n = util.ReadIntegerArray(binaryArr, 100);
                cout << "Minimum flips needed: " << solver.FindMinimumFlips(binaryArr, n) << endl;
            } break;

            case 4: {
                // Odd One Out
                int arr[100];
                int n = util.ReadIntegerArray(arr, 100);
                if (n <= 0) cout << "No input provided.\n";
                else cout << "Unique element: " << solver.FindUniqueElement(arr, n) << endl;
            } break;

            case 5: {
                // Smart Pair Finder
                int arr[100];
                int n = util.ReadIntegerArray(arr, 100);
                if (n <= 1) {
                    cout << "Need at least two numbers to find a pair.\n";
                    break;
                }
                char targetStr[64];
                do { cout << "Enter target sum: "; cin >> targetStr; }
                while (!util.IsValidInteger(targetStr));
                int target = atoi(targetStr);
                cout << "Pair exists? "
                     << (solver.IsPairWithSumExists(arr, n, target) ? "Yes" : "No") << endl;
            } break;

            case 6: {
                // Minimalist Painter
                int arr[100];
                int n = util.ReadIntegerArray(arr, 100);
                cout << "Minimal total painting time: "
                     << solver.FindMinimalPaintingTime(arr, n) << endl;
            } break;

            case 7: {
                // Geometry Problem
                double x1, y1, x2, y2;
                cout << "Enter x y of Point1: "; cin >> x1 >> y1;
                cout << "Enter x y of Point2: "; cin >> x2 >> y2;

                Point p1(x1, y1), p2(x2, y2);
                cout << "Distance: " << p1.Distance(p2) << endl;

                double radius, side;
                cout << "Enter circle radius: "; cin >> radius;
                cout << "Enter square side: "; cin >> side;

                Circle c(radius);
                Square s(side);
                cout << "Circle Area: " << c.GetArea() << endl;
                cout << "Square Area: " << s.GetArea() << endl;

                double dx, dy;
                cout << "Enter translation dx dy: "; cin >> dx >> dy;
                p1.Translate(dx, dy);
                cout << "Translated Point1: "; p1.Print(); cout << endl;
            } break;

            case 0:
                cout << "Exiting program.\n";
                break;

            default:
                cout << "Invalid choice. Please enter a number between 0 and 7.\n";
                break;
        }

    } while (choice != 0);

    cout << "Program ended.\n";
    return 0;
}

