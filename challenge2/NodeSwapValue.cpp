#include <iostream>
#include <vector>
using namespace std;

class Node
{
public:
    int value;
    Node *Next;
    Node(int val)
    {
        value = val;
        Next = nullptr;
    }
};

Node *createList(const vector<int> &vals)
{
    if (vals.empty())
        return nullptr;
    Node *head = new Node(vals[0]);
    Node *cur = head;
    for (int i = 1; i < vals.size(); ++i)
    {
        cur->Next = new Node(vals[i]);
        cur = cur->Next;
    }
    return head;
}

void printList(Node *head)
{
    Node *cur = head;
    while (cur)
    {
        cout << cur->value;
        if (cur->Next)
            cout << " -> ";
        cur = cur->Next;
    }
    cout << '\n';
}

class NodeSwapValueSolver
{
public:
    Node *swapByValue(Node *head, int X)
    {
        if (!head)
            return head;
        Node *prev = nullptr;
        Node *cur = head;

        while (cur && cur->Next)
        {
            if (cur->value == X)
            {
                Node *A = cur;
                Node *B = cur->Next;
                if (prev)
                    prev->Next = B;
                else
                    head = B;
                A->Next = B->Next;
                B->Next = A;
                prev = A;
                cur = A->Next;
            }
            else
            {
                prev = cur;
                cur = cur->Next;
            }
        }
        return head;
    }
};

int main()
{
    NodeSwapValueSolver solver;

    Node *t1 = createList({1, 2, 3, 4});
    cout << "Test Case-1 BeforeSwap: ";
    printList(t1);
    t1 = solver.swapByValue(t1, 2);
    cout << "Test Case-1 AfterSwap:  ";
    printList(t1);
    cout << "\n";

    Node *t2 = createList({5, 6, 5, 7});
    cout << "Test Case-2 BeforeSwap: ";
    printList(t2);
    t2 = solver.swapByValue(t2, 5);
    cout << "Test Case-2 AfterSwap:  ";
    printList(t2);
    cout << "\n";

    Node *t3 = createList({1, 2});
    cout << "Test Case-3 BeforeSwap: ";
    printList(t3);
    t3 = solver.swapByValue(t3, 2);
    cout << "Test Case-3 AfterSwap:  ";
    printList(t3);

    return 0;
}