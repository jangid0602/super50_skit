#include<bits/stdc++.h>
using namespace std;

class Node{
    public:
    int val;
    Node* next;
    Node(int val){
        this->val=val;
        next=NULL;
    }
};
void swapNode(Node *p,Node *q,Node *prev){
    Node *temp=new Node(0);
    p->next=q->next;
    prev->next=q;
    q->next=p;
}
Node *swapbyValue(Node* head,int x){
    if(head==NULL || head->next==NULL) return head;
    if(head->val==x){
        Node* first=head;
        Node* second=head->next;
        first->next=second->next;
        second->next=first;
        head=second;
    }
    Node* prev=NULL;
    Node* curr=head;
    Node* nxt=head->next;
    while(nxt!=NULL){
        if(curr->val==x){
            swapNode(curr,nxt,prev);
            curr=curr->next;
            nxt=curr->next;
        }
        else{
            prev=curr;
            curr=nxt;
            nxt=nxt->next;
        }
    }
    return head;
}

int main(){
    int n;
    cout<<"Enter number of nodes:";
    cin>>n;
    Node* head=NULL;
    Node* tail=NULL;
    cout<<"Enter node values:"<<endl;
    for(int i=0;i<n;i++){
        int val;
        cin>>val;
        Node* newNode=new Node(val);
        if(head==NULL){
            head=newNode;
            tail=newNode;
        }
        else{
            tail->next=newNode;
            tail=newNode;
        }
    }

    cout<<"Original Linked List:"<<endl;
    Node* temp=head;
    while(temp!=NULL){
        cout<<temp->val<<" ";
        temp=temp->next;
    }
    cout<<endl;
    cout<<"Enter value to swap:";
    int x;
    cin>>x;
    head=swapbyValue(head,x);
    cout<<"Linked List after swapping:"<<endl;
    temp=head;
    while(temp!=NULL){
        cout<<temp->val<<" ";
        temp=temp->next;
    }
    return 0;
}