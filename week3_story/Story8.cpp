/**
 * @filename   : Story8.cpp
 * @description: Collapse adjacent linked list nodes having the same value
 *               by adding their counts.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

struct ListNode {
    char value;
    int count;
    ListNode* next;

    ListNode(char nodeValue, int nodeCount) {
        value = nodeValue;
        count = nodeCount;
        next = nullptr;
    }
};

// Collapses adjacent nodes with identical values
ListNode* collapseAdjacentNodes(ListNode* head) {

    if (head == nullptr)
        return nullptr;

    ListNode* currentNode = head;

    while (currentNode != nullptr && currentNode->next != nullptr) {

        if (currentNode->value == currentNode->next->value) {

            ListNode* duplicateNode = currentNode->next;
            currentNode->count += duplicateNode->count;
            currentNode->next = duplicateNode->next;
            delete duplicateNode;

        } else {
            currentNode = currentNode->next;
        }
    }

    return head;
}

// Prints the linked list
void printList(ListNode* head) {

    while (head != nullptr) {
        cout << "(" << head->value << ", " << head->count << ")";
        if (head->next != nullptr)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {

    int totalNodes;
    cout << "Enter number of nodes: ";
    cin >> totalNodes;

    if (totalNodes <= 0) {
        cout << "Invalid number of nodes" << endl;
        return 0;
    }

    ListNode* head = nullptr;
    ListNode* tail = nullptr;

    cout << "Enter nodes in format <char> <count>:\n";

    for (int i = 0; i < totalNodes; i++) {

        char inputValue;
        int inputCount;
        cin >> inputValue >> inputCount;

        ListNode* newNode = new ListNode(inputValue, inputCount);

        if (head == nullptr) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    cout << "\nBefore collapsing:\n";
    printList(head);

    head = collapseAdjacentNodes(head);

    cout << "\nAfter collapsing:\n";
    printList(head);

    return 0;
}
