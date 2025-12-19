/**
 * @filename - Task-7.cpp
 * @description - The Midpoint Finder
 * @author - Avani Shrimali
 */

#include <iostream>
#include <string>

using namespace std;

/*
    Node represents a single element in the linked list.
    It stores a string so it can safely hold:
    - letters
    - numbers
    - mixed input
*/
class Node {
public:
    string dataValue;
    Node* nextNode;

    Node(string value) {
        dataValue = value;
        nextNode = NULL;
    }
};

/*
    LinkedListManager handles:
    - insertion
    - midpoint detection
    - safety checks
*/
class LinkedListManager {
private:
    Node* headNode;

public:
    LinkedListManager() {
        headNode = NULL;
    }

    // Adds a node at the end of the list
    void insertNode(string value) {
        Node* newNode = new Node(value);

        if (headNode == NULL) {
            headNode = newNode;
            return;
        }

        Node* traversalNode = headNode;
        while (traversalNode->nextNode != NULL) {
            traversalNode = traversalNode->nextNode;
        }

        traversalNode->nextNode = newNode;
    }

    /*
        Finds the middle node using slow & fast pointer technique.
        If list length is even, returns second middle.
    */
    string findMiddleValue() {
        if (headNode == NULL) {
            return "EMPTY_LIST";
        }

        Node* slowPointer = headNode;
        Node* fastPointer = headNode;

        while (fastPointer != NULL && fastPointer->nextNode != NULL) {
            slowPointer = slowPointer->nextNode;
            fastPointer = fastPointer->nextNode->nextNode;
        }

        return slowPointer->dataValue;
    }
};

int main() {
    LinkedListManager listManager;

    cout << "Enter number of elements: ";
    int numberOfElements;
    cin >> numberOfElements;

    // Safety check for invalid or zero input
    if (numberOfElements <= 0) {
        cout << "List is empty. No midpoint exists." << endl;
        return 0;
    }

    cout << "Enter elements (letters / numbers / mixed allowed):" << endl;

    for (int index = 0; index < numberOfElements; index++) {
        string inputValue;
        cin >> inputValue;   // safe: reads token, ignores spaces
        listManager.insertNode(inputValue);
    }

    string middleValue = listManager.findMiddleValue();

    if (middleValue == "EMPTY_LIST") {
        cout << "No midpoint found." << endl;
    } else {
        cout << "Middle element: " << middleValue << endl;
    }

    return 0;
}

