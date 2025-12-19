/**
 * @filename   : Story4.cpp
 * @description: Merge two linked lists in alternating chunks of size k (K-Zipline Merge).
 * @author     : Ehtesham Nawaz
 */

#include <iostream>
using namespace std;

struct Node {
    string value;
    Node* next;

    Node(string val) {
        value = val;
        next = nullptr;
    }
};


Node* addAtEnd(Node* head, string val) {

    if(head == nullptr) {
        return new Node(val);
    }

    Node* temp = head;
    while(temp->next != nullptr) {
        temp = temp->next;
    }

    temp->next = new Node(val);
    return head;
}

// display linked list
void showList(Node* head) {
    while(head != nullptr) {
        cout << head->value << " ";
        head = head->next;
    }
    cout << endl;
}


Node* kZipMerge(Node* firstList, Node* secondList, int k) {

    if(firstList == nullptr) return secondList;
    if(secondList == nullptr) return firstList;

    Node dummyNode("temp");
    Node* tailPointer = &dummyNode;

    Node* ptr1 = firstList;
    Node* ptr2 = secondList;

    bool useFirst = true;

    while(ptr1 != nullptr || ptr2 != nullptr) {

        int taken = 0;

        if(useFirst) {
            while(ptr1 != nullptr && taken < k) {
                tailPointer->next = ptr1;
                tailPointer = tailPointer->next;
                ptr1 = ptr1->next;
                taken++;
            }
        } else {
            while(ptr2 != nullptr && taken < k) {
                tailPointer->next = ptr2;
                tailPointer = tailPointer->next;
                ptr2 = ptr2->next;
                taken++;
            }
        }

        useFirst = !useFirst;
    }

    tailPointer->next = nullptr;
    return dummyNode.next;
}



int main() {

    int count1, count2, k;
    string inputValue;

    Node* listOne = nullptr;
    Node* listTwo = nullptr;

    cout << "Enter number of nodes in first list: ";
    cin >> count1;

    cout << "Enter elements for first list:\n";
    for(int i = 0; i < count1; i++) {
        cin >> inputValue;
        listOne = addAtEnd(listOne, inputValue);
    }

    cout << "Enter number of nodes in second list: ";
    cin >> count2;

    cout << "Enter elements for second list:\n";
    for(int i = 0; i < count2; i++) {
        cin >> inputValue;
        listTwo = addAtEnd(listTwo, inputValue);
    }

    cout << "Enter value of k: ";
    cin >> k;

    Node* result = kZipMerge(listOne, listTwo, k);

    cout << "Merged List: ";
    showList(result);

    return 0;
}
