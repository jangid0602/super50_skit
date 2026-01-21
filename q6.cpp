// Node Swap by Value
// Explanation: Iterate through the list. If you find a node with value $X$, swap it with the node
// immediately following it. This requires careful pointer manipulation to ensure the previous
// node now points to the new neighbor.
// Test Cases:
// 1. Input: 1 -> 2 -> 3 -> 4, X = 2 → Output: 1 -> 3 -> 2 -> 4
// 2. Input: 5 -> 6 -> 5 -> 7, X = 5 → Output: 6 -> 5 -> 7 -> 5
// 3. Input: 1 -> 2, X = 2 → Output: 1 -> 2 (No successor to swap with)

#include <iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(nullptr) {}
};
ListNode* swapNodesByValue(ListNode* head, int X) {
    if (!head || !head->next) return head;

    ListNode* dummy = new ListNode(0);
    dummy->next = head;
    ListNode* prev = dummy;
    ListNode* curr = head;

    while (curr && curr->next) {
        if (curr->val == X) {
            ListNode* nextNode = curr->next;
            // Swap nodes
            curr->next = nextNode->next;
            nextNode->next = curr;
            prev->next = nextNode;

            // Move pointers forward
            prev = curr;
            curr = curr->next;
        } else {
            prev = curr;
            curr = curr->next;
        }
    }

    head = dummy->next;
    delete dummy;
    return head;
}
void printList(ListNode* head) {
    ListNode* curr = head;
    while (curr) {
        cout << curr->val;
        if (curr->next) cout << " -> ";
        curr = curr->next;
    }
    cout << endl;
}
int main() {
    cout<<"Enter number of nodes in the linked list: ";
    int n;
    cin >> n;
    ListNode* head = nullptr;
    ListNode* tail = nullptr;
    cout<<"Enter the node values: ";
    for (int i = 0; i < n; ++i) {
        int val;
        cin >> val;
        ListNode* newNode = new ListNode(val);
        if (!head) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    int X;
    cout << "Enter the value X to swap nodes: ";
    cin >> X;

    cout << "Original list: ";
    printList(head);

    head = swapNodesByValue(head, X);

    cout << "List after swapping nodes with value " << X << ": ";
    printList(head);

    // Free memory
    while (head) {
        ListNode* temp = head;
        head = head->next;
        delete temp;
    }

    return 0;
}
