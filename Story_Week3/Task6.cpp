/**
 * @filename   : Task-6.cpp
 * @description: The Leaky Bucket Queue (Network Buffer Simulation)
 * @author : Ayushi Shukla
 */

#include <iostream>
#include <queue>
#include <vector>
using namespace std;

class LeakyBucket
{
private:
    int capacityLimit;         // maximum items allowed in bucket
    queue<string> bufferQueue; // internal queue storing items

public:
    // Constructor
    LeakyBucket(int capacity)
    {
        capacityLimit = capacity;
    }

    // Enqueue item with leaky behavior
    void enqueue(const string &item)
    {
        if ((int)bufferQueue.size() == capacityLimit)
        {
            // Drop the oldest item
            bufferQueue.pop();
        }
        bufferQueue.push(item);
    }

    // Process k items from front
    vector<string> process(int k)
    {
        vector<string> processedItems;

        while (k-- > 0 && !bufferQueue.empty())
        {
            processedItems.push_back(bufferQueue.front());
            bufferQueue.pop();
        }
        return processedItems;
    }

    // Print queue state
    void printState() const
    {
        queue<string> tempQueue = bufferQueue;
        cout << "Current Bucket: ";
        while (!tempQueue.empty())
        {
            cout << tempQueue.front() << " ";
            tempQueue.pop();
        }
        cout << "\n";
    }
};

// Driver code

int main()
{
    int capacityValue;
    cout << "Enter bucket capacity: ";
    cin >> capacityValue;

    LeakyBucket bucket(capacityValue);

    int totalOperations;
    cout << "Enter number of operations: ";
    cin >> totalOperations;

    while (totalOperations--)
    {
        int operationType;
        cout << "\n1. Enqueue\n2. Process\nEnter choice: ";
        cin >> operationType;

        if (operationType == 1)
        {
            string item;
            cout << "Enter item to enqueue: ";
            cin >> item;

            bucket.enqueue(item);
            bucket.printState();
        }
        else if (operationType == 2)
        {
            int k;
            cout << "Enter k (items to process): ";
            cin >> k;

            vector<string> output = bucket.process(k);
            cout << "Processed: ";
            for (const string &x : output)
                cout << x << " ";
            cout << "\n";

            bucket.printState();
        }
        else
        {
            cout << "Invalid operation. Try again.\n";
        }
    }

    return 0;
}
