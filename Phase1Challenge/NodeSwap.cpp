#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
    int val;
    Node* next;
    Node(int val){
        this->val=val;
        this->next=NULL;
    }
};
void print(Node* head){
    Node* temp=head;
    while(temp!=NULL){
        cout<<temp->val;
        if(temp->next!=NULL) cout<<"->";
        temp=temp->next;
    }
}
Node* swap(Node* head,Node* temp,Node* prev){
    if(temp==NULL || temp->next==NULL) return head;
    Node* nextNode=temp->next;
    if(prev==NULL){
        temp->next=nextNode->next;
        nextNode->next=temp;
        return nextNode;
    }   
    prev->next=temp->next;
    temp->next=nextNode->next;
    nextNode->next=temp;
    return head;
}
int main(){
    int n;
    cout<<"enter number of nodes"<<endl;
    cin>>n;
    if(n==0){
        cout<<"No swap possible";
        return 0;
    }
    vector<int> nodes;
    cout<<"Enter nodes value"<<endl;
    for(int  i=0;i<n;i++){
        int value;
        cin>>value;
        nodes.push_back(value);
    }
    Node* head=new Node(nodes[0]);
    Node* temp=head;
    for(int i=1;i<n;i++){
        temp->next=new Node(nodes[i]);
        temp=temp->next;
    }
    temp=head;
    int x;
    cout<<"enter value of x"<<endl;
    cin>>x;
    Node* prev=NULL;
    while(temp!=NULL){
        if(temp->val==x){
            head=swap(head,temp,prev);
        }
        prev=temp;
        temp=temp->next;
    }
    print(head);
    return 0;
}