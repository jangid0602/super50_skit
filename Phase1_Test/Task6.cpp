// Node swap by value
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Node
{
public:
    int data;
    Node *next;
    Node(int val)
    {
        data=val;
        next =NULL;
    }
};

int main()
{
    int n, x;
    cout << "Enter numbernodes:";
    cin >> n;
    cout << "Enter values:";
    Node *head = NULL;
    Node *tail = NULL;
    for (int i =0;i<n;i++)
    {
        int val;
        cin >> val;
        Node *newNode = new Node(val);
        if (head==NULL)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail->next = newNode;
            tail = newNode;
        }
    }
    cout << "Enterx:";
    cin >>x;
    Node *curr = head;
    while (curr != NULL && curr->next != NULL)
    {
        if (curr->data == x)
        {
            swap(curr->data, curr->next->data);
            curr = curr->next->next;
        }
        else
        {
            curr = curr->next;
        }
    }
    cout << "new list:";
    curr = head;
    while (curr != NULL)
    {
        cout << curr->data << " ";
        curr = curr->next;
    }
    return 0;
}