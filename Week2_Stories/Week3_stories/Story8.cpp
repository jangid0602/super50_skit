/**
 * @filename - Story8.cpp
 * @description -  Collapsing count list
 * @author - Diya Garg
 */

#include <iostream>
using namespace std;

// Linked List Node Structure
struct ListNode {
    char value;
    int count;
    ListNode* next;
    ListNode(char value, int count) : value(value), count(count), next(nullptr) {}
};

// Function to collapse adjacent nodes with same value
ListNode* collapse(ListNode* head) {
    if (!head) return nullptr;

    ListNode* current = head;
    while (current && current->next) {
        if (current->value == current->next->value) {
            ListNode* nodeToDelete = current->next;
            current->count += nodeToDelete->count; // Merge counts
            current->next = nodeToDelete->next; // Remove node
            delete nodeToDelete;
        } else {
            current = current->next; // Move forward
        }
    }
    return head;
}

// Print Linked List
void printList(ListNode* head) {
    while (head) {
        cout << "(" << head->value << ", " << head->count << ") ";
        if (head->next) cout << "-> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    int nodeCount;
    cout << "Enter number of nodes: ";
    cin >> nodeCount;

    if (nodeCount <= 0) {
        cout << "Invalid number of nodes!" << endl;
        return 0;
    }

    ListNode* head = nullptr;
    ListNode* tail = nullptr;

    cout << "Enter the nodes in format: <char> <count> (Example: A 2)" << endl;

    for (int i = 0; i < nodeCount; i++) {
        char value;
        int count;
        cout << "Node " << i + 1 << ": ";
        cin >> value >> count;

        ListNode* newNode = new ListNode(value, count);

        if (!head) {  
            head = newNode;
            tail = newNode;
        } else {       
            tail->next = newNode;
            tail = newNode;
        }
    }

    cout << "\nBefore collapsing:" << endl;
    printList(head);

    head = collapse(head);

    cout << "\nAfter collapsing:" << endl;
    printList(head);

    return 0;
}
