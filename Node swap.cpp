/*Node Swap by Value*/

#include <iostream>
using namespace std;

struct Node {
    int value;
    Node* next;
};

Node* swapByValue(Node* head, int X) {
    Node dummy;
    dummy.next = head;
    Node* prev = &dummy;
    Node* curr = head;

    while (curr != nullptr && curr->next != nullptr) {
        if (curr->value == X) {
        	
//        	Node* newNode = curr;
//        	prev->next= curr->next;
//        	newNode->next=curr->next->next;
//        	curr->next=curr;

            Node* newNode = curr->next;
            curr->next = newNode->next;
            newNode->next = curr;
            prev->next = newNode;
        } 
        prev = curr;
        curr = curr->next;
    }
    return dummy.next;
}

int main() {
    Node a{1}, b{2}, c{3}, d{4};
    a.next = &b; b.next = &c; c.next = &d; d.next = nullptr;

    Node* head = swapByValue(&a, 2);
    while (head != nullptr) {
        cout << head->value << " ";
        head = head->next;
    }
    return 0;
}

