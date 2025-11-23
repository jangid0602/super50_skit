/**
 * @filename - Story4.cpp
 * @description -  K-Zipline Mege
 * @author - Diya Garg
 */

#include <iostream>
using namespace std;

// Node structure
struct Node {
    string data;
    Node* next;
    Node(string x) : data(x), next(nullptr) {}
};

// Insert node at end
Node* insertEnd(Node* head, string data) {
    if (!head) return new Node(data);
    Node* temporary = head;
    while (temporary->next) temporary = temporary->next;
    temporary->next = new Node(data);
    return head;
}

// Print linked list
void printList(Node* head) {
    while (head) {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

// K-Zipline Merge Function
Node* KZiplineMerge(Node* head1, Node* head2, int k) {
    if (!head1) return head2;
    if (!head2) return head1;

    Node* dummy = new Node("");
    Node* tail = dummy;

    Node* current1 = head1;
    Node* current2 = head2;

    bool takeFromFirst = true;

    while (current1 || current2) {
        int count = 0;

        if (takeFromFirst) {
            while (current1 && count < k) {
                tail->next = current1;
                tail = tail->next;
                current1 = current1->next;
                count++;
            }
        } else {
            while (current2 && count < k) {
                tail->next = current2;
                tail = tail->next;
                current2 = current2->next;
                count++;
            }
        }

        takeFromFirst = !takeFromFirst;
    }

    tail->next = nullptr;
    Node* newHead = dummy->next;
    delete dummy;
    return newHead;
}

int main() {
    int node1, node2, k;
    string value;

    Node *head1 = nullptr, *head2 = nullptr;

    // List 1 input
    cout << "Enter number of nodes in List 1: ";
    cin >> node1;
    cout << "Enter elements (numbers or alphabets):\n";
    for (int i = 0; i < node1; i++) {
        cin >> value;
        head1 = insertEnd(head1, value);
    }

    // List 2 input
    cout << "Enter number of nodes in List 2: ";
    cin >> node2;
    cout << "Enter elements (numbers or alphabets):\n";
    for (int i = 0; i < node2; i++) {
        cin >> value;
        head2 = insertEnd(head2, value);
    }

    cout << "Enter value of k: ";
    cin >> k;

    // Merge
    Node* merged = KZiplineMerge(head1, head2, k);

    // Output
    cout << "Merged List: ";
    printList(merged);

    return 0;
}
 