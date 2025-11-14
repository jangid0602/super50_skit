/**
 * @filename - Task-5.cpp
 * @description - The Prime/Composite List Partition 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

struct Node {
    int value;
    Node* next;
    Node(int v) : value(v), next(nullptr) {}
};

// Check if a number is prime
bool isPrime(int number) {
    if (number <= 1) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;

    for (int divisor = 3; divisor * divisor <= number; divisor += 2)
        if (number % divisor == 0) return false;

    return true;
}

Node* partitionPrimes(Node* head) {

    Node* primeHead = nullptr;
    Node* primeTail = nullptr;

    Node* compositeHead = nullptr;
    Node* compositeTail = nullptr;

    Node* onesHead = nullptr;
    Node* onesTail = nullptr;

    Node* current = head;

    while (current) {
        Node* nextNode = current->next;
        current->next = nullptr;     

        if (current->value == 1) {
            if (!onesHead) onesHead = onesTail = current;
            else onesTail = onesTail->next = current;
        }
        else if (isPrime(current->value)) {
            if (!primeHead) primeHead = primeTail = current;
            else primeTail = primeTail->next = current;
        }
        else {
            if (!compositeHead) compositeHead = compositeTail = current;
            else compositeTail = compositeTail->next = current;
        }

        current = nextNode;
    }

    Node* newHead = nullptr;
    Node* mergeTail = nullptr;

    if (primeHead) {
        newHead = primeHead;
        mergeTail = primeTail;
    }

    if (compositeHead) {
        if (!newHead) newHead = compositeHead;
        if (mergeTail) mergeTail->next = compositeHead;
        mergeTail = compositeTail;
    }

    if (onesHead) {
        if (!newHead) newHead = onesHead;
        if (mergeTail) mergeTail->next = onesHead;
    }

    return newHead;
}

Node* buildList(const vector<int>& values) {
    Node* head = nullptr;
    Node* tail = nullptr;
    for (int v : values) {
        Node* newNode = new Node(v);
        if (!head) head = tail = newNode;
        else tail = tail->next = newNode;
    }
    return head;
}

void printList(Node* head) {
    while (head) {
        cout << head->value << (head->next ? " -> " : "");
        head = head->next;
    }
    cout << "\n";
}

int main() {
    int listSize;

    cout << "Enter number of nodes: ";
    cin >> listSize;

    vector<int> inputValues(listSize);
    cout << "Enter values:\n";
    for (int &x : inputValues) cin >> x;

    Node* head = buildList(inputValues);

    cout << "\nOriginal List:\n";
    printList(head);

    head = partitionPrimes(head);

    cout << "\nRearranged List (Primes → Composites → Ones):\n";
    printList(head);

    return 0;
}
