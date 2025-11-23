/**
 * @filename - Story9.cpp
 * @description -  The Zigzag Multi-Level Flatten
 * @author - Diya Garg
 */
#include <iostream>
#include <vector>
#include <limits>
using namespace std;

struct Node {
    int val;
    Node* prev;
    Node* next;
    Node* child;
    Node(int v) : val(v), prev(nullptr), next(nullptr), child(nullptr) {}
}; 

int readInt() {
    int x;
    while (!(cin >> x)) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid! Enter again: ";
    }
    return x;
}

Node* buildList() {
    cout << "Enter number of nodes in this level: ";
    int n = readInt();
    if (n <= 0) return nullptr;

    Node* head = nullptr;
    Node* tail = nullptr;

    for (int i = 0; i < n; i++) {
        cout << " Value of node " << i + 1 << ": ";
        int v = readInt();

        cout << " Does this node have a child? (0/1): ";
        int hasChild = readInt();
        while (hasChild != 0 && hasChild != 1) {
            cout << "Enter 0 or 1: ";
            hasChild = readInt();
        }

        Node* newNode = new Node(v);

        if (!head) head = tail = newNode;
        else {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }

        if (hasChild == 1) {
            cout << " Enter child list for node " << v << ":\n";
            newNode->child = buildList();
        }
    }

    return head;
}

Node* findTail(Node* head) {
    while (head && head->next) head = head->next;
    return head;
}

void flattenZigzag(Node* head, bool leftToRight, vector<int>& out) {
    if (!head) return;

    if (leftToRight) { 
        for (Node* cur = head; cur; cur = cur->next) {
            out.push_back(cur->val);
            if (cur->child) flattenZigzag(cur->child, !leftToRight, out);
        }
    } 
    else { 
        Node* tail = findTail(head);
        for (Node* cur = tail; cur; cur = cur->prev) {
            out.push_back(cur->val);
            if (cur->child) flattenZigzag(cur->child, !leftToRight, out);
        }
    }
}

int main() {
    cout << "Build the TOP-LEVEL list:\n";
    Node* head = buildList();

    vector<int> result;
    flattenZigzag(head, true, result);

    cout << "\nZigzag Flattened Output:\n";
    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << (i + 1 < result.size() ? "-" : "");
    }
    cout << "-NULL\n";

    return 0;
}
 