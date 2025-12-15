/**
 * @filename   : MidpointFinder.cpp
 * @description: Find the middle node of a singly linked list using the two-pointer technique.
 *               If the list has an even number of nodes, return the second middle node.
 * @author     : Ehtesham Nawaz
 */

#include <bits/stdc++.h>
using namespace std;

struct ListNode {
     string value;
    ListNode* next;

    ListNode(string x)  {
       this->value= x; 
        this->next=nullptr;

    }
};



string findMiddleNode(ListNode* head) {
   ListNode* fast=head;
   ListNode* slow=head;

   while(fast && fast->next){
        slow=slow->next;
        fast=fast->next->next;
   }
   return slow->value;
    
}

int main() {
    int numberOfNodes;
    cin >> numberOfNodes;  

    if (numberOfNodes == 0) return 0;

    string value;
    cin >> value;
    ListNode* head = new ListNode(value);
    ListNode* current = head;

    for (int i = 1; i < numberOfNodes; i++) {
        cin >> value;
        current->next = new ListNode(value);
        current = current->next;
    }

    cout << findMiddleNode(head) << endl;

    return 0;
}
