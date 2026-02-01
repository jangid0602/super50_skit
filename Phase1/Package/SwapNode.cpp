#include<bits/stdc++.h>
using namespace std;
class LL{
public:
    int data;
    LL* next;
    LL(int val)
    {
        data=val;
        next=NULL;
    }
}
LL* swapNodes(LL* head, int val) {
    if (head == NULL) {
        return NULL;
    }

    LL* prevX = NULL, * currX = head;
    while (currX != NULL && currX->data != val) {
        prevX = currX;
        currX = currX->next;
    }
    prevX->next=currX->next;
    currX->next=currX->next->next;
    return head;
}

int main()
{   int n;
    cout<<"Enter number of nodes:";
    cin>>n;
    int val;
    cout<<"Enter node value:";
    cin>>val;
    LL *head=new LL(val);
    LL *temp=head;
    for(int i=1;i<n;i++)
    {
        cout<<"Enter node value:";
        cin>>val;
        LL *newNode=new LL(val);
        temp->next=newNode;
        temp=temp->next;
    }
    while(head!=NULL)
    {
        cout<<head->data<<" ";
        head=head->next;
    }
    int swapVal;
    cout<<"Enter value to be swapped:";
    cin>>swapVal;
    head=swapNodes(head,swapVal);
    LL *curr=head;
    while(curr!=NULL)
    {
        cout<<curr->data<<" ";
        curr=curr->next;
    }
}
