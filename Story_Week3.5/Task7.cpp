/* @file: Task3.cpp
@Description: The MIdpoint finder
@Author: Ayushi Shukla */
#include <iostream>
using namespace std;
template <typename T>
class Node
{
public:
    T data;
    Node *next;
    // Constructor
    Node(T data)
    {
        this->data = data;
        this->next = NULL;
    }
};
template <typename T>
T findMiddle(Node<T> *head)
{
    Node<T> *slow = head;
    Node<T> *fast = head;
    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }
    return slow->data;
}
template <typename T>
void printList()
{
    int nodes;
    cout << "Enter number of nodes: ";
    cin >> nodes;
    if (nodes == 0)
    {
        cout << "List is empty";
        return;
    }

    T value;
    cout << "Enter node values: ";
    cin >> value;
    Node<T> *head = new Node<T>(value);
    Node<T> *tail = head;
    for (int i = 1; i < nodes; i++)
    {
        cin >> value;
        Node<T> *newNode = new Node<T>(value);
        tail->next = newNode;
        tail = tail->next;
    }
    cout << "Linked List: ";
    Node<T> *temp = head;
    while (temp != NULL)
    {
        cout << temp->data << " ";
        temp = temp->next;
    }
    cout << endl;
    cout << "Middle element: ";
    cout << findMiddle(head);
}
int main()
{
    char type;
    cout << "Enter type of linked list (i - int, c - char, d - double, f - float): ";
    cin >> type; // Input the type of linked list
    switch (type)
    {
    case 'i':
        printList<int>();
        break;
    case 'c':
        printList<char>();
        break;
    case 'd':
        printList<double>();
        break;
    case 'f':
        printList<float>();
        break;
    default:
        cout << "Invalid type";
    }
    return 0;
}