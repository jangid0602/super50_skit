#include<iostream>
using namespace std;

class Node{
    public:

    int val;
    Node* next;

    Node(int data){
        val = data;
        next = NULL;
    }
};

Node* fun(Node* head,int val){

    if(head == NULL || head->next == NULL) return head;

    if(head->val == val){
        Node* right = head->next;
        head->next = right->next;
        right->next = head;
        return right;
    }

    Node* left = head;
    Node* temp = head->next;

    while(temp != NULL && temp->next != NULL){
        Node* right = temp->next;

        if(temp->val == val){
            left->next = right;
            temp->next = right->next;
            right->next = temp;
            break;
        }

        left = temp;
        temp = temp->next;
    }

    return head;
}


int main(){
  Node *x = new Node(1);
  x->next = new Node(2);
  x->next->next = new Node(3);
  x ->next->next->next = new Node(4);

  cout<<"The Link List is:";
  Node * temp = x;
  while(temp != NULL){
    cout<<temp->val<<" -> ";
    temp = temp->next;
  }
 
  int val;
  cout<<endl<<"Enter the value of X:";
 
  cin>>val;

  x = fun(x,val);
  cout<<"After the swapping the link list is:";
  temp  = x;
  while(temp != NULL){
    cout<<temp->val<<" -> ";
    temp = temp->next;
  }


return 0;
}



  
