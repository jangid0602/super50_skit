/**
 * @filename - Task-6.cpp
 * @description -  The Leaky Bucket Queue 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class LeakyBucket {
private:
    int maxCapacity;
    queue<int> bufferQueue;

public:
    LeakyBucket(int capacity) {
        maxCapacity = capacity;
    }

    void enqueue(int item) {
        if ((int)bufferQueue.size() == maxCapacity) {
            cout << "Bucket full! Dropping front item: " << bufferQueue.front() << "\n";
            bufferQueue.pop(); 
        }
        bufferQueue.push(item);
    }

    vector<int> process(int k) {
        vector<int> processedItems;

        while (k-- > 0 && !bufferQueue.empty()) {
            processedItems.push_back(bufferQueue.front());
            bufferQueue.pop();
        }

        return processedItems;
    }

    void printState() {
        queue<int> temp = bufferQueue;
        cout << "Current Bucket State: ";
        while (!temp.empty()) {
            cout << temp.front() << " ";
            temp.pop();
        }
        cout << "\n";
    }
};

int main() {
    int capacity;
    cout << "Enter bucket capacity: ";
    cin >> capacity;

    LeakyBucket bucket(capacity);

    int operations;
    cout << "Enter number of operations: ";
    cin >> operations;

    while (operations--) {
        int choice;
        cout << "\n1. Enqueue\n2. Process\nEnter choice: ";
        cin >> choice;

        if (choice == 1) {
            int item;
            cout << "Enter item to enqueue: ";
            cin >> item;
            bucket.enqueue(item);
            bucket.printState();
        }
        else if (choice == 2) {
            int k;
            cout << "Enter k (items to process): ";
            cin >> k;
            vector<int> result = bucket.process(k);

            cout << "Processed: ";
            for (int x : result) cout << x << " ";
            cout << "\n";

            bucket.printState();
        }
        else {
            cout << "Invalid option.\n";
        }
    }

    return 0;
}
