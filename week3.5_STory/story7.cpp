/**
 * @filename - Story7.cpp
 * @description -  Mid Point Finder
 * @author - Fatimi Bee
 */

 #include<iostream>
using namespace std;
class Nodes{
    public :
    int data;
    Nodes* next;
    Nodes(int value){
        data = value;
        next = nullptr;
    }
};
Nodes* Insertion(Nodes* head , int value){
    Nodes* newNode = new Nodes(value);
    if(head == nullptr){
        return newNode;
    }
    Nodes* temporary = head;
    while(temporary->next != nullptr){
        temporary = temporary->next;
    }
    temporary->next = newNode;
    return head;
}

Nodes* middleFinder(Nodes* head){
    if(!head) return nullptr;
    Nodes* slow =head;
    Nodes* fast= head;
    while(fast != nullptr && fast->next != nullptr){
        slow=slow->next;
        fast=fast->next->next;
    }
    return slow;
}
int main(){
    Nodes *head = nullptr;
    int numberOfNodes;
    cout<<"Enter number of Nodes : ";
    cin>>numberOfNodes;

    for(int i=0;i<numberOfNodes; i++){
        int value;
        cout<<"Enter value for node " <<i+1<<": ";
        cin>>value;
        head= Insertion(head,value);
    }

    Nodes * middle = middleFinder(head);
    if(middle != nullptr){
        cout<<"The middle node value is : "<<middle->data<<endl;
    }
    return 0;
}