/**
 * @filename - Task-7.cpp
 * @description - The Midpoint Finder
 * @author - Diya Garg
 */
#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

int main() {
    int numberOfNodes;
    cout << "Enter number of nodes: ";
    cin >> numberOfNodes;

    Node* headNode = NULL;
    Node* tailNode = NULL;

    for (int index = 1; index <= numberOfNodes; index++) {
        Node* newNode = new Node();

        cout << "Enter value : ";
        cin >> newNode->data;

        newNode->next = NULL;

        if (headNode == NULL) {
            headNode = newNode;
            tailNode = newNode;
        } else {
            tailNode->next = newNode;
            tailNode = newNode;
        }
    }

    cout << "Middle node of the linked list is :";

    Node* slowPointer = headNode;
    Node* fastPointer = headNode;

    while (fastPointer && fastPointer->next) {
        slowPointer = slowPointer->next;
        fastPointer = fastPointer->next->next;
    }

    cout << slowPointer->data;
    return 0;
}