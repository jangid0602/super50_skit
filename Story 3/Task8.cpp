/**
 * @filename - Task-8.cpp
 * @description - The Collapsing Count List
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <limits>
using namespace std;

struct Node {
    int value;
    int count;
    Node* next;
    Node(int v, int c) : value(v), count(c), next(nullptr) {}
};

bool readInt(int &x) {
    cin >> x;
    if (!cin) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        return false;
    }
    return true;
}

Node* collapse(Node* head) {
    if (!head) return nullptr;

    Node* newHead = nullptr;
    Node* newTail = nullptr;
    Node* current = head;

    while (current) {
        Node* nextNode = current->next;
        current->next = nullptr;

        if (!newHead) {
            newHead = newTail = current;
        }
        else if (newTail->value == current->value) {
            newTail->count += current->count;
            delete current;
        }
        else {
            newTail->next = current;
            newTail = current;
        }

        current = nextNode;
    }

    return newHead;
}

void printList(Node* head) {
    while (head) {
        cout << head->value << "(" << head->count << ") ";
        if (head->next) cout << "-> ";
        head = head->next;
    }
    cout << "\n";
}

int main() {
    int n;

    // simple validation
    do {
        cout << "Enter number of nodes: ";
    } while (!readInt(n) || n <= 0);

    Node* head = nullptr;
    Node* tail = nullptr;

    for (int i = 0; i < n; i++) {
        int value, count;

        cout << "Node " << i+1 << " value: ";
        while (!readInt(value)) cout << "Enter a valid integer: ";

        cout << "Node " << i+1 << " count: ";
        while (!readInt(count) || count < 0)
            cout << "Enter a non-negative integer: ";

        Node* node = new Node(value, count);
        if (!head) head = tail = node;
        else tail = tail->next = node;
    }

    cout << "\nOriginal List:\n";
    printList(head);

    head = collapse(head);

    cout << "\nCollapsed List:\n";
    printList(head);

    return 0;
}
