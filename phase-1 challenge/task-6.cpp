// Node Swap by Value 

#include<iostream>
using namespace std;
class Node {
public:
    int data;
    Node* next;
    Node(int val) : data(val), next(nullptr) {}

    void function(Node* head,int X){
    Node* current = head;
    Node* prev = nullptr;
    while (current && current->next) {
        if (current->data == X) {
            Node* nextNode = current->next;
            current->next = nextNode->next;
            nextNode->next = current;
            if (prev) {
                prev->next = nextNode;
            } else {
                head = nextNode;
            }
            prev = current;
            current = current->next;
        } else {
            prev = current;
            current = current->next;
        }
    }
    cout << "Linked list after swapping:" << endl;
    current = head;
    while (current) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;

    current = head;
    while (current) {
        Node* temp = current;
        current = current->next;
        delete temp;
    }
}
};

int main(){
    int n, X;
    cout << "Enter the number of nodes in the linked list: ";
    cin >> n;
    cout << "Enter the value X to swap with its next node: ";
    cin >> X;
    Node* head = nullptr;
    Node* tail = nullptr;
    int val;
    cout << "Enter the node values:" << endl;
    for (int i = 0; i < n; ++i) {
        cin >> val;
        Node* newNode = new Node(val);
        if (!head) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }
    Node obj(val);
    obj.function(head,X);

    return 0;
}