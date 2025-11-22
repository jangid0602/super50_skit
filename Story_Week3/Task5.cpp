/**
 * @filename   : Task-5.cpp
 * @description: The Prime/Composite List Partition
 * @author     : Ayushi Shukla
 */

#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct Node
{
    int value;
    Node *next;
    Node(int val) : value(val), next(nullptr) {}
};

// Check if a number is prime
bool isPrime(int number)
{

    if (number <= 1)
        return false;
    if (number == 2)
        return true;
    if (number % 2 == 0)
        return false;

    for (int divisor = 3; divisor * divisor <= number; divisor += 2)
    {
        if (number % divisor == 0)
            return false;
    }
    return true;
}
// Partition the linked list into primes, composites, and ones
Node *partitionPrimes(Node *head)
{

    // Heads & tails for 3 linked lists
    Node *primeHead = nullptr, *primeTail = nullptr;
    Node *compositeHead = nullptr, *compositeTail = nullptr;
    Node *onesHead = nullptr, *onesTail = nullptr;

    Node *currentNode = head;

    while (currentNode != nullptr)
    {

        Node *nextNode = currentNode->next;
        currentNode->next = nullptr; // Detach the node

        if (currentNode->value == 1)
        {
            // 1 goes to separate "ones" list
            if (!onesHead)
                onesHead = onesTail = currentNode;
            else
            {
                onesTail->next = currentNode;
                onesTail = currentNode;
            }
        }
        else if (isPrime(currentNode->value))
        {
            // Prime list
            if (!primeHead)
                primeHead = primeTail = currentNode;
            else
            {
                primeTail->next = currentNode;
                primeTail = currentNode;
            }
        }
        else
        {
            // Composite list
            if (!compositeHead)
                compositeHead = compositeTail = currentNode;
            else
            {
                compositeTail->next = currentNode;
                compositeTail = currentNode;
            }
        }

        currentNode = nextNode;
    }

    // Combine the three lists
    Node *finalHead = nullptr;
    Node *finalTail = nullptr;

    // Attach primes
    if (primeHead)
    {
        finalHead = primeHead;
        finalTail = primeTail;
    }

    // Attach composites
    if (compositeHead)
    {
        if (!finalHead)
            finalHead = compositeHead;
        else
            finalTail->next = compositeHead;

        finalTail = compositeTail;
    }

    // Attach ones
    if (onesHead)
    {
        if (!finalHead)
            finalHead = onesHead;
        else
            finalTail->next = onesHead;
    }

    return finalHead;
}

// Build Linked List from vector
Node *buildList(const vector<int> &values)
{
    Node *head = nullptr, *tail = nullptr;

    for (int val : values)
    {
        Node *newNode = new Node(val);
        if (!head)
            head = tail = newNode;
        else
        {
            tail->next = newNode;
            tail = newNode;
        }
    }
    return head;
}

// Print Linked List
void printList(Node *head)
{
    while (head != nullptr)
    {
        cout << head->value;
        if (head->next)
            cout << " -> ";
        head = head->next;
    }
    cout << "\n";
}

// Main Function
int main()
{

    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    vector<int> values(numberOfNodes);
    cout << "Enter values:\n";
    for (int &val : values)
        cin >> val;

    Node *head = buildList(values);

    cout << "\nOriginal List:\n";
    printList(head);

    head = partitionPrimes(head);

    cout << "\nRearranged List (Primes → Composites → Ones):\n";
    printList(head);

    return 0;
}
