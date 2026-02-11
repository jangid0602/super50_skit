#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

Node* swapByValue(Node* head, int X) {
    if (head == NULL || head->next == NULL)
        return head;

    Node* prev = NULL;
    Node* curr = head;

    while (curr != NULL && curr->data != X) {
        prev = curr;
        curr = curr->next;
    }

    if (curr == NULL || curr->next == NULL)
        return head;

    Node* nextNode = curr->next;

    curr->next = nextNode->next;
    nextNode->next = curr;

    if (prev != NULL)
        prev->next = nextNode;
    else
        head = nextNode;  

    return head;
}

void printList(Node* head) {
    while (head != NULL) {
        cout << head->data << " ";
        head = head->next;
    }
}

int main() {
    int n, X;
    cout<<"enter the number of nodes n:";
    cin >> n;

    Node* head = NULL;
    Node* tail = NULL;
    
    cout<<"enter the nodes in sequence\n";
    for (int i = 0; i < n; i++) {
        int val;
        cin >> val;
        Node* temp = new Node(val);
        if (head == NULL) {
            head = tail = temp;
        } else {
            tail->next = temp;
            tail = temp;
        }
    }
    
    cout<<"enter the nodes X to be swapped:";
    cin >> X;

    head = swapByValue(head, X);
    printList(head);

    return 0;
}
