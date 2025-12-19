/**
 * @filename   : Story5.cpp
 * @description: Rearrange a linked list so that prime numbers come first,
 *                followed by composite numbers, and finally ones.
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;

    Node(int v) {
        value = v;
        next = nullptr;
    }
};


bool checkPrime(int num) {

    if(num < 2) return false;

    for(int i = 2; i * i <= num; i++) {
        if(num % i == 0)
            return false;
    }
    return true;
}


Node* partitionPrimeComposite(Node* head) {

    Node *primeStart = nullptr, *primeEnd = nullptr;
    Node *compositeStart = nullptr, *compositeEnd = nullptr;
    Node *oneStart = nullptr, *oneEnd = nullptr;

    Node* current = head;

    while(current != nullptr) {

        Node* nextNode = current->next;
        current->next = nullptr;

        if(current->value == 1) {

            if(oneStart == nullptr)
                oneStart = oneEnd = current;
            else {
                oneEnd->next = current;
                oneEnd = current;
            }

        } else if(checkPrime(current->value)) {

            if(primeStart == nullptr)
                primeStart = primeEnd = current;
            else {
                primeEnd->next = current;
                primeEnd = current;
            }

        } else {

            if(compositeStart == nullptr)
                compositeStart = compositeEnd = current;
            else {
                compositeEnd->next = current;
                compositeEnd = current;
            }
        }

        current = nextNode;
    }

   
    Node* newHead = nullptr;
    Node* tail = nullptr;

    if(primeStart != nullptr) {
        newHead = primeStart;
        tail = primeEnd;
    }

    if(compositeStart != nullptr) {
        if(newHead == nullptr)
            newHead = compositeStart;
        else
            tail->next = compositeStart;

        tail = compositeEnd;
    }

    if(oneStart != nullptr) {
        if(newHead == nullptr)
            newHead = oneStart;
        else
            tail->next = oneStart;

        tail = oneEnd;
    }

    return newHead;
}


void displayList(Node* head) {

    while(head != nullptr) {
        cout << head->value;
        if(head->next != nullptr)
            cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {

    int totalNodes;
    cout << "Enter number of nodes: ";
    cin >> totalNodes;

    Node* head = nullptr;
    Node* tail = nullptr;

    cout << "Enter elements: ";
    for(int i = 0; i < totalNodes; i++) {
        int data;
        cin >> data;

        Node* newNode = new Node(data);
        if(head == nullptr) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    cout << "\nOriginal List:\n";
    displayList(head);

    head = partitionPrimeComposite(head);

    cout << "\nRearranged List (Primes -> Composites -> Ones):\n";
    displayList(head);

    return 0;
}
