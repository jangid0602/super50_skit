/**
 * @filename - Task-4.cpp
 * @description - The K-Zipline Merge
 * @author - Ayushi Shukla
 */

#include <iostream>
#include <vector>
using namespace std;

// Linked list node's definition
struct Node
{
    char value;
    Node *next;

    Node(char data) : value(data), next(nullptr) {}
};

// create linkedlist
Node *buildList(const vector<char> &elements)
{
    Node *headNode = nullptr;
    Node *tailNode = nullptr;

    for (char item : elements)
    {
        Node *newNode = new Node(item);

        if (!headNode)
            headNode = tailNode = newNode;
        else
        {
            tailNode->next = newNode;
            tailNode = newNode;
        }
    }
    return headNode;
}

// Print Linked List
void printList(Node *headNode)
{
    while (headNode)
    {
        cout << headNode->value;
        if (headNode->next)
            cout << " -> ";
        headNode = headNode->next;
    }
    cout << "\n";
}

// Take k Nodes from a List

Node *extractKNodes(Node *&currentHead, int k)
{
    if (!currentHead)
        return nullptr;

    Node *startNode = currentHead;
    Node *lastNode = nullptr;

    while (currentHead && k--)
    {
        lastNode = currentHead;
        currentHead = currentHead->next;
    }

    if (lastNode)
        lastNode->next = nullptr;

    return startNode;
}

// K-Zipline Merge Function

Node *kZiplineMerge(Node *head1, Node *head2, int k)
{
    Node *mergedHead = nullptr;
    Node *mergedTail = nullptr;

    bool takeFromList1 = true;

    while (head1 || head2)
    {

        Node *extractedChunk =
            (takeFromList1 ? extractKNodes(head1, k) : extractKNodes(head2, k));

        takeFromList1 = !takeFromList1;

        if (!extractedChunk)
            continue;

        if (!mergedHead)
            mergedHead = mergedTail = extractedChunk;
        else
            mergedTail->next = extractedChunk;

        while (mergedTail->next)
            mergedTail = mergedTail->next;
    }

    return mergedHead;
}

// Main Function
int main()
{

    int size1, size2, kValue;

    cout << "Enter size of List 1: ";
    cin >> size1;
    vector<char> list1Values(size1);

    cout << "Enter elements of List 1:\n";
    for (char &item : list1Values)
        cin >> item;

    cout << "Enter size of List 2: ";
    cin >> size2;
    vector<char> list2Values(size2);

    cout << "Enter elements of List 2:\n";
    for (char &item : list2Values)
        cin >> item;

    cout << "Enter value of k: ";
    cin >> kValue;

    Node *head1 = buildList(list1Values);
    Node *head2 = buildList(list2Values);

    cout << "\nList 1: ";
    printList(head1);

    cout << "List 2: ";
    printList(head2);

    Node *mergedList = kZiplineMerge(head1, head2, kValue);

    cout << "\nMerged (K-Zipline) List:\n";
    printList(mergedList);

    return 0;
}
