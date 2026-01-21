#include <bits/stdc++.h>
using namespace std;
struct Node {
    int val;
    Node* next;
    Node(int data) {
        val = data;
        next = NULL;
    }
};
Node* swapNode(Node* head, int X) {
    if (!head || !head->next) return head;
    Node* dummy = new Node(-1);
    dummy->next = head;
    Node* prev = dummy;
    Node* curr = head;
    while (curr != NULL && curr->next != NULL) {
        if (curr->val == X) {
            Node* nextNode = curr->next;
            curr->next = nextNode->next;
            nextNode->next = curr;
            prev->next = nextNode;
            break;
        }
        prev = curr;
        curr = curr->next;
    }

    return dummy->next;
}
void printList(Node* head) {
    while (head != NULL) {
        cout << head->val;
        if (head->next != NULL) cout << " -> ";
        head = head->next;
    }
    cout << endl;
}
Node* createList(const vector<int>& nums) {
    if (nums.empty()) return NULL;
    Node* head = new Node(nums[0]);
    Node* curr = head;
    for (int i = 1; i < nums.size(); i++) {
        curr->next = new Node(nums[i]);
        curr = curr->next;
    }
    return head;
}
int main() {
    vector<int> nums = {1, 2, 3, 4};
    Node* head = createList(nums);
    cout << "Original list: ";
    printList(head);
    int X = 2;
    head = swapNode(head, X);
    cout << "List after swapping " << X << " with next node: ";
    printList(head);
    return 0;
}
