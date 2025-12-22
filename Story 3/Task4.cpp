/**
 * @filename - Task-4.cpp
 * @description - The K-Zipline Merge 
 * @author - Disha Toshniwal 
 */
#include <iostream>
#include <vector>
using namespace std;

struct Node {
    int val;
    Node* next;
    Node(int v) : val(v), next(nullptr) {}
};

Node* buildList(const vector<int>& arr) {
    Node* head = nullptr;
    Node* tail = nullptr;
    for (int x : arr) {
        Node* n = new Node(x);
        if (!head) head = tail = n;
        else tail = tail->next = n;
    }
    return head;
}

void printList(Node* head) {
    while (head) {
        cout << head->val << (head->next ? " " : "");
        head = head->next;
    }
    cout << "\n";
}

Node* takeK(Node*& head, int k) {
    if (!head) return nullptr;
    Node* start = head;
    Node* prev = nullptr;
    while (head && k--) {
        prev = head;
        head = head->next;
    }
    if (prev) prev->next = nullptr; 
    return start;
}

Node* kZiplineMerge(Node* a, Node* b, int k) {
    Node* result = nullptr;
    Node* tail = nullptr;
    bool turnA = true;

    while (a || b) {
        Node* chunk = turnA ? takeK(a, k) : takeK(b, k);
        turnA = !turnA;

        if (!chunk) continue; 

        if (!result) result = tail = chunk;
        else {
            tail->next = chunk;
        }

        while (tail->next) tail = tail->next; 
    }

    return result;
}

int main() {
    int n1, n2, k;

    cout << "Enter size of list1: ";
    cin >> n1;
    vector<int> v1(n1);
    cout << "Enter list1 values:\n";
    for (int& x : v1) cin >> x;

    cout << "Enter size of list2: ";
    cin >> n2;
    vector<int> v2(n2);
    cout << "Enter list2 values:\n";
    for (int& x : v2) cin >> x;

    cout << "Enter k: ";
    cin >> k;

    Node* head1 = buildList(v1);
    Node* head2 = buildList(v2);

    cout << "\nList1: ";
    printList(head1);
    cout << "List2: ";
    printList(head2);

    Node* merged = kZiplineMerge(head1, head2, k);

    cout << "\nMerged List: ";
    printList(merged);

    return 0;
}
