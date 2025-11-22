/**
 * @filename    - Task-8.cpp
 * @description - The Collapsing Count List
 * @Author - Ayushi Shukla
 */

#include <iostream>
using namespace std;

struct Node {
    char value;     // store character value like A, B, X, Y
    int count;
    Node* next;

    Node(char v, int c) : value(v), count(c), next(nullptr) {}
};

// Function to collapse adjacent nodes with same value
Node* collapse(Node* head) {
    if (!head) return nullptr;

    Node* newHead = nullptr;  // start of collapsed list
    Node* newTail = nullptr;  // end of collapsed list
    Node* current = head;

    while (current) {
        Node* nextNode = current->next; // store next
        current->next = nullptr;        // isolate current

        if (!newHead) {
            // First node becomes newHead
            newHead = newTail = current;
        }
        else if (newTail->value == current->value) {
            // Merge counts when value is same
            newTail->count += current->count;
            delete current; // delete merged node
        }
        else {
            // Add new distinct node
            newTail->next = current;
            newTail = current;
        }

        current = nextNode;
    }

    return newHead;
}

// Function to print list in A(2) -> B(1) style
void printList(Node* head) {
    while (head) {
        cout << head->value << "(" << head->count << ")";
        if (head->next) cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    int n;
    cout << "Enter number of nodes: ";
    cin >> n;

    if (n <= 0) {
        cout << "Invalid input.\n";
        return 0;
    }

    Node* head = nullptr;
    Node* tail = nullptr;

    for (int i = 0; i < n; i++) {
        char value;
        int count;

        cout << "Node " << i+1 << " value (A/B/X/Y etc.): ";
        cin >> value;

        cout << "Node " << i+1 << " count: ";
        cin >> count;

        Node* node = new Node(value, count);

        if (!head)
            head = tail = node;
        else {
            tail->next = node;
            tail = node;
        }
    }

    cout << "\nOriginal List:\n";
    printList(head);

    head = collapse(head);

    cout << "\nCollapsed List:\n";
    printList(head);

    return 0;
}
