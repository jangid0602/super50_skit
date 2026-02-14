/**
 * @filename - Story6.cpp
 * @description -  leaky Bucket Algorithm
 * @author - Fatimi Bee
 */

#include <iostream>
#include <vector>
using namespace std;

class LeakyBucket {
public:
    int capacity;
    vector<int> q;
    int front, rear, size;

    LeakyBucket(int c) {
        capacity = c;
        q.resize(capacity);
        front = 0;
        rear = 0;
        size = 0;
    }

    void enqueue(int item) {
        if (size == capacity) { // Queue full → drop (dequeue) front item
            front = (front + 1) % capacity;
            size--;
        }
        q[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    vector<int> process(int k) {
        vector<int> out;
        int count = min(k, size);

        for (int i = 0; i < count; i++) {
            out.push_back(q[front]);
            front = (front + 1) % capacity;
            size--;
        }
        return out;
    }
};

int main() {
    int capacity;
    cout << "Enter bucket capacity: ";
    cin >> capacity;

    LeakyBucket leakybucket(capacity);

    int choice;

    while (true) {
        cout << "\n----- MENU -----\n";
        cout << "1. Enqueue item\n";
        cout << "2. Process k items\n";
        cout << "3. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch (choice) {

            case 1: {
                int x;
                cout << "Enter item to enqueue: ";
                cin >> x;
                leakybucket.enqueue(x);
                cout << "Item added!\n";
                break;
            }

            case 2: {
                int k;
                cout << "Enter k: ";
                cin >> k;

                vector<int> result = leakybucket.process(k);

                cout << "Processed items: ";
                if (result.empty())
                    cout << "None";
                else
                    for (int v : result) cout << v << " ";
                cout << endl;
                break;
            }

            case 3:
                cout << "Exiting program...\n";
                return 0;

            default:
                cout << "Invalid choice! Try again.\n";
        }
    }

    return 0;
}
