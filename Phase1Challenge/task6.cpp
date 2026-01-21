/**
 * @filename - task6.cpp
 * @description - Node Swap by value
 * @author - Fatimi Bee
 */
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

struct Node
{
    int data;
    Node *next;
    Node(int val) : data(val), next(nullptr) {}
};

Node *swap(Node *head, int x)
{
    if (!head)
        return NULL;
    Node *current = head;

    while (current && current->next)
    {
        if (current->data == x)
        {
            int temp = current->data;
            current->data = current->next->data;
            current->next->data = temp;
            current = current->next;
        }
        current = current->next;
    }
    return head;
}
void display(Node *head)
{
    if (!head)
        return;
    while (head)
    {
        cout << head->data;
        if (head->next)
            cout << "->";
        head = head->next;
    }
    cout << endl;
}
int main()
{
    Node *head = nullptr;
    int n, val;

    cout << "Enter number of nodes: ";
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        cout << "Enter value for node " << i + 1 << ": ";
        cin >> val;

        Node *newNode = new Node(val);
        if (head == nullptr)
        {
            head = newNode;
        }
        else
        {
            Node *temp = head;
            while (temp->next != nullptr)
            {
                temp = temp->next;
            }
            temp->next = newNode;
        }
    }
    cout << "Enter the value of x : ";
    int x;
    cin >> x;

    cout << "Before reverse" << endl;
    display(head);
    cout << "After swap by value" << endl;
    Node *newHead = swap(head, x);
    display(newHead);

    return 0;
}