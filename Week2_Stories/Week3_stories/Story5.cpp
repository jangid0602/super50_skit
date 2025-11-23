/**
 * @filename - Story5.cpp
 * @description - Prim Composite list partition
 * @author - Diya Garg
 */

#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) : data(x), next(NULL) {}
};

// Check if number is prime
bool isPrime(int number) {
    if (number < 2) return false;
    for (int i = 2; i * i <= number; i++)
        if (number % i == 0)
            return false;
    return true;
}

Node* partitionPrimes(Node* head) {
    Node *primeHead = NULL, *primeTail = NULL;
    Node *compositeHead = NULL, *compositeTail = NULL;
    Node *oneHead = NULL, *oneTail = NULL;

    Node* curr = head;

    while (curr != NULL) {
        Node* next = curr->next;
        curr->next = NULL;

        if (curr->data == 1) {
            if (!oneHead) oneHead = oneTail = curr;
            else oneTail->next = curr, oneTail = curr;

        } else if (isPrime(curr->data)) {
            if (!primeHead) primeHead = primeTail = curr;
            else primeTail->next = curr, primeTail = curr;

        } else {
            if (!compositeHead) compositeHead = compositeTail = curr;
            else compositeTail->next = curr, compositeTail = curr;
        }

        curr = next;
    }

    // Connect lists: prime → composite → ones
    Node* newHead = NULL;
    Node* tail = NULL;

    if (primeHead) newHead = primeHead, tail = primeTail;
    if (compositeHead) {
        if (!newHead) newHead = compositeHead;
        else tail->next = compositeHead;
        tail = compositeTail;
    }
    if (oneHead) {
        if (!newHead) newHead = oneHead;
        else tail->next = oneHead;
        tail = oneTail;
    }

    return newHead;
}

void printList(Node* head) {
    while (head) {
        cout << head->data;
        if (head->next) cout << " -> ";
        head = head->next;
    }
    cout << endl;
}

int main() {
    int nodes;
    cout << "Enter number of nodes: ";
    cin >> nodes;

    Node* head = NULL;
    Node* tail = NULL;

    cout << "Enter elements: ";
    for (int i = 0; i < nodes; i++) {
        int x;
        cin >> x;
        Node* temp = new Node(x);
        if (!head) head = tail = temp;
        else tail->next = temp, tail = temp;
    }

    cout << "\nOriginal List:\n";
    printList(head);

    head = partitionPrimes(head);

    cout << "\nRearranged List (Primes → Composites → Ones):\n";
    printList(head);

    return 0;
}
 