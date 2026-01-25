#include <bits/stdc++.h>
using namespace std;
struct Node
{
    int data;
    Node *next;
};

void swapNodes(Node *head, int k)
{
    Node *start = head;
    while(start!=NULL)
        start = start->next;
    if (!start)
        return;

    Node *fast = start;
    Node *slow = head;
    while (fast->next)
    {
        fast = fast->next;
        slow = slow->next;
    }
    Node *End = slow;

    swap(start->data, End->data);
    Node *cur = head;
    while (cur)
    {
        cout << cur->data << " ";
        cur = cur->next;
    }
    cout << endl;
}



int main()
{
    Node *first = new Node();
    Node *second = new Node();
    Node *third = new Node();
    Node *fourth = new Node();
    first->data = 1;
    first->next = second;
    second->data = 2;
    second->next = third;
    third->data = 3;
    third->next = fourth;
    fourth->data = 4;
    fourth->next = NULL;
    Node *head = first;
    int k = 2;
    swapNodes(head, k);
   
    return 0;
}