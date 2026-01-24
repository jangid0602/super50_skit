#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node(int v) {
        val=v;
        next=NULL;
    }
};

int main() {
    int t;
    cout<<"enter no of test case";
    cin >> t;
    
    while(t--){
        int n;
        cout<<"enter no of nodes\n";
        cin>>n;
        cout<<"enter nodes";
        int e;
        cin>>e;
        Node* head=new Node(e);
        Node* tail=head;

        for(int i=1;i<n;i++) {
            cin>>e;
            Node* n1=new Node(e);
            tail->next=n1;
            tail= n1;
        }
        cout<<"enter the value of k:----\n";
        int k;
        cin>>k;

        Node* temp=head;
        while(temp!= NULL&&temp->next!=NULL) {
            if (temp->val==k) {
                swap(temp->val,temp->next->val);
            }
            temp=temp->next;
        }

        temp=head;
        while(temp!=NULL) {
            cout<<temp->val<< " ";
            temp=temp->next;
        }
        cout<<"\n";
    }
}
