#include <bits/stdc++.h>
using namespace std;
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) {
        val = x;
        next = NULL;
    }
};
ListNode* swapNodesByValue(ListNode* head, int X) {
    if (!head || !head->next) return head;

    ListNode* prev = NULL;
    ListNode* curr = head;

    while (curr && curr->next) {
        if (curr->val == X) {
            ListNode* next = curr->next;

            // Case 1: swapping at head
            if (curr == head) {
                curr->next = next->next;
                next->next = curr;
                head = next;
            }
            // Case 2: swapping in middle
            else {
                curr->next = next->next;
                next->next = curr;
                prev->next = next;
            }

            // move pointers after swap
            prev = curr;
            curr = curr->next;
        } else {
            prev = curr;
            curr = curr->next;
        }
    }
    return head;
}

// Function to print linked list
void printList(ListNode* head) {
    while (head) {
        cout << head->val;
        if (head->next) cout << " -> ";
        head = head->next;
    }
}

int main() {
    int n;
    cin >> n;

    if (n == 0) return 0;

    int x;
    cin >> x;
    ListNode* head = new ListNode(x);
    ListNode* tail = head;

    for (int i = 1; i < n; i++) {
        cin >> x;
        tail->next = new ListNode(x);
        tail = tail->next;
    }

    int X;
    cin >> X;

    head = swapNodesByValue(head, X);

    printList(head);
    return 0;
}
